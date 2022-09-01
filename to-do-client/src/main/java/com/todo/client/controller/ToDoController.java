package com.todo.client.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.AxisFault;

import com.google.gson.Gson;
import com.todo.serviceSOA.conection.ToDoPortBindingStub;
import com.todo.serviceSOA.conection.ToDoService;
import com.todo.serviceSOA.conection.ToDoServiceLocator;
import com.todo.serviceSOA.service.ITodoService;
import com.todo.serviceSOA.service.ToDo;
import com.todo.serviceSOA.service.ToDoStatus;


/**
 * @author mgomezgarrote
 * Servlet para manejar las tareas
 *
 */

// Muy importante añadir la URL -> "" para que se carguen los archivos del css y js
// Ver -> https://stackoverflow.com/questions/33248473/change-default-homepage-in-root-path-to-servlet-with-doget
@WebServlet(urlPatterns = { "", "/new", "/list", "/delete", "/find", "/update" })

public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ITodoService operations = null;

	/**
	 *
	 * Método para inicializar la comunicación con el servicio SOAP
	 *
	 */
	@Override
	public void init() throws ServletException {

		ToDoService service = new ToDoServiceLocator();
		try {
			this.operations = new ToDoPortBindingStub(new URL(service.getToDoPortAddress()), service);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Manejar las distintas operaciones de la aplicación mediante un switch
		// que toma como caso una ruta (.../ruta)

		String operation = request.getServletPath();

		switch (operation) {
		case "/new":
			newToDo(request, response);
			break;

		case "/update":
			updateToDo(request, response);
			break;

		case "/delete":
			deleteToDo(request, response);
			break;

		case "/find":
			findToDo(request, response);
			break;

		default:
			listToDo(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	/**
	 * 
	 * Método para cargar todas las tareas, clasificadas según su tipo
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listToDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("todoPending", loadTodos(ToDoStatus.PENDING));
		request.setAttribute("todoProgress", loadTodos(ToDoStatus.IN_PROGRESS));
		request.setAttribute("todoFinalized", loadTodos(ToDoStatus.FINALIZED));
		
		// Se utliza forward para enviar los datos a una JSP
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * 
	 * Método para crear una nueva tarea
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void newToDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtener parametros del formulario
		String nameParam = request.getParameter("name");
		String descriptionParam = request.getParameter("description");
		String statusParam = request.getParameter("status");

		// Guardar en la base de datos
		ToDo todo = new ToDo();
		todo.setName(nameParam);
		todo.setDescription(descriptionParam);
		
		if (statusParam.equalsIgnoreCase(ToDoStatus.PENDING.toString())) {
			todo.setToDoStatus(ToDoStatus.PENDING);
		} else if (statusParam.equalsIgnoreCase(ToDoStatus.IN_PROGRESS.toString())) {
			todo.setToDoStatus(ToDoStatus.IN_PROGRESS);
		} else {
			todo.setToDoStatus(ToDoStatus.FINALIZED);
		}

		operations.updateToDo(todo);
		
		// Se utliza sendRedirect para aplicar el patron PRG (POST REDIRECT GET)
		// Una vez realizada la operación la aplicación redirige a ../list
		// donde se entrará en la opción default del switch para actualizar los datos
		response.sendRedirect("list");

	}

	/**
	 * 
	 * Método para actualizar una tarea ya existente
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateToDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener parametros del formulario
		String idParam = request.getParameter("idToDo");
		String nameParam = request.getParameter("name");
		String descriptionParam = request.getParameter("description");
		String statusParam = request.getParameter("status");

		ToDo todo = new ToDo();
		
		// Es necesario una id para identificar que se trata de una operación
		// de actualización
		todo.setId(Integer.parseInt(idParam));
		todo.setName(nameParam);
		todo.setDescription(descriptionParam);
		if (statusParam.equalsIgnoreCase(ToDoStatus.PENDING.toString())) {
			todo.setToDoStatus(ToDoStatus.PENDING);
		} else if (statusParam.equalsIgnoreCase(ToDoStatus.IN_PROGRESS.toString())) {
			todo.setToDoStatus(ToDoStatus.IN_PROGRESS);
		} else {
			todo.setToDoStatus(ToDoStatus.FINALIZED);
		}

		operations.updateToDo(todo);

		response.sendRedirect("list");

	}

	/**
	 * 
	 * Método para borrar una tarea
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteToDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtener parametro del enlace
		String idParam = request.getParameter("id");

		// Borrar tarea
		operations.deleteToDo(Integer.parseInt(idParam));

		response.sendRedirect("list");

	}

	/**
	 * 
	 * Método para devolver una tarea según su id en formato JSON,
	 * necesario para cargar los datos en el modal de actualización
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void findToDo(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, IOException {

		String id = request.getParameter("id");
		ToDo todo = operations.findToDoById(Integer.parseInt(id));
		String json = new Gson().toJson(todo);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

	/**
	 * 
	 * Método que devuelve una lista de tareas de un estado determinado
	 * 
	 * @param status
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 */
	private List<ToDo> loadTodos(ToDoStatus status) throws MalformedURLException, RemoteException {

		List<ToDo> todos = new ArrayList<>();

		if (operations.findAllToDosByStatus(status) != null) {

			for (ToDo todo : operations.findAllToDosByStatus(status)) {

				todos.add(todo);
			}

			return todos;

		}

		return null;

	}

}

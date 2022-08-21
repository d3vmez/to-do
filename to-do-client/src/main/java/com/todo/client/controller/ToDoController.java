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

import com.todo.serviceSOA.conection.ToDoPortBindingStub;
import com.todo.serviceSOA.conection.ToDoService;
import com.todo.serviceSOA.conection.ToDoServiceLocator;
import com.todo.serviceSOA.service.ITodoService;
import com.todo.serviceSOA.service.ToDo;
import com.todo.serviceSOA.service.ToDoStatus;

/**
 * Servlet implementation class TodoController
 */
@WebServlet(urlPatterns = {"", "/new","/list"})

public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ITodoService operations = null;
       
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getServletPath();

		System.out.println(operation);
		
		switch (operation) {
		case "/new":
			System.out.println("caca");
			newToDo(request, response);
			break;
			
		case "/update":
			System.out.println("caca");
			updateToDo(request, response);
			break;
			
		case "/delete":
			System.out.println("caca");
			deleteToDo(request, response);
			break;

		default:
			
			System.out.println("entro ");
			listToDo(request, response);
			
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
	private void listToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("todoPending", loadTodos(ToDoStatus.PENDING));
		request.setAttribute("todoProgress", loadTodos(ToDoStatus.IN_PROGRESS));
		request.setAttribute("todoFinalized", loadTodos(ToDoStatus.FINALIZED));
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void newToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void updateToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void deleteToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private List<ToDo> loadTodos(ToDoStatus status) throws MalformedURLException, RemoteException {
		
		List<ToDo> todos = new ArrayList<>();

	
		for (ToDo todo : operations.findAllToDosByStatus(status)) {
			
			todos.add(todo);
		}
		
		return todos;
			
	}
	

}

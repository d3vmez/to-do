package com.todo.serviceSOA.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.todo.serviceSOA.model.ToDo;
import com.todo.serviceSOA.model.ToDoStatus;

@WebService
public interface ITodoService {
	
	// Método para encontrar una tarea por su id
	@WebMethod(operationName = "findToDoById")
	@WebResult(name = "ToDo")
	public ToDo getById(@WebParam(name = "idToDo") int id);
	
	// Método para encontrar tareas por su estado
	@WebMethod(operationName = "findAllToDosByStatus")
	@WebResult(name = "ToDo")
	public List<ToDo> getAllByStatus(@WebParam(name = "ToDoStatus") ToDoStatus status); 
	
	// Método para encontrar todas las tareas
	@WebMethod(operationName = "findAllToDos")
	@WebResult(name = "ToDo")
	public List<ToDo> getAll();
	
	// Método para guardar una tarea
	@WebMethod(operationName = "updateToDo")
	@WebResult(name = "ToDo")
	public ToDo save(@WebParam(name = "ToDo") ToDo assignment);
	
	// Método para eliminar una tarea
	@WebMethod(operationName = "deleteToDo")
	public void deleteById(@WebParam(name = "idToDo") int id);

}

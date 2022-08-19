package com.todo.serviceSOA.service.impl;

import java.util.List;

import javax.jws.WebService;

import com.todo.serviceSOA.dao.IToDoDAO;
import com.todo.serviceSOA.dao.impl.ToDoDAO;
import com.todo.serviceSOA.model.ToDo;
import com.todo.serviceSOA.model.ToDoStatus;
import com.todo.serviceSOA.service.ITodoService;

@WebService(endpointInterface = "com.todo.serviceSOA.service.ITodoService"
, name = "ToDo", serviceName = "ToDoService", targetNamespace = "com.todo.serviceSOA.conection")
public class ToDoService implements ITodoService{
	
	private IToDoDAO assigmentDAO = new ToDoDAO();

	@Override
	public ToDo getById(int id) {
		return assigmentDAO.getById(id).get();
	}

	@Override
	public List<ToDo> getAllByStatus(ToDoStatus status) {
		return assigmentDAO.getAllByStatus(status);
	}

	@Override
	public List<ToDo> getAll() {
		return assigmentDAO.getAll();
	}

	@Override
	public ToDo save(ToDo assignment) {
		return assigmentDAO.save(assignment);
	}

	@Override
	public void deleteById(int id) {
		assigmentDAO.deleteById(id);	
	}

}

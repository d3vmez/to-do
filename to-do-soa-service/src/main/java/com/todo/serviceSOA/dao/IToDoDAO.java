package com.todo.serviceSOA.dao;

import java.util.List;
import java.util.Optional;

import com.todo.serviceSOA.model.ToDo;
import com.todo.serviceSOA.model.ToDoStatus;

public interface IToDoDAO {
	
	// M�todo para encontrar una tarea por su id
	public Optional<ToDo> getById(int id);
	
	// M�todo para encontrar tareas por su estado
	public List<ToDo> getAllByStatus(ToDoStatus status); 
	
	// M�todo para encontrar todas las tareas
	public List<ToDo> getAll();
	
	// M�todo para guardar una tarea
	public ToDo save(ToDo assignment);
	
	// M�todo para eliminar una tarea
	public void deleteById(int id);

}

package com.todo.serviceSOA.dao;

import java.util.List;
import java.util.Optional;

import com.todo.serviceSOA.model.ToDo;
import com.todo.serviceSOA.model.ToDoStatus;

public interface IToDoDAO {
	
	// Método para encontrar una tarea por su id
	public Optional<ToDo> getById(int id);
	
	// Método para encontrar tareas por su estado
	public List<ToDo> getAllByStatus(ToDoStatus status); 
	
	// Método para encontrar todas las tareas
	public List<ToDo> getAll();
	
	// Método para guardar una tarea
	public ToDo save(ToDo assignment);
	
	// Método para eliminar una tarea
	public void deleteById(int id);

}

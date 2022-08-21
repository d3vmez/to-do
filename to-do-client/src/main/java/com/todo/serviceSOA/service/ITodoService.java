/**
 * ITodoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.todo.serviceSOA.service;

public interface ITodoService extends java.rmi.Remote {
    public com.todo.serviceSOA.service.ToDo updateToDo(com.todo.serviceSOA.service.ToDo toDo) throws java.rmi.RemoteException;
    public com.todo.serviceSOA.service.ToDo findToDoById(int idToDo) throws java.rmi.RemoteException;
    public com.todo.serviceSOA.service.ToDo[] findAllToDosByStatus(com.todo.serviceSOA.service.ToDoStatus toDoStatus) throws java.rmi.RemoteException;
    public com.todo.serviceSOA.service.ToDo[] findAllToDos() throws java.rmi.RemoteException;
    public void deleteToDo(int idToDo) throws java.rmi.RemoteException;
}

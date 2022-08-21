package com.todo.serviceSOA.service;

public class ITodoServiceProxy implements com.todo.serviceSOA.service.ITodoService {
  private String _endpoint = null;
  private com.todo.serviceSOA.service.ITodoService iTodoService = null;
  
  public ITodoServiceProxy() {
    _initITodoServiceProxy();
  }
  
  public ITodoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initITodoServiceProxy();
  }
  
  private void _initITodoServiceProxy() {
    try {
      iTodoService = (new com.todo.serviceSOA.conection.ToDoServiceLocator()).getToDoPort();
      if (iTodoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iTodoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iTodoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iTodoService != null)
      ((javax.xml.rpc.Stub)iTodoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.todo.serviceSOA.service.ITodoService getITodoService() {
    if (iTodoService == null)
      _initITodoServiceProxy();
    return iTodoService;
  }
  
  public com.todo.serviceSOA.service.ToDo updateToDo(com.todo.serviceSOA.service.ToDo toDo) throws java.rmi.RemoteException{
    if (iTodoService == null)
      _initITodoServiceProxy();
    return iTodoService.updateToDo(toDo);
  }
  
  public com.todo.serviceSOA.service.ToDo findToDoById(int idToDo) throws java.rmi.RemoteException{
    if (iTodoService == null)
      _initITodoServiceProxy();
    return iTodoService.findToDoById(idToDo);
  }
  
  public com.todo.serviceSOA.service.ToDo[] findAllToDosByStatus(com.todo.serviceSOA.service.ToDoStatus toDoStatus) throws java.rmi.RemoteException{
    if (iTodoService == null)
      _initITodoServiceProxy();
    return iTodoService.findAllToDosByStatus(toDoStatus);
  }
  
  public com.todo.serviceSOA.service.ToDo[] findAllToDos() throws java.rmi.RemoteException{
    if (iTodoService == null)
      _initITodoServiceProxy();
    return iTodoService.findAllToDos();
  }
  
  public void deleteToDo(int idToDo) throws java.rmi.RemoteException{
    if (iTodoService == null)
      _initITodoServiceProxy();
    iTodoService.deleteToDo(idToDo);
  }
  
  
}
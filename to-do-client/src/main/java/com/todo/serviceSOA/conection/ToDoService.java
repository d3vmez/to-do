/**
 * ToDoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.todo.serviceSOA.conection;

public interface ToDoService extends javax.xml.rpc.Service {
    public java.lang.String getToDoPortAddress();

    public com.todo.serviceSOA.service.ITodoService getToDoPort() throws javax.xml.rpc.ServiceException;

    public com.todo.serviceSOA.service.ITodoService getToDoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

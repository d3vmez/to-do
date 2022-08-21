/**
 * ToDoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.todo.serviceSOA.conection;

public class ToDoServiceLocator extends org.apache.axis.client.Service implements com.todo.serviceSOA.conection.ToDoService {

    public ToDoServiceLocator() {
    }


    public ToDoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ToDoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ToDoPort
    private java.lang.String ToDoPort_address = "http://localhost:8085/WS_SOA/ToDo";

    public java.lang.String getToDoPortAddress() {
        return ToDoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ToDoPortWSDDServiceName = "ToDoPort";

    public java.lang.String getToDoPortWSDDServiceName() {
        return ToDoPortWSDDServiceName;
    }

    public void setToDoPortWSDDServiceName(java.lang.String name) {
        ToDoPortWSDDServiceName = name;
    }

    public com.todo.serviceSOA.service.ITodoService getToDoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ToDoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getToDoPort(endpoint);
    }

    public com.todo.serviceSOA.service.ITodoService getToDoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.todo.serviceSOA.conection.ToDoPortBindingStub _stub = new com.todo.serviceSOA.conection.ToDoPortBindingStub(portAddress, this);
            _stub.setPortName(getToDoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setToDoPortEndpointAddress(java.lang.String address) {
        ToDoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.todo.serviceSOA.service.ITodoService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.todo.serviceSOA.conection.ToDoPortBindingStub _stub = new com.todo.serviceSOA.conection.ToDoPortBindingStub(new java.net.URL(ToDoPort_address), this);
                _stub.setPortName(getToDoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ToDoPort".equals(inputPortName)) {
            return getToDoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("com.todo.serviceSOA.conection", "ToDoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("com.todo.serviceSOA.conection", "ToDoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ToDoPort".equals(portName)) {
            setToDoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

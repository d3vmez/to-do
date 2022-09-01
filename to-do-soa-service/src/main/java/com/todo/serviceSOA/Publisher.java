package com.todo.serviceSOA;

import javax.xml.ws.Endpoint;

import com.todo.serviceSOA.service.impl.ToDoService;

/**
 * @author mgomezgarrote
 * 
 * Clase publicadora, inicializa el servicio SOAP
 *
 */
public class Publisher {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8085/WS_SOA/ToDo", new ToDoService());

	}

}

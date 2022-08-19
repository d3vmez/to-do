package com.todo.client.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoController
 */
@WebServlet(urlPatterns = {"", "/new","/list"})

public class ToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	List<String> list = null;
       
	@Override
	public void init() throws ServletException {
		
		list = new ArrayList<>();
		list.add("hola");
		list.add("adios");
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
		
		request.setAttribute("data", this.list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void newToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void updateToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void deleteToDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

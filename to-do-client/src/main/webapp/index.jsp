<%@page import="com.todo.serviceSOA.service.ToDoStatus"%>
<%@page import="com.todo.serviceSOA.service.ToDo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tareas</title>
<link rel='stylesheet' type='text/css' media='screen'
	href="<%=request.getContextPath()%>/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#newModal">Crear tarea</button>
	</header>

	<section class="row justify-content-center">

		<div class="lista-tareas col-4">
			<h2>Tareas pendientes</h2>
			<%
			try {
				ArrayList<ToDo> todosPending = (ArrayList) request.getAttribute("todoPending");
				for (ToDo todo : todosPending) {
			%>

			<div class="tarea">
				<h3><%=todo.getName()%></h3>
				<p><%=todo.getDescription()%></p>
				<button type="button" class="btn btn-danger" data-bs-toggle="modal"
					data-bs-target="#deleteModal" data-id="<%=todo.getId()%>">Borrar</button>
				<button type="button" class="btn btn-secondary"
					data-bs-toggle="modal" data-bs-target="#updateModal"
					data-id="<%=todo.getId()%>">Actualizar</button>
			</div>

			<%
			}
			} catch (NullPointerException e) {
			%>

			<p>No hay tareas</p>

			<%
			}
			%>

		</div>

		<div class="lista-tareas col-4">
			<h2>Tareas pendientes</h2>
			<%
			try {
				ArrayList<ToDo> todosPending = (ArrayList) request.getAttribute("todoProgress");
				for (ToDo todo : todosPending) {
			%>

			<div class="tarea">
				<h3><%=todo.getName()%></h3>
				<p><%=todo.getDescription()%></p>
				<button type="button" class="btn btn-danger" data-bs-toggle="modal"
					data-bs-target="#deleteModal" data-id="<%=todo.getId()%>">Borrar</button>
				<button type="button" class="btn btn-secondary"
					data-bs-toggle="modal" data-bs-target="#updateModal"
					data-id="<%=todo.getId()%>">Actualizar</button>
			</div>

			<%
			}
			} catch (NullPointerException e) {
			%>

			<p>No hay tareas</p>

			<%
			}
			%>

		</div>

		<div class="lista-tareas col-4">
			<h2>Tareas pendientes</h2>
			<%
			try {
				ArrayList<ToDo> todosPending = (ArrayList) request.getAttribute("todoFinalized");
				for (ToDo todo : todosPending) {
			%>

			<div class="tarea">
				<h3><%=todo.getName()%></h3>
				<p><%=todo.getDescription()%></p>
				<button type="button" class="btn btn-danger" data-bs-toggle="modal"
					data-bs-target="#deleteModal" data-id="<%=todo.getId()%>">Borrar</button>
				<button type="button" class="btn btn-secondary"
					data-bs-toggle="modal" data-bs-target="#updateModal"
					data-id="<%=todo.getId()%>">Actualizar</button>
			</div>

			<%
			}
			} catch (NullPointerException e) {
			%>

			<p>No hay tareas</p>

			<%
			}
			%>

		</div>
		
	</section>
	
	<footer>
	
		<p>https://github.com/mg0mez/</p>
	
	</footer>

	<!-- Modals -->
	<jsp:include page="fragments/modals/createModal.jsp" />
	<jsp:include page="fragments/modals/deleteModal.jsp" />
	<jsp:include page="fragments/modals/updateModal.jsp" />
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	
	<script>var contextPath = "${pageContext.request.contextPath}";</script>
	<script  src="<%=request.getContextPath()%>/js/scripts.js"></script>

</body>
</html>
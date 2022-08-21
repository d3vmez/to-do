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
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' media='screen'
	href="<%= request.getContextPath() %>/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>



<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#exampleModal">Crear tarea</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form method="post"
				action="${pageContext.request.contextPath}/new">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Crear nueva
							tarea</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<div class="modal-body">


						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">Nombre
								tarea:</label> <input type="text" class="form-control"
								id="name" name="name">
						</div>
						<div class="mb-3">
							<label for="message-text" class="col-form-label">Descripción:</label>
							<textarea class="form-control" id="message-text" name="description"></textarea>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<input type="submit" class="btn btn-primary" value="Crear tarea">
					</div>

				</div>
			</form>
		</div>
	</div>

	<section>

		<div class="lista-tareas">
			<h2>Tareas pendientes</h2>
			<%
			ArrayList<ToDo> todosPending = (ArrayList) request.getAttribute("todoPending");
			for (ToDo todo : todosPending) {
			%>

			<div class="tarea">
				<h3><%=todo.getName()%></h3>
				<p><%=todo.getDescription()%></p>
				<input type="button" value="Eliminar"> <input type="button"
					value="Actualizar">
			</div>

			<%
			}
			%>

		</div>

		<div class="lista-tareas">
			<h2>Tareas en progreso</h2>
			<%
			ArrayList<ToDo> todosProgress = (ArrayList) request.getAttribute("todoProgress");
			for (ToDo todo : todosProgress) {
			%>

			<div class="tarea">
				<h3><%=todo.getName()%></h3>
				<p><%=todo.getDescription()%></p>
				<input type="button" value="Eliminar"> <input type="button"
					value="Actualizar">
			</div>

			<%
			}
			%>
		</div>

		<div class="lista-tareas">
			<h2>Tareas finalizadas</h2>
			<%
			ArrayList<ToDo> todosFinalized = (ArrayList) request.getAttribute("todoFinalized");
			for (ToDo todo : todosFinalized) {
			%>

			<div class="tarea">
				<h3><%=todo.getName()%></h3>
				<p><%=todo.getDescription()%></p>
				<input type="button" value="Eliminar"> <input type="button"
					value="Actualizar">
			</div>

			<%
			}
			%>
		</div>

	</section>

	<footer>
		<p>Marcos</p>
	</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>
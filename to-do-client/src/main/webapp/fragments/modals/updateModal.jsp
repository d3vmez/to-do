<%@page import="com.todo.serviceSOA.service.ToDoStatus"%>


<!-- Update Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form method="post"
				action="${pageContext.request.contextPath}/update" id="form">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Actualizar
							tarea</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<div class="modal-body">

						<input type="hidden" id="idToDo" name="idToDo">

						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">Nombre
								tarea:</label> <input type="text" class="form-control" id="name"
								name="name">
						</div>

						<div class="mb-3">
							<select class="form-select" name="status" id="status">
								<option value="<%=ToDoStatus.PENDING%>">Pendiente</option>
								<option value="<%=ToDoStatus.IN_PROGRESS%>">En
									progreso</option>
								<option value="<%=ToDoStatus.FINALIZED%>">Finalizada</option>
							</select>
						</div>

						<div class="mb-3">
							<label for="message-text" class="col-form-label">Descripción:</label>
							<textarea class="form-control" id="description"
								name="description"></textarea>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<input type="submit" class="btn btn-primary" value="Actualizar tarea">
					</div>

				</div>
			</form>
		</div>
	</div>

	<!-- Fin Modal -->

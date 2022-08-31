	<!-- Delete Modal -->
	<div class="modal" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-danger" id="exampleModalLabel">Borrar
						tarea</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">¿Estás seguro de borrar la tarea?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancelar</button>
					<a class="btn btn-danger"
						href="${pageContext.request.contextPath}/delete?id=">Borrar</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Fin Modal -->
		// función para el modal de borrado
		$(document).ready(function() {
			$('#deleteModal').on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget);
				var data = button.data('id');
				var modal = $(this);
				var a = modal.find('.modal-footer a')[0];

				a.href += data;
				data = " ";

			});
		});

		// función para el modal de actualización
		$(document).ready(function() {
			$('#updateModal').on('show.bs.modal', function(event) {

				var button = $(event.relatedTarget);
				var id = button.data('id');
				var modal = $(this);
				// var a = modal.find('#form')[0];
				// a.action += '?id=' + id;

				// petición para obtener los datos de la tarea que se quiere actualizar
				$.ajax({
					type : 'GET',
					// contextPath se inicializa en la JSP
					url : contextPath + '/find?id=' + id,
					success : function(todo) {

						// Cargar campos con los valores del JSON
						$('#updateModal #idToDo').val(todo.id);
						$('#updateModal #name').val(todo.name);
						$('#updateModal #description').val(todo.description);
						
						if(JSON.stringify(todo.toDoStatus).includes("PENDING")){
							$('#updateModal #status').val("PENDING").change();
						}
						
						else if(JSON.stringify(todo.toDoStatus).includes("IN_PROGRESS")){
							$('#updateModal #status').val("IN_PROGRESS").change();
						}
						
						else{
							$('#updateModal #status').val("FINALIZED").change();
						}
						
					}
				});
			});
		});
/*
 * Funcion para enviar id al servlet.
 */
function confirmarEliminacion(id){
		if (confirm("¿Esta seguro que desea eliminar este alumno?")){
			location.href='./eliminar.html?id='+id;
		}
		
		
	}

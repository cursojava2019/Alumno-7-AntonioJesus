/*
 * Funcion para enviar id al servlet.
 */
function confirmarEliminacion(id){
		if (confirm("¿Esta seguro que desea eliminarlo de la BBDD?")){
			location.href='./eliminar.html?id='+id;
		}
		
		
	}

function confirmarBaja(id){
	if (confirm("¿Esta seguro que desea dar de baja a este alumno?")){
		location.href='./baja.html?id='+id;
	}
	
	
}

function confirmaralta(id){
	if (confirm("¿Esta seguro que desea dar de baja a este alumno?")){
		location.href='./alta.html?id='+id;
	}
	
	
}

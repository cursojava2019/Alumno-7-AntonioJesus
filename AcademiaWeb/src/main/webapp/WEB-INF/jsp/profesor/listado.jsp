<%@page import="java.util.ArrayList"%>
<%@page import="academia.model.entities.Profesor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	List<Profesor> listado=(List<Profesor>)request.getAttribute("listado");
	if (listado==null){
		listado=new ArrayList<Profesor>();
	}
	String patronBusqueda= request.getParameter("patron");
  if (patronBusqueda==null) patronBusqueda=""; 
  
 String mensaje= request.getParameter("mensaje");
 Boolean mensajeOK=false;
 Boolean mensajeError=false;
 if (mensaje!=null) {
 		if (mensaje.equalsIgnoreCase("correcto")) {
 			mensajeOK=true;
 		}
 		if (mensaje.equalsIgnoreCase("errorId")) {
 			mensajeError=true;
 		}
 }
%>    
    
<!DOCTYPE html>
<html>
<%@include file="../plantilla/head.jsp" %>
<body>
	<script>
	function confirmarEliminacion(id){
		if (confirm("¿Está seguro que desea eliminar este alumno?")){
			location.href='<%=request.getContextPath()%>/admin/profesor/eliminar.html?id='+id;
		}
		
		
	}
	</script>
    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="../plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Profesores</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<div class="panel panel-default">
                        <%if (mensajeOK){ %>
                        <div class="alert alert-success" id="mensaje">
                               Operación realizada correctamente
                            </div>
                            <%} %>
                             <%if (mensajeError){ %>
                        <div class="alert alert-danger" id="mensaje">
                               Id no encontrado. No es posible realizar la operación.
                            </div>
                            <%} %>
                            
                            
                        <div class="panel-heading">
                            Listado de Profesores
                        </div>
                        
                        <form name="buscador" action="./listado.html" method="post">
                        <div class="">
                        <div class="col-6">
                        <label>Buscar Profesores</label>
                        </div>
                        <div style="float:right;">  <button class="btn btn-default"  onclick="location.href='<%=request.getContextPath()%>/admin/profesor/nuevo.html';" type="button"><i class="fa fa-user"> Nuevo Usuario</i>
                                                </button></div>
                        <div class="col-6">
                                            <input class="" name="patron" type="text" value="<%=patronBusqueda%>">
                                            <span class="">
                                                <button class="btn btn-default" type="submit"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                            <%if (!patronBusqueda.equals("")) { %>
                                            <span>Busqueda filtrada por <strong><%=patronBusqueda %> </strong></span>
                                            
                                            <%} %>
                                            </div>
                                        </div>
                                        
                                        
                        </form>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>DNI</th>
                                        <th>Telefono</th>
                                        <th>Titulacion</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% for(int i=0; i<listado.size();i++) {
                                	Profesor profesor=listado.get(i);	
                                %>
                                    <tr class="odd gradeX">
                                        <td><%=profesor.getNombre()%></td>
                                        <td><%=profesor.getApellido1()%> <%=profesor.getApellido2()%></td>
                                        <td><%=profesor.getNif()%></td>
                                        <td ><%=profesor.getTlf()%></td>
                                    	<td ><%=profesor.getTitulacion()%></td>
                                        <td ><a href="<%=request.getContextPath()%>/admin/profesor/modificar.html?id=<%=profesor.getId()%>">Modificar</a> <a href="#" onclick="confirmarEliminacion(<%=profesor.getId()%>)">Eliminar</a></td>
                                    </tr>
                                <% } %>   
                                </tbody>
                            </table>
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="../plantilla/javascriptPie.jsp" %>
	 <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        setTimeout(function() {
            $("#mensaje").toggle(2000);
        },3000);
    });
    
    
   
    </script>
    
	
</body>
</html>
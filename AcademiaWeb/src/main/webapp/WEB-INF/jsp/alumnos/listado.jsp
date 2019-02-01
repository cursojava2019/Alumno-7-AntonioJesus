<%@page import="java.util.ArrayList"%>
<%@page import="academia.model.entities.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	List<Alumno> listado=(List<Alumno>)request.getAttribute("listado");
	if (listado==null){
		listado=new ArrayList<Alumno>();
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
			location.href='<%=request.getContextPath()%>/admin/alumnos/eliminar.html?id='+id;
		}
		
		
	}
	</script>
    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="../plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Alumnos</h1>
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
                            Listado de Alumnos
                        </div>
                        
                        <form name="buscador" action="./listado.html" method="post">
                        <div class="">
                        <div class="col-6">
                        <label>Buscar Alumno</label>
                        </div>
                        <div style="float:right;">  <button class="btn btn-default"  onclick="location.href='<%=request.getContextPath()%>/admin/alumnos/nuevo.html';" type="button"><i class="fa fa-user"> Nuevo Usuario</i>
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
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% for(int i=0; i<listado.size();i++) {
                                	Alumno alumno=listado.get(i);	
                                %>
                                    <tr class="odd gradeX">
                                        <td><%=alumno.getNombre()%></td>
                                        <td><%=alumno.getApellido1()%> <%=alumno.getApellido2()%></td>
                                        <td><%=alumno.getNif()%></td>
                                        <td ><%=alumno.getTlf()%></td>
                                        <td ><a href="<%=request.getContextPath()%>/admin/alumnos/modificar.html?id=<%=alumno.getId()%>">Modificar</a> <a href="#" onclick="confirmarEliminacion(<%=alumno.getId()%>)">Eliminar</a></td>
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
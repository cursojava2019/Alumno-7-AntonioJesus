<%@page import="java.util.ArrayList"%>
<%@page import="es.indra.academia.controller.profesores.ProfesorForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
List<String> errores= (List<String>)request.getAttribute("errores");
ProfesorForm formulario= (ProfesorForm)request.getAttribute("formulario");
if (errores==null){
	errores=new ArrayList<String>();
}
if (formulario==null){
	formulario=new ProfesorForm();
}
%>
<html>
<%@include file="../plantilla/head.jsp" %>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="../plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Nuevo Profesor</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
              <div class="panel panel-default">
                        <div class="panel-heading">
                            Formulario de Alta
                        </div>
                        <div class="panel-body">
                        
                            <div class="row">
                                <div class="col-lg-6">
                                <%if (errores.size()>0) {%>
	                                <div class="alert alert-danger">
	                               		<%for(int i=0;i<errores.size();i++){ %>
	                               			<p><%=errores.get(i)%></p>
	                               		<%} %>
	                           		 </div>
                           			 
                           		<%} %>
                                <form role="form" action="./nuevo.html" method="post">
                                        <div class="form-group">
                                            <label>NIF</label>
                                            <input name="nif" class="form-control" value="<%=formulario.getNif()%>">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input name="nombre" class="form-control" value="<%=formulario.getNombre()%>">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Primer Apellido </label>
                                            <input name="apellido1" class="form-control" value="<%=formulario.getApellido1()%>">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Segundo Apellido</label>
                                            <input name="apellido2" class="form-control" value="<%=formulario.getApellido2()%>">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                            <input name="telefono" class="form-control" type="text" value="<%=formulario.getTelefono()%>">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <input name="email" class="form-control" type="email" value="<%=formulario.getCorreo()%>">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Titulacion</label>
                                            <input name="titulacion" class="form-control" value="<%=formulario.getTitulacion()%>">
                                            <p class="help-block"></p>
                                        </div>
                                      
                                        <button type="submit" class="btn btn-default">Enviar</button>
                                        <button type="reset" class="btn btn-default">Limpiar</button>
                                    </form>
                                </div>
                               
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
            
            </div>
            
            
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="../plantilla/javascriptPie.jsp" %>

</body>
</html>
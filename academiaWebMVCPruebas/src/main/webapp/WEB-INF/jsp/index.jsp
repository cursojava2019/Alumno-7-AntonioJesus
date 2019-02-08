<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="./plantilla/head.jsp" %>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="./plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Pantalla Principal Proyecto Academia</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<h3>Bienvenido a la gestión de la academia, Identifiquese:</h3>
            	
            </div>
           
	        <div class="col-lg-4">
	        	<br><br>
	            	<form role="form" action="./j_spring_security_check" method="post">
		            	<div class="form-group">
		                     <label>Usuario</label>
		                     <input name="j_username" class="form-control" type="text" >
		                     <p class="help-block"></p>
		               </div>
						<div class="form-group">
		                     <label>Password</label>
		                     <input name="j_password" class="form-control" type="password" >
		                     <p class="help-block"></p>
		               </div>
						<button type="submit" class="btn btn-default">Identificar</button>
					</form>	
	            </div>
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="./plantilla/javascriptPie.jsp" %>

</body>
</html>
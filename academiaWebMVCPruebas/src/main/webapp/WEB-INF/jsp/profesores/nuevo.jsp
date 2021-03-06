
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.util.ArrayList"%>
<%@page import="es.indra.academia.controller.profesores.ProfesorForm"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<c:import url="../plantilla/head.jsp"></c:import>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <c:import url="../plantilla/cabecera.jsp"></c:import>
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
                                                                                   
                               <form:form action="./nuevo.html" method="post" modelAttribute="profesor" >
                                        <form:hidden path="id" />
                                        <div class="form-group">
                                            <label>NIF</label>
                                            <form:input path="nif" class="form-control"/>
                                            <form:errors path="nif" element="div" cssClass="alert alert-danger"/>
											<p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                           <label>Nombre</label>
                                             <form:input path="nombre" class="form-control"/>
                                             <form:errors path="nombre" element="div" cssClass="alert alert-danger"/>
											 <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                           <label>Primer Apellido </label>
                                            <form:input path="apellido1" class="form-control"/>
                                            <form:errors path="apellido1" element="div" cssClass="alert alert-danger"/>
											<p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Segundo Apellido</label>
                                            <form:input path="apellido2" class="form-control"/>
                                            <form:errors path="apellido2" element="div" cssClass="alert alert-danger"/>
											<p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                            <form:input path="telefono" class="form-control"/>
                                            <form:errors path="telefono" element="div" cssClass="alert alert-danger"/>
											<p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <form:input path="correo" class="form-control"/>
                                            <form:errors path="correo" element="div" cssClass="alert alert-danger"/>
											<p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Titulacion</label>
                                            <form:input path="titulacion" class="form-control"/>
                                            <form:errors path="titulacion" element="div" cssClass="alert alert-danger"/>
											<p class="help-block"></p>
                                        </div>
                                      
                                        <button type="submit" class="btn btn-default">Enviar</button>
                                        <button type="reset" class="btn btn-default">Limpiar</button>
                                    </form:form>
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
	<c:import url="../plantilla/javascriptPie.jsp"></c:import>
</body>
</html>
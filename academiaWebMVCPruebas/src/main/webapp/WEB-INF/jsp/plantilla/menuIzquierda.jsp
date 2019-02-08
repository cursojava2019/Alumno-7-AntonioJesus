<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
  <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Busqueda...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/index.html"><i class="fa fa-dashboard fa-fw"></i> Inicio</a>
                        </li>
						<sec:authorize access="hasRole('ALUMNOS')">
	                        <li>
	                            <a href="<%=request.getContextPath()%>/admin/alumnos/listado.html"><i class="fa fa-bar-chart-o fa-fw"></i> Gestión de Alumnos</a>
	                            
	                            <!-- /.nav-second-level -->
	                        </li>
						</sec:authorize>
                        <sec:authorize access="hasRole('PROFESORES')">
	                        <li>
	                           <a href="<%=request.getContextPath()%>/admin/profesores/listado.html"><i class="fa fa-bar-chart-o fa-fw"></i> Gestión de Profesores</a>
	                        </li>
                        </sec:authorize>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
           
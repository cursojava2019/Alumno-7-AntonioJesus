<html>
<%@include file="./WEB-INF/jsp/plantilla/head.jsp" %>
<body>
<%@include file="./WEB-INF/jsp/plantilla/cabecera.jsp" %>
<h2 style="text-align:center;">Bienvenido a la aplicación de gestión.</h2><br>


<div id="entrar">
<form action="./login.html" role="form" method="post">
<div class="form-group">
<label>Usuario:</label>
<input name="usuario" type="text" class="form-control" >
<p class="help-block"></p>
</div>
<div class="form-group">
<label>Contraseña:</label>
<input name="password" class="form-control" type="password">
<p class="help-block"></p>
</div>
<button type="submit" style="text-align:center;" class="btn btn-default">Entrar</button>
</form>
</div>

</body>
</html>

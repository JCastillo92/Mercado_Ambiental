<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Control de usuarios</title>
</head>
<body>
<!-- MENSAJE DEL SERVLET -->
<%
String error;
error = request.getParameter("msg");
if (error != null && error.equals("true")){
%>
	<div class="alert alert-success" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>ESTADO</strong>.<%=" Proceso realizado con exito"%>
	</div>
<%
}if(error != null && error.equals("false")){
	%>
	<div class="alert alert-danger" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>ESTADO</strong>.<%=" Se ha producido un error, por favor actualize y vuelva a intentar"%>
	</div>
<%
}
%>
<!--FIN MENSAJE DEL SERVLET -->

<div id="wrap">
<div class="container-fluid">
<div class="container">
<center><br>
<h3><span title="Aqu&iacute; se procede a enviar a los usuarios a la ventana de registro, por ende no podr&aacute;n lograr ingresar de nuevo, hasta que se realice los cambio" class="label label-default">CONTROL DE USUARIOS (MODO BLOQUEO)</span></h3>
<br></center>

<%
ClsAdmin llamo=new ClsAdmin();
String control=llamo.control_usuarios();
out.print(control);

%>
</div>

</div><!--Container -->
</div><!--Wrap-->


 	<script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>

</body>
</html>
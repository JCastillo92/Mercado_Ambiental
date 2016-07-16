<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%

HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0; 
	
}else{
	perf = (Integer)sessionok.getAttribute("log");
}

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Usuario</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body background="imagenes/fondo3.PNG">

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>

<%
String error;
error = request.getParameter("error");
if (error != null){%>
	<div class="alert alert-warning alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Error!</strong>.<%=error%>
	</div>
	<%
}
%>
<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->


<div class="row">
<div class="col-md-8">

	<center><br>
<h3><span class="label label-default">REGISTRO USUARIO</span></h3>
<br></center> 

<br>

<form action="ingreso" method="post">
<h4>*Campos Obigatorios</h4>
<br>
<br>
<div class="row">
<div class="col-md-1">
</div>
<div class="col-md-1">
</div>
<div class="col-md-1">
</div>
<div class="col-md-1">
</div>

<div class="col-md-8">

<table class="table table-hover">
<tr>

<td> <span class="input-group-addon" id="basic-addon1">Cédula* </span>
  <input type="text" class="form-control"name="txtCedula" pattern="[0-9]{10}" placeholder="ejem. 1723230237" aria-describedby="basic-addon1" title="ingrese solo números" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1">Nombres:* </span>
  <input type="text" class="form-control" name="txtNombre" pattern="[a-zA-Z]*+[a-zA-Z]*" placeholder="ejem. Michael" aria-describedby="basic-addon1" title="ingrese solo letras" style="text-transform:uppercase" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1"> Apellidos:* </span>
  <input type="text" class="form-control" name="txtApellido" pattern="[a-zA-Z]*+[a-zA-Z]*"placeholder="ejem.  Toledo" aria-describedby="basic-addon1" title="ingrese solo letras" style="text-transform:uppercase" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1"> Correo Universitario:* </span>
  <input type="email" class="form-control" name="txtCorreo" e placeholder="ejem. bsuarez@est.ups.edu.ec" pattern="^[a-zA-Z-0-1000]+@est+.ups+.edu+.ec" aria-describedby="basic-addon1" title="el correo debe coincidir con el ejemplo.  ejem: estudiante@est.ups.edu.ec" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1">Dirección Domiliciliaria:* </span>
  <input type="text" class="form-control" name="txtDireccion" placeholder="ejem. La Magdalena" aria-describedby="basic-addon1" style="text-transform:uppercase" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1"> Teléfono:* </span>
  <input type="number" class="form-control" name="txtTelefono" pattern="[0-9]{7-10}" placeholder="ejem. 0985677676" aria-describedby="basic-addon1" title="ingrese solo números" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1"> Clave:* </span>
  <input type="password" class="form-control" name="txtClave" placeholder="ejem. clave1234" aria-describedby="basic-addon1" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1"> Confirme su Clave:* </span>
  <input type="password" class="form-control" name="txtClave2" placeholder="ejem. clave1234" aria-describedby="basic-addon1" required></td>
</tr>

</table>

<hr>


<center>
<input type="submit" name="btnRegistar" class="btn btn-primary" role="button" value="Registarse">
<a href="index.jsp">Cancelar</a>

</center>
</div>

</div>

</form>


<div class="row">

<!-- Centros de Acopio -->
<div class="col-md-3">




</div>
</div>
</div>
</div>
</div> 
<br>
<div id="footer" >
<div class="container text-center" >
<br>
Copyright © JB3Company<br>
Desarrollado por: JCastillo,JValles, JFlores, BTorres
<br>
jcastillor1@est.ups.edu.ec, jvallesc@est.ups.edu.ec, jfloresg1@est.ups.edu.ec, blarat@est.ups.edu.ec 
</div>
</div>  









<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
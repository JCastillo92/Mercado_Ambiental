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
<link rel="stylesheet" type="text/css" href="css/miestilo.css">

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
<div id="wrap">
<div class="container-fluid">

<div class="row">

	<center><br>
<h3><span class="label label-default">REGISTRO USUARIO</span></h3>
<br></center> 


<form action="ingreso" method="post">
<center>
<h3><span class="badge">*Todos los campos son obligatorios, revisa tu correo institucional una vez te hayas registrado.</span></h3>
</center>
<div class="col-md-4">
</div>

<div class="col-md-4">

<table class="table table-hover">
<tr>
<td> <span class="input-group-addon" id="basic-addon1">Usuario el cu&aacute; ser&aacute; tu n&uacute;mero de C&Eacute;DULA* </span>
  <input type="text" class="form-control"name="txtCedula" pattern="[0-9]{10}" placeholder="ejem. 1723230237" aria-describedby="basic-addon1" title="ingrese solo n�meros(10 n�meros)" required></td>
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
<td> <span class="input-group-addon" id="basic-addon1"> Correo UNIVERSITARIO: (obligatorio @est.ups.edu.ec)* </span>
  <input type="email" class="form-control" name="txtCorreo" e placeholder="ejem. bsuarez@est.ups.edu.ec" pattern="^[a-zA-Z-0-1000]+@est+.ups+.edu+.ec" aria-describedby="basic-addon1" title="el correo debe coincidir con el ejemplo.  ejem: estudiante@est.ups.edu.ec" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1">Direcci&oacute;n domiliciliaria:* </span>
  <input type="text" class="form-control" name="txtDireccion" placeholder="ejem. La Magdalena" aria-describedby="basic-addon1" style="text-transform:uppercase" required></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1"> Tel&eacute;fono:* </span>
  <input type="number" class="form-control" name="txtTelefono" pattern="[0-9]{7-10}" placeholder="ejem. 0985677676" aria-describedby="basic-addon1" title="ingrese solo n�meros" required></td>
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
<h3><span class="badge">NOTA: Recibir&aacute;s un mensaje de confirmaci&oacute;n, recuerda que el usuario es tu n&uacute;mero de C&eacute;dula </span></h3>
<br><br>
<center>
<input type="submit" name="btnRegistar" class="btn btn-primary" role="button" value="Registarse">
<a class="btn btn-danger" href="index.jsp" role="button">Cancelar</a>



</center>
</div>
<div class="col-md-4">
</div>

</form>

</div>
</div><!--Container -->
</div><!--Wrap-->
<br>
<div id="footer" style="text-align: center; font-size: 15px; border: 5px solid #A8A59C; color:#6E6E6E;background-color:#F2F2F2">
<br>
Copyright � J3BCompany
<br><br>
<div class="container text-center" >
<div class="col-md-4">
<center>
Desarrollado por:<br> Castillo Reimundo Jhon Alexander<br>Flores Gallegos Jairo Daniel <br>Torres Lara Bryan Andr&eacute;s <br>Valles Cruz Jonathan Mauricio <br>---------
</center></div><div class="col-md-4">
<br>jcastillor1@est.ups.edu.ec<br>jairdean@hotmail.com<br> blarat@est.ups.edu.ec<br> jvallesc@est.ups.edu.ec<br>

</div><div class="col-md-4">
<br>
Contacto:
<br>098 346 6689<br>

</div>
<br>



<br>
<br>

</div>
SistemasUPS - AmbientalUPS 2016
<br>
</div>  


<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
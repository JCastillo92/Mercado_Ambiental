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
String ced="";
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
	response.sendRedirect("index.jsp");
}else{
	perf = (Integer)sessionok.getAttribute("log");
	ced=(String)sessionok.getAttribute("cedula");
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Editar Mi Clave</title>
</head>
<body>

<!-- MENSAJE DEL SERVLET -->
<%
String error;
error = request.getParameter("dato");
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
	  <strong>ESTADO</strong>.<%=" Se ha producido un error, por favor actualizar la p&aacute;gina y vuelva a intentar, verifique que los datos no sean vacios o que el password coincida"%>
	</div>
<%
}
%>
<!--FIN MENSAJE DEL SERVLET -->

<div id="wrap">
<div class="container-fluid">
<div class="row">
<br><br>
<div class="col-md-2">
</div>

<div class="col-md-8">
<center><h3><span class="label label-default">ACTUALIZAR MIS DATOS</span></h3></center>
<br><br>

<form action="Sr_actualiza_user_clave" method="post">

  <div>
  <h1>IMPORTANTE:</h1><p>Para efectuar los cambios debe <mark>ingresar su misma clave primero</mark>.</p>
  </div>
<span class="input-group-addon" id="basic-addon1"> Clave Antigua: </span>
  <input type="password" id="password"  class="form-control" name="txtClaveN" placeholder="ejem. 1234ups" aria-describedby="basic-addon1" required/>

<span class="input-group-addon" id="basic-addon1"> Nueva Clave: </span>
  <input type="password" id="password" class="form-control" name="txtClave1" placeholder="ejem. 1234ups" aria-describedby="basic-addon1" required/>


<span class="input-group-addon" id="basic-addon1"> Confirme la clave:</span>
  <input type="password" id="password" class="form-control" name="txtClave2" placeholder="ejem. 1234ups" aria-describedby="basic-addon1" required/>

<center>  
 <input type="submit" name="btnRegistar" class="btn btn-primary" role="button" value="ACTUALIZAR">
 <a class="btn btn-danger" href="index.jsp" role="button">Cancelar</a>
 </center>
 <br><br>
 </form> 
</div>
<div class="col-md-2">
</div>

</div>
</div>  <!-- FIN CONTAINER -->
</div> <!-- FIN WRAP  -->

<br>
<br>
<br>
<div id="footer" style="text-align: center; font-size: 15px; border: 5px solid #A8A59C; color:#6E6E6E;background-color:#F2F2F2">
<br>

Desarrollado por la Carrera: Ingeniería de Sistemas
<br>
Universidad Politécnica Salesiana
<br>
      Sede Quito - Campus Sur
<br>
Sistemas - Ambiental
<br>
Quito - Ecuador 2016
<br>
<br>
<br>
</div>  




<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>
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
<title>Editar fono y dir</title>
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

<form action="Sr_actualiza_user_personal" method="post">

<%
ClsUsuario obj1= new ClsUsuario();
String aa=obj1.devuelvo_para_actualizar(ced);
out.print(aa);
%>
  <div>
  <a class="btn btn-success" href="Edit_claves.jsp" role="button">Actualizar Mi Clave</a>
  </div>
  

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





<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>
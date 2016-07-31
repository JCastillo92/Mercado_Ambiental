<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contactos</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body background="imagenes/fondoo.jpg" >
<%
HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
}else{
	perf=(Integer)sessionok.getAttribute("log");
}
//<!--FIN MENSAJE DEL SERVLET -->
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

<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>


<div id="wrap">
<div class="container-fluid">
<br>
<center><h1><span class="label label-default">Cont&aacute;ctanos</span></h1></center>
<br>
<div class="row">
<div class="col-md-3">

</div>
<div class="col-md-6" >



<img src="imagenes/telefono.jpg" alt="..."  style="width:250px;height:250px;border: 5px solid #A8A59C;" class="img-thumbnail">
<br>
<br>
<br>
<br>
<A HREF="https://www.facebook.com/Club-Ecol%C3%B3gico-UPS-540043556165585/?fref=ts" style="font-size:25px"; TITLE="CLUB ECOLÓGICO">FACEBOOK</A>
<br>
<br>
<h2 style="color:#FF0000;"> Gmail: clubecologicoups@gmail.com </h2> 
<br>
<br>
<br>
<A HREF="https://maps.here.com/directions/mix/mylocation/Club-Ecol%C3%B3gico-UPS:-0.28087,-78.54854?map=-0.28087,-78.54854,15,normal&fb_locale=es_LA" style="font-size:25px; color:#298A08;"  TITLE="
Av. Rumichaca y Morán Valverde s/n., Quito">DIRECCI&Oacute;N</A>

<br>
</div> 
<div class="col-md-3">

</div>
</div>

</div><!--Container -->
</div><!--Wrap-->

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









<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quienes Somos</title>
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
<center><h1><span class="label label-default">QUIENES SOMOS</span></h1></center>
<br>
<div class="row">
<div class="col-md-3">
<h3><span class="label label-info" id="demo"></span></h3>
<script>
var myVar = setInterval(myTimer, 1000);
function myTimer() {
    var d = new Date();
    document.getElementById("demo").innerHTML = d.toLocaleTimeString();
}
</script>
</div>
<div class="col-md-6" >



<img src="imagenes/club.jpg" alt="..."  style="width:250px;height:250px;border: 5px solid #A8A59C;" class="img-thumbnail">
<br>
<h3 style="color:#2E2E2E;">Club Ecol�gico de la Universidad Polit�cnica Salesiana, de la carrera de Ingenier�a Ambiental.
Contribuimos con conocimiento para el desarrollo.</h3>

<br>
<h2 style="color:#2E2E2E;"> Misi&oacute;n</h2>

<h3 style="color:#2E2E2E;">La misi�n del grupo se centra en generar satisfacci�n y oportunidades a los integrantes 
del Club, mediante actividades que promueva una cultura comprometida con el cuidado del medio ambiente, y activa participaci�n con la comunidad.</h3>

</div> 
<div class="col-md-3">
<!-- no poner nada aqui -->
</div>
</div>

</div><!--Container -->
</div><!--Wrap-->

<br>
<br>
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
<br>
</div>  









<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
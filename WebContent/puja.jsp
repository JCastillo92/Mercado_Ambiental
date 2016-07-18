<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
String error;
error = request.getParameter("dato");
if (error != null){
%>

<div class="alert alert-success" role="alert">
<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
<strong>Estado</strong>.<%=" "+error%>
</div>

<%}%>

<%
HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
ClsTiempo tiempo = new ClsTiempo();
ClsPujas puja = new ClsPujas();

String id; 
String dia;
String mes;
String año; 
String hora;
String minutos;
String dato;

id = request.getParameter("id");

if(id==null){
id=puja.Id_Puja_Momento();
}

int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
perf = 0;
response.sendRedirect("index.jsp");
}else{
perf = (Integer)sessionok.getAttribute("log");
}

dia=tiempo.Dia(id);
mes=tiempo.Mes(id);
año=tiempo.año(id);
hora=tiempo.hora(id);
minutos=tiempo.minutos(id);
dato=mes+"/"+dia+"/"+año+" "+hora+":"+minutos;
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PUJA</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">




<script>

var dato1 = '<%=dato%>'



	function cdtd() {
	//var xmas = new Date("December 25, 2017 00:01:00");
	var xmas = new Date(dato1);
	var now = new Date();
	var timeDiff = xmas.getTime() - now.getTime();
	if (timeDiff <= 0) {
    clearTimeout(timer);
    
    window.location.replace("Tiempo?dato=<%=id%>");
	//document.write("Puja Terminada");
	// Run any code needed for countdown completion here
    }
	var seconds = Math.floor(timeDiff / 1000);
	var minutes = Math.floor(seconds / 60);
	var hours = Math.floor(minutes / 60);
	var days = Math.floor(hours / 24);
	hours %= 24;
    minutes %= 60;
    seconds %= 60;
	document.getElementById("daysBox").innerHTML = days;
	document.getElementById("hoursBox").innerHTML = hours;
	document.getElementById("minsBox").innerHTML = minutes;
	document.getElementById("secsBox").innerHTML = seconds;
	var timer = setTimeout('cdtd()',1000);
}
</script>

</head>
<body background="imagenes/fondo3.PNG" >

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

<div class="row">
<div class="col-md-3">

<center>
<h1>
<span class="label label-info"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> OTRAS PUJAS</span> 
</span>
</h1>
</center>



<br>
<br>

<%
out.print(puja.Ver_Pujas());
%>
</div>

<div class="col-md-6">


<center>
<h1>
<span class="label label-success"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> TERMINA EN:</span> 
</span>
</h1>
</center>

<center>

<h1>

<span class="label label-info" id="daysBox"></span> Días 
<span class="label label-info" id="hoursBox"> </span> Horas
<span class="label label-info" id="minsBox">  </span>min.
<span class="label label-info" id="secsBox"></span> seg.

<script>cdtd();</script>

 

</h1>
</center>

<br>


<div id="carrusel-1" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-1" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-1" data-slide-to="1"></li>
    <li data-target="carrusel-1" data-slide-to="2"></li>
    <li data-target="carrusel-1" data-slide-to="3"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagen?prod=<%=id%>&place=<%=1%>&i_tipo=<%=2%>" alt="..."  style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    </div>
    
    <div class="item">
    <img src="imagen?prod=<%=id%>&place=<%=2%>&i_tipo=<%=2%>" alt="..." style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    </div>
    
    <div class="item">
    <img src="imagen?prod=<%=id%>&place=<%=3%>&i_tipo=<%=2%>"  style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    </div>
    
    <div class="item">
    <img src="imagen?prod=<%=id%>&place=<%=4%>&i_tipo=<%=2%>"  style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    </div>
    
    
    
	</div>
	</div>

	<a class="left carousel-control" href="#carrusel-1" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-1" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
    <center><h5><font color="white"><%out.print(puja.Descripcion(id));%></font></h5></center>

</div>


<div class="col-md-3">

<center>
<h1>
<span class="label label-info"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> INFORMACIÓN</span> 
</span>
</h1>
</center>
<br>
<br>
<br>
<br>




<form action="Pujar" method="post">
<input type="hidden" class="form-control" name="valor" value=<%out.print(puja.Valor(id)); %>>
<input type="hidden" class="form-control" name="id_puja" value=<%out.print(id); %>>
<table class="table table-condensed">

<tr style="color:#456789;font-size:150%;">


<td><span class="label label-success"> TIPO DE MONEDA </span></td>
<td><span class="label label-success"> <%out.print(puja.Moneda(id)); %> </span></td>

</tr>
<tr>
<td></td>
<td></td>
</tr>

<tr style="color:#456789;font-size:150%;">
<td><span class="label label-info"> OFERTA ATUAL </span></td>
<td><span class="label label-success"> <%out.print(puja.Valor(id)); %> </span></td>
</tr>


<tr>
<td></td>
<td></td>
</tr>

<tr style="color:#456789;font-size:140%;">
<td><span class="label label-success"> OFERTAR VALOR </span></td>
<td> <input type="text" class="form-control" name="oferta" required> </td>
</tr>

</table>

<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon glyphicon-plus-sign" aria-hidden="true">PUJAR</span></button>
</form>

</div>

</div> 

<br>
<br>
<br>
<div id="footer" style="text-align: center; font-size: 15px; border: 5px solid #A8A59C; color:#6E6E6E;background-color:#F2F2F2">
<br>
Copyright © J3BCompany
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
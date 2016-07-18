<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%

HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
ClsPujas puja = new ClsPujas();
ClsTiempo tiempo = new ClsTiempo();

String id=puja.Id_Puja_Momento();

int perf;

String dia;
String mes;
String año; 
String hora;
String minutos;
String dato;

dia=tiempo.Dia(id);
mes=tiempo.Mes(id);
año=tiempo.año(id);
hora=tiempo.hora(id);
minutos=tiempo.minutos(id);
dato=mes+" "+dia+", "+año+" "+hora+":"+minutos;



double ag,lz,tel,inte,tot;
String carrusel;
carrusel = obj.carruseles();
if(sessionok.getAttribute("log")==null){
perf = 0; 
	
}else{
perf = (Integer)sessionok.getAttribute("log");
}

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mercado Ambiental</title>
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

<%
String error;
error = request.getParameter("error");
if (error != null){
%>
	<div class="alert alert-success" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Estado</strong>.<%=" "+error%>
	</div>
<%
}
%>

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->
<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carousel****************************************************************************************-->

<div class="row">


	<center>
	
<table>
<tr>
<td><h1 ><span style="color: white" class="label label-default" > LO M&Aacute;S NUEVO </span></h1></td>
</tr>

</table>
</center>
</div>
<div class="col-md-3">

	

</div>

</div>     

<br>

<div class="row">
<%
out.print(carrusel);
%>

</div>

<!--Carousel****************************************************************************************-->
<!--Carousel****************************************************************************************-->

<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->

<br>
<br>
<div class="row">

<!-- top 5 usuarios que compran -->
<div class="col-md-3">
<center>
<h3><span class="label label-default">TOP 5 RANKING DE NUESTROS USUARIOS</span></h3>
<br></center>
<div class="col-md-1">
<!-- SIEMPRE VACIO  -->
</div>
<div class="col-md-10">
<%
Cls_index_components x1= new Cls_index_components();
out.print(x1.top_5_user_index());
%>
</div>
<div class="col-md-1">
<!-- SIEMPRE VACIO  -->
</div>
</div>


<div class="col-md-6">


<%int control = puja.Controlar_Puja();

if(id == null){
control = 0;
}

if(control == 0){
%>
<center>
<h1>
<span class="label label-success"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> LO SENTIMOS NO HAY PUJAS DISPONIBLES</span> 
</span>
</h1>
</center>
<% 	
}
else{
%>
<center>
<h1>
<span class="label label-success"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> TERMINA EN:</span> 
</span>
</h1>
</center>


<center>

<h1>

<span class="label label-info" id="daysBox"></span> <span class="badge">D&iacute;as</span> 
<span class="label label-info" id="hoursBox"> </span> <span class="badge">Horas</span>
<span class="label label-info" id="minsBox">  </span><span class="badge">min.</span>
<span class="label label-info" id="secsBox"></span> <span class="badge"> seg.</span>

<script>cdtd();</script>

 

</h1>
</center>

<br>


<div id="carrusel-11" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-11" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-11" data-slide-to="1"></li>
    <li data-target="carrusel-11" data-slide-to="2"></li>
    <li data-target="carrusel-11" data-slide-to="3"></li>
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

	<a class="left carousel-control" href="#carrusel-11" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-11" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
    <center><h5><font color="white"><%out.print(puja.Descripcion(String.valueOf(id)));%></font></h5></center>





<center><a href="puja.jsp?id=<%=id%>"><button class="btn btn-info" type="button" >
<span class="glyphicon glyphicon glyphicon-info-sign" aria-hidden="true"> PUJAR </span> 

</button></a></center>

<%} %>

</div>

<div class="col-md-3">

<div class="col-md-1">
<!--  AQUI NO PONER NADA -->
</div>
<div class="col-md-10">
<table class="table table-hover">
<tr>

<td> 
<center>
<h1><span class="label label-info" id="basic-addon1">INFORMACI&Oacute;N</span></h1>
 </center>
<h3>
<span style="color: blue;">

<%
ClsAdmin metodos =new ClsAdmin();
out.print(metodos.devuelvo_Informacion());
 %> 
 
 </span></h3></td>
</tr>
</table>
</div>
<div class="col-md-1">
<!--  AQUI NO PONER NADA -->
</div>

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
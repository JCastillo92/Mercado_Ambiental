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
String a�o; 
String hora;
String minutos;
String dato;

dia=tiempo.Dia(id);
mes=tiempo.Mes(id);
a�o=tiempo.a�o(id);
hora=tiempo.hora(id);
minutos=tiempo.minutos(id);
dato=mes+"/"+dia+"/"+a�o+" "+hora+":"+minutos;



double ag,lz,tel,inte,tot;
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
	document.write("Puja Terminada");
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
out.print(dato);
%>

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carousel****************************************************************************************-->

<div class="row">
<div class="col-md-7">

	<center><h1><span class="label label-success"> LO MAS NUEVO </span></h1></center>
	</div>

<div class="col-md-3">

	<form class="navbar-form navbar-right" role="search">
	<div class="form-group">
	<input type="text" class="form-control" placeholder="Buscar">
    </div>
    <button type="submit" class="btn btn-success">
    <span class="glyphicon glyphicon glyphicon-search" aria-hidden="true"> BUSCAR</span>
    
    </button>
    </form>

</div>

</div>     

<br>

<div class="row">


<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGOR�A 1</span> 
</span></h3></center>


<div id="carrusel-1" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-1" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-1" data-slide-to="1"></li>
    <li data-target="carrusel-1" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagenes/baldor1.jpg" alt="..."  style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/baldor2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/baldor3.jpg" alt="..."  style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    
    
</div>
</div>

  	<a class="left carousel-control" href="#carrusel-1" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-1" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
<br>
<center><h4>
<a href="descripcion.jsp?id=1"><span class="label label-success"> 
SABER M�S
</span></a></h4></center>

</div>

<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGOR�A 2</span> 
</span></h3></center>

<div id="carrusel-2" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-2" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-2" data-slide-to="1"></li>
    <li data-target="carrusel-2" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagenes/balon1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/balon2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/balon3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    
</div>
</div>

  	<a class="left carousel-control" href="#carrusel-2" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-2" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
<br>
<center><h4>
<a href="descripcion.jsp?id=2"><span class="label label-success">
SABER M�S
</span></a></h4></center>

</div>


<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGOR�A 3</span> 
</span></h3></center>


<div id="carrusel-3" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-3" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-3" data-slide-to="1"></li>
    <li data-target="carrusel-3" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagenes/portalaptop1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/portalaptop2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/portalaptop3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
</div>
</div>

  	<a class="left carousel-control" href="#carrusel-3" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-3" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
<br>
<center><h4>
<a href="descripcion.jsp?id=3"><span class="label label-success">
SABER M�S
</span></a></h4></center>

</div>


<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGOR�A 4</span> 
</span></h3></center>

<div id="carrusel-4" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-4" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-4" data-slide-to="1"></li>
    <li data-target="carrusel-4" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagenes/psp1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/psp2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/psp3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    
</div>
</div>

  	<a class="left carousel-control" href="#carrusel-4" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-4" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
<br>
<center><h4>
<a href="descripcion.jsp?id=4"><span class="label label-success">
SABER M�S
</span></a></h4></center>

</div>

<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info"> 
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGOR�A 5</span> 
</span></h3></center>

<div id="carrusel-5" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-5" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-5" data-slide-to="1"></li>
    <li data-target="carrusel-5" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagenes/guitarra1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
   <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/guitarra2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
   <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/guitarra3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    
</div>
</div>

  	<a class="left carousel-control" href="#carrusel-5" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-5" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
<br>
<center><h4>
<a href="descripcion.jsp?id=5"><span class="label label-success">
SABER M�S
</span></a></h4></center>

</div>

<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGOR�A 6</span> 
</span></h3></center>

<div id="carrusel-6" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-6" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-6" data-slide-to="1"></li>
    <li data-target="carrusel-6" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagenes/laptop1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/laptop2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/laptop3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    
</div>
</div>

  	<a class="left carousel-control" href="#carrusel-6" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  	</a>
  	<a class="right carousel-control" href="#carrusel-6" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
    
<br>
<center><h4>
<a href="descripcion.jsp?id=4"><span class="label label-success">
SABER M�S
</span></a></h4></center>

</div>




</div>

<!--Carousel****************************************************************************************-->
<!--Carousel****************************************************************************************-->

<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->
<!--Carouseles****************************************************************************************-->



<div class="row">

<!-- Centros de Acopio -->
<div class="col-md-3">




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

<span class="label label-info" id="daysBox"></span> D�as 
<span class="label label-info" id="hoursBox"> </span> Horas
<span class="label label-info" id="minsBox">  </span>min.
<span class="label label-info" id="secsBox"></span> seg.

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



</div>

<div class="col-md-3">

<center>
<h1>
<span class="label label-info"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> INFORMACION</span> 
</span>
</h1>
</center>


</div>
</div>


<div id="footer">
<div class="container text-center" >
<br>
Copyright � JB3Company<br>
Desarrollado por: JCastillo,JValles, JFlores, BTorres
<br>
jcastillor1@est.ups.edu.ec, jvallesc@est.ups.edu.ec, jfloresg1@est.ups.edu.ec, blarat@est.ups.edu.ec 
</div>
</div> 









<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
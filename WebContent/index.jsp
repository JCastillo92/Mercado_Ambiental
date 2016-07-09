<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body background="imagenes/fondo3.PNG" >

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->
<h2>yo ingreso SOLO en la linea 14</h2>
<nav class="navbar navbar-default">
 
    <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
	<a href="index.jsp"><img src="imagenes/ups.png" align="left" alt="Logo" style="max-width:100%;height:auto"></a>
    
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
    
    
    
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
    
    <li><a href="index.jsp">
  	<span class="glyphicon glyphicon glyphicon-home" aria-hidden="true"> Home</span>
	</a></li>
    
    <li><a href="#">
 	<span class="glyphicon glyphicon glyphicon-earphone" aria-hidden="true"> Contactos</span>
	</a></li>
    
   	<li><a href="#">
	<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> Nosotros</span>
	</a></li>
	 
	<li><a href="#">
 	<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> Trabaja con Nosotros</span>
	</a></li>
	
	<li><a href="#">
 	<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> Información</span>
	</a></li>
    
    </ul>
    
   	<ul class="nav navbar-nav navbar-right">
                  
    <form class="navbar-form navbar-rigth" role="search">
    <div class="form-group">
    <input type="text" class="form-control" placeholder="Usuario">
    <input type="text" class="form-control" placeholder="Contraseña">
    </div>
    <button type="submit" class="btn btn-info">Iniciar Sesión</button>
    </form>          
                  
    </ul>
   
    </div><!-- /.navbar-collapse -->
  	</div><!-- /.container-fluid -->
</nav>
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
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGORÍA 1</span> 
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
    <img src="imagenes/z1.jpg" alt="..."  style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z3.jpg" alt="..."  style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
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
SABER MÁS
</span></a></h4></center>

</div>

<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGORÍA 2</span> 
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
    <img src="imagenes/z1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z5.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
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
SABER MÁS
</span></a></h4></center>

</div>


<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGORÍA 3</span> 
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
    <img src="imagenes/z1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
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
SABER MÁS
</span></a></h4></center>

</div>


<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGORÍA 4</span> 
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
    <img src="imagenes/z1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
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
SABER MÁS
</span></a></h4></center>

</div>


<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info"> 
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGORÍA 5</span> 
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
    <img src="imagenes/z1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
   <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
   <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
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
SABER MÁS
</span></a></h4></center>

</div>

<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->
<!-- **********************************************************************************************-->

<div class="col-md-2">

<center><h3><span class="label label-info">  
<span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"> CATEGORÍA 6</span> 
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
    <img src="imagenes/z1.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z2.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    <center><h6><font color="white">Caption Text</font></h6></center>
    </div>
    
    <div class="item">
    <img src="imagenes/z3.jpg" alt="..." style="width:175px;height:150px;border:0" class="center-block" class="img-thumbnail">
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
SABER MÁS
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
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> LA PUJA DEL MOMENTO</span> 
</span>
</h1>
</center>
<br>

<img src="imagenes/z4.jpg" alt="..." class="center-block" height="300" width="400">

<br>

<table class="table table-condensed">

<tr>
<td><center><span class="label label-success"> TIPO DE MONEDA </span></center></td>
<td><center><span class="label label-success"> CARGAR TIPO DE MONEDA </span></center></td>
</tr>


<tr>
<td><center><span class="label label-info"> OFERTA ATUAL </span></center></td>
<td><center><span class="label label-info"> CARGAR OFERTA ATUAL </span></center></td>
</tr>


<tr>
<td><center><span class="label label-success"> FECHA LIMITE </span></center></td>
<td><center><span class="label label-success"> CARGAR FECHA LIMITE </span></center></td>
</tr>
</table>


<center><a href="puja.jsp"><button class="btn btn-info" type="button" >
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

AQUI PONEMOS INFORMACION DE CUANDO ME LO VANA A CHUPAR

</div>
</div>




<div id="footer">
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
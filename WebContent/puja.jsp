<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String id;
id = request.getParameter("id");

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body background="imagenes/fondo3.PNG" >

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

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

<div class="row">
<div class="col-md-3">

<center>
<h1>
<span class="label label-info"> 
<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> OTRAS PUJAS</span> 
</span>
</h1>
</center>

<form class="navbar-form navbar-left" role="search">
<div class="form-group">
<input type="text" class="form-control" placeholder="Buscar">
</div>
<button type="submit" class="btn btn-success">
<span class="glyphicon glyphicon glyphicon-search" aria-hidden="true"> BUSCAR</span>
</button>
</form>

<br>
<br>

<%
ClsPujas puja = new ClsPujas();
out.print(puja.Ver_Pujas());
%>
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


<div id="carrusel-1" class="carousel slide" data-ride="carousel">
 	
 	<!-- Indicators -->
  	
  	<ol class="carousel-indicators">
    <li data-target="carrusel-1" data-slide-to="0" class="active"></li>
    <li data-target="carrusel-1" data-slide-to="1"></li>
    <li data-target="carrusel-1" data-slide-to="2"></li>
    </ol>
 
 	<div class="carousel-inner">
    
    <div class="item active">
    <img src="imagen?prod=<%=id%>&place=<%=1%>" alt="..."  style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    </div>
    
    <div class="item">
    <img src="imagen?prod=<%=id%>&place=<%=2%>" alt="..." style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
    <div class="carousel-caption">
    </div>
    </div>
    
    <div class="item">
    <img src="imagen?prod=<%=id%>&place=<%=3%>"  style="width:500px;height:400px;border:0" class="center-block" class="img-thumbnail">
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
<br>
<br>
<br>
<br>


<table class="table table-condensed">

<tr style="color:#456789;font-size:150%;">


<td><span class="label label-success"> TIPO DE MONEDA </span></td>
<td><span class="label label-success"> <%out.print(puja.Moneda(id)); %> </span></td>


</tr>


<tr style="color:#456789;font-size:150%;">
<td><span class="label label-info"> OFERTA ATUAL </span></td>
<td><span class="label label-info">  <%out.print(puja.Valor(id)); %> </span></td>
</tr>


<tr style="color:#456789;font-size:150%;">
<td><span class="label label-success"> FECHA LIMITE </span></td>
<td><span class="label label-success"> CARGAR FECHA LIMITE </span></td>
</tr>
</table>

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
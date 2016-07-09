<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String id,lugardelaimagen;
id = request.getParameter("id");


	lugardelaimagen = request.getParameter("lug");
	if(lugardelaimagen ==null){
		lugardelaimagen="1";
	}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Descripción</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">

</head>
<body background="imagenes/fondo.jpg">

<nav class="navbar navbar-default">
 
    <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
	<a href="index.jsp"><img src="imagenes/ups.png" align="left" alt="Logo"style="max-width:100%;height:auto"></a>
    
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

<div class="row">
<%=lugardelaimagen%>
<img id="zoom_01" src="imagen?prod=<%=id%>&place=<%=lugardelaimagen%>" width="250px" height="250px" alt="..." class="img-thumbnail center-block">
</div>

<br>

<div class="row">

	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=1"><img src="imagen?prod=<%=id%>&place=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=2"><img src="imagen?prod=<%=id%>&place=2" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=3"><img src="imagen?prod=<%=id%>&place=3" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=4"><img src="imagen?prod=<%=id%>&place=4" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>

</div>

<div class="row">
	
	<div class="col-md-6">
		
		<center><h1><span class="label label-success"> DESCRIPCIÓN </span></h1></center>
		<br>
		
		<pre>
		
Se ofrece este celular Modelo nokia lumia 820, su estado es 8/10, no tiene caidas, tiene la ultima version instalada.
Incluye su cargador original con su cable usb, mica para proteger su pantalla y con un estuche.
				
Cualquier duda o mas informacion te dejo mi contacto:
Mi contacto es 098-33-555-21. 
		
		</pre>
		
		
	</div>
	
	<div class="col-md-6">
		
		<center><h1><span class="label label-success"> TRUEQUE </span></h1></center>
		<br>
		
		<div class="col-md-6">
		<h2 class="text-right"><span class="label label-primary">Ofertado por:</span></h2>
		</div>
		
		<div class="col-md-6">
		<h2><span class="label label-primary">200 Botellas 500 ml</span></h2>
		</div>
		<br><br><br>
		<center><h2><button type="button" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> ADQUIRIR </span></button></h2> </center>
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
<script src="Estilos/jquery.elevatezoom.js"></script>
<script src="Estilos/jquery.imageLens.js" type="text/javascript"></script>

<script>
$("#zoom_01").elevateZoom({tint:true, tintColour:'#F90', tintOpacity:0.5});
</script>

</body>
</html>
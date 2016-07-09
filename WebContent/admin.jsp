<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
String id = request.getParameter("id");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
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
<div class="col-md-2">


<div class="list-group">
  <h3>
  <a href="admin.jsp?id=1" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  MONEDA
  </a>
  </h3>

  <h3>
  <a href="admin.jsp?id=2" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  AGREGAR PUJAS
  </a>
  </h3>	
  
  <h3>
  <a href="admin.jsp?id=3" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  ADMINISTRAR PUJAS
  </a>
  </h3>
  
  <h3>
  <a href="admin.jsp?id=4" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  ACEPTAR / RECHAZAR DE USUARIOS
  </a>
  </h3>
  
  <h3>
  <a href="admin.jsp?id=5" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  CONTROL DE USUARIOS
  </a>
  </h3>
  
  

</div>

</div>


<div class="col-md-9" >


<div class="embed-responsive embed-responsive-16by9">

<%
if (id.equals("0")){
%><iframe class="embed-responsive-item" src="index.jsp"></iframe><%
}
if (id.equals("1")){
%><iframe class="embed-responsive-item" src="AgregarMoneda.jsp"></iframe><%
}
if (id.equals("2")){
%><iframe class="embed-responsive-item" src="Crear_Puja.jsp"></iframe><%
}
if (id.equals("3")){
%><iframe class="embed-responsive-item" src="Administar_Pujas.jsp"></iframe><%
}
if (id.equals("4")){
%><iframe class="embed-responsive-item" src="A_accept_delete.jsp"></iframe><%
}
if (id.equals("5")){
%><iframe class="embed-responsive-item" src="A_control_user.jsp"></iframe><%
}
if (id.equals("6")){
%><iframe class="embed-responsive-item" src="AgregarMoneda.jsp"></iframe><%
}
%>




</div>
</div> 

<div class="col-md-1" >

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
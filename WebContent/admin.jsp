<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

String id = request.getParameter("id");

HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0; 
	
}else{
	perf = (Integer)sessionok.getAttribute("log");
}

if(perf !=2){
	response.sendRedirect("index.jsp?error=No tiene privilegios para acceder a esa pagina");
}

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
<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>
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
  <a href="admin.jsp?id=6" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  AGREGAR TRUEQUE
  </a>
  </h3>	
  
  <h3>
  <a href="admin.jsp?id=8" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  TRUEQUES POR CONFIRMAR INTERCAMBIO
  </a>
  </h3>
  
  <h3>
  <a href="admin.jsp?id=10" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  HISTORIAL TRUEQUES Y PUJAS
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
  
    <h3>
  <a href="admin.jsp?id=9" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  DESBLOQUEAR USUARIOS
  </a>
  </h3>
  
<h3>
  <a href="admin.jsp?id=7" class="list-group-item">
  <span class="badge">  <span class="glyphicon glyphicon glyphicon-education" aria-hidden="true"></span></span>
  AGREGAR INFORMACIÓN
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
%><iframe class="embed-responsive-item" src="A_subir_trueque.jsp"></iframe><%
}
if (id.equals("7")){

%><iframe class="embed-responsive-item" src="Informacion.jsp"></iframe><%


}
if (id.equals("8")){
%><iframe class="embed-responsive-item" src="Trueque_x_vender.jsp"></iframe><%
}
if (id.equals("9")){
%><iframe class="embed-responsive-item" src="A_blocked_users.jsp"></iframe><%

}
if (id.equals("10")){
%><iframe class="embed-responsive-item" src="Trueque_vendido.jsp"></iframe><%
}%>



</div>
</div> 

<div class="col-md-1" >

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
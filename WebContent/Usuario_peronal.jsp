<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Uusario personal</title>
</head>
<body>

<%
HttpSession sessionok = request.getSession();
Cls_General obj2= new Cls_General();
int perf;
String ced="";
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
	response.sendRedirect("index.jsp");
}else{
	perf=(Integer)sessionok.getAttribute("log");
	ced=(String)sessionok.getAttribute("cedula");
}

String error;
error = request.getParameter("dato");
if (error != null){
%>
	<div class="alert alert-success" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Estado</strong>.<%=" "+error%>
	</div>
<%
}

%>

<div id="wrap">
<div class="container-fluid">

<%
String menu;
menu = obj2.desplegarmenus(perf);
out.print(menu);
%>

<div class="row">
<div class="col-md-3">

</div>
</div>

<div class="row">
<div class="col-md-1">
<!-- V A C I O  izquierda -->
</div>

<div class="col-md-10">

<h1 class="text-center">Datos Personales del Usuario</h1>

<!-- ----------------------------------------------------------------------------------------------- -->
<%
String print_user_data;
ClsUsuario obj=new ClsUsuario();
print_user_data=obj.consula_usuario_personal(ced);
out.print(print_user_data);
%>

<!-- -------------------------------------------------------------------------------------- -->
<!-- Single button -->
<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Editar mis datos <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <li><a href="Edit_tel_dir.jsp">Telefono-Domicilio-Password</a></li>
  </ul>
</div>

</div>
<div class="col-md-1">
</div>
</div>
<br><br><br><br><br>

</div>  <!-- FIN CONTAINER -->
</div> <!-- FIN WRAP  -->



<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>
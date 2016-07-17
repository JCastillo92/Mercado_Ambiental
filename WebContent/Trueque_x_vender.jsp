<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Lista trueques pendientes</title>
</head>
<body>
<%
HttpSession sessionok = request.getSession();
Cls_General obj2= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
	response.sendRedirect("index.jsp");
}else{
	perf=(Integer)sessionok.getAttribute("log");
}
//<!-- MENSAJE DEL SERVLET -->
String error;
error = request.getParameter("dato");
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

<div id="wrap">
<div class="container-fluid">
<div class="container">

<center><br>
<h3><span class="label label-default">Trueques, las personas en &eacute;ste listado quieren 
o est&aacute;n interesados en hacer el intercambio.</span></h3>
<br></center>

<!-- ----------------------------------------------------------------------------------------------- -->
<%
String print_user_data;
Cls_Trueque obj=new Cls_Trueque();
print_user_data=obj.lista_trueques_por_confirmar_venta();
out.print(print_user_data);
%>

<!-- -------------------------------------------------------------------------------------- -->

</div><!-- FIN CONTAINER-->
</div>  <!-- FIN CONTAINER  FLUID-->
</div> <!-- FIN WRAP  -->


<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>

</body>
</html>
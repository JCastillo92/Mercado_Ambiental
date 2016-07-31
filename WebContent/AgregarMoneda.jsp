<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
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
<title>Registro de Moneda</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body>

<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->


<!-- MENSAJE DEL SERVLET -->
<%
String error;
error = request.getParameter("msg");
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
<!--Encabezado**************************************************************************************-->
<!--Encabezado**************************************************************************************-->

<div id="wrap">
<div class="container-fluid">
<div class="row">
<div class="col-md-2">
</div>
<div class="col-md-8">
<center>
<h3><span class="label label-default">AGREGAR MONEDA</span></h3>
</center> 

<form action="ingresoMoneda" method="post">
<table class="table table-hover"><tr>
<td> <span class="input-group-addon" id="basic-addon1">Descripci&oacute;n de la moneda * </span>
  <input type="text" class="form-control"name="txtMoneda"  placeholder="ejem. Botellas Plasticas" aria-describedby="basic-addon1"  style="text-transform:uppercase" required></td>
</tr></table>


<center>
<input type="submit" name="btnRegistar" class="btn btn-success" role="button" value="Registar Moneda">
<a class="btn btn-danger" href="index.jsp" role="button">Cancelar</a>
</center>
</form>
<hr>
</div>
<div class="col-md-2">
</div>
<div class="container">

<left><br>
<h3><span class="label label-default">Listado de monedas</span></h3>
<br></left>     
 <%
 ClsAdmin metodos =new ClsAdmin();
 out.print(metodos.consulta_monedas());
 %>
</div>


</div><!--Container -->
</div><!--Wrap-->

<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
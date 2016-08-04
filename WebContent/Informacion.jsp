<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ClsPujas trueque = new ClsPujas(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Subir Informaci&oacute;n</title>
</head>
<body>
<%
HttpSession sessionok = request.getSession();
Cls_General obj2= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
}else{
	perf=(Integer)sessionok.getAttribute("log");
}
if(perf !=2){
	response.sendRedirect("index.jsp?error=false&msg=No tiene privilegios para acceder a este sitio");
}
//<!--FIN MENSAJE DEL SERVLET -->
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
<div id="wrap">
<div class="container-fluid">
<div class="row">

<div class="col-md-2">
<!-- NO PONER NADA AQUI -->
</div>

<div class="col-md-8">
<form action="ingresoInfo" method="post">

<!-- /////////////////////////////////////////////////////////////////////////////// -->
<center>
<br>
        <h2><span class="label label-default" id="gridSystemModalLabel">Ingresar la informaci&oacute;n m&aacute;s importante</span></h2>
  <!-- PONER LO DEL BRYAN AQUI -->
  <table class="table table-hover"><tr>
<td> <span class="input-group-addon" id="basic-addon1">Descripci&oacute;n de la información: </span>
  <center><textarea id="txtArea" rows="20" cols="100" name="txtAreaInfo" aria-describedby="basic-addon1"  required></textarea></center></td>
</tr>
</table>
<br> 
</center>
      <center>
<input type="submit" name="btnRegistar" class="btn btn-success" role="button" value="Agregar Información">
<a class="btn btn-danger" href="index.jsp" role="button">Cancelar</a>

</center>
       
</form>
</div>
<!-- ------------------------------------ -->


</div><!--row -->
</div><!--Container-fluid -->
</div><!--Wrap-->


	<script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
      
</body>
</html>
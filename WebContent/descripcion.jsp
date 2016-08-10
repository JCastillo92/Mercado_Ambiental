<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
	response.sendRedirect("index.jsp");
}else{
	perf = (Integer)sessionok.getAttribute("log");

}

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
<title>Descripci&oacute;n</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">

</head>
<body background="imagenes/fondo.jpg">

<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>

<div class="row">
<%=lugardelaimagen%>
<img id="zoom_01" src="imagen?prod=<%=id%>&place=<%=lugardelaimagen%>&i_tipo=1" width="250px" height="250px" alt="..." class="img-thumbnail center-block">
</div>

<br>

<div class="row">

	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=1"><img src="imagen?prod=<%=id%>&place=1&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=2"><img src="imagen?prod=<%=id%>&place=2&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=3"><img src="imagen?prod=<%=id%>&place=3&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="descripcion.jsp?id=<%=id%>&lug=4"><img src="imagen?prod=<%=id%>&place=4&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>

</div>

<div class="row">
	
	<div class="col-md-6">
		
		<center><h1><span class="label label-success"> DESCRIPCI&Oacute;N </span></h1></center>
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

<br>
<br>
<br>
<div id="footer" style="text-align: center; font-size: 15px; border: 5px solid #A8A59C; color:#6E6E6E;background-color:#F2F2F2">
<br>

Desarrollado por la Carrera: Ingeniería de Sistemas
<br>
Universidad Politécnica Salesiana
<br>
      Sede Quito - Campus Sur

<br>
Quito - Ecuador 2016
<br>
<br>
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
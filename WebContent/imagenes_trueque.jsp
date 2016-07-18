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
	//response.sendRedirect("index.jsp");
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
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">

</head>
<body background="imagenes/fondo.jpg">

<div id="wrap">

<div class="container-fluid">

<div class="row">
<img id="zoom_01" src="imagen?prod=<%=id%>&place=<%=lugardelaimagen%>&i_tipo=1" width="250px" height="250px" alt="..." class="img-thumbnail center-block">
</div>
<br>
<div class="row">

	<div class="col-md-3">
		<a href="imagenes_trueque.jsp?id=<%=id%>&lug=1"><img src="imagen?prod=<%=id%>&place=1&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="imagenes_trueque.jsp?id=<%=id%>&lug=2"><img src="imagen?prod=<%=id%>&place=2&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="imagenes_trueque.jsp?id=<%=id%>&lug=3"><img src="imagen?prod=<%=id%>&place=3&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>
	
	<div class="col-md-3">
		<a href="imagenes_trueque.jsp?id=<%=id%>&lug=4"><img src="imagen?prod=<%=id%>&place=4&i_tipo=1" class="img-circle center-block" width="50%" height="50%" alt="No hay imagen"></a>
	</div>

</div>

<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
<script src="Estilos/jquery.elevatezoom.js"></script>
<script src="Estilos/jquery.imageLens.js" type="text/javascript"></script>

</div>
</div>

<script>
$("#zoom_01").elevateZoom({tint:true, tintColour:'#F90', tintOpacity:0.5});
</script>

</body>
</html>
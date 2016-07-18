<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
Cls_Trueque obj2 = new Cls_Trueque();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0;
	response.sendRedirect("index.jsp");
}else{
	perf = (Integer)sessionok.getAttribute("log");

}

//PARA LISTRA LOS TRUEQUES
String listame_trueques="";
try{
	listame_trueques = obj2.listar_trueques();
}catch(Exception e){
	
}

//VALIDANDO SI NO HAY TRUEQUES
String id="0",lugardelaimagen;
int trueques_num;
trueques_num=obj.conteo_trueques();
if(trueques_num == 0){
	response.sendRedirect("index.jsp?error=No hay trueques disponibles");
}else{
	//INTENTARA OBTENER EL ID DE LA URL
	try{
		id = request.getParameter("id");
	}catch(Exception e){

	}//si no hay id en la url, entonces buscar un id en la base
	if(id==null){
		id = obj2.id_untrueque();
	}
		
}

//SACAR DATOS DE LAS IMAGENES
//LA 1RA IMAGEN SALDRA COMO PRINCIPAL POR DEFECTO
try{
	obj2.detalles_trueque_especifico(id);
}catch(Exception e){
	
}	

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trueque</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">

</head>
<body background="imagenes/fondo.jpg">

<%
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

<%
String menu;
menu = obj.desplegarmenus(perf);
out.print(menu);
%>



<div class="row">
	
	<div class="col-md-3"> <!-- MENU TRUEQUE -->
	
		<center><h1>
		<span class="label label-info"> 
		<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"> TRUEQUES </span> 
		</span>
		</h1></center>
		
		<br><br>
		<%
		out.print(listame_trueques);
		%>
	
	</div> <!-- FIN COLO MD 3 -->
	
	<div class="col-md-9">
		<center><h1><span class="label label-success"><%=obj2.getTitulo_t() %> </span></h1></center>
		<br><br>
		<div class="row">
			<iframe height="415px" width="100%" src="imagenes_trueque.jsp?id=<%=id%>&lug=1" name="iframe_a"></iframe>
		</div><!-- fin row -->
		<div class="row">
		
			<div class="col-md-1">
			</div>
			<div class="col-md-5">
				
				<center><h1><span class="label label-success"> DESCRIPCIÓN </span></h1></center>
				<br><br>
				<br><pre><%=obj2.getDescripcion_t()%></pre>
			
			</div>
			<div class="col-md-5">
			<center><h1><span class="label label-success"> TRUEQUE </span></h1></center>
				
				<div class="col-md-6">
					<h2 class="text-right"><span class="label label-primary">Ofertado por:</span></h2>
				</div>
					
				<div class="col-md-6">
					<h2><span class="label label-primary"><%=obj2.getCantidad_t() %> <%=obj2.getMoneda_t() %></span></h2>
				</div>
					<br><br><br>
				<form action="check_trueque?id=<%=id%>" method="post" >	
				<center><button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon glyphicon-plus-sign" aria-hidden="true">ACEPTAR TRUEQUE</span></button></center>
				</form>
			</div>
			<div class="col-md-1">
			</div>
			
		</div>
	
	</div> <!-- FIN COLO MD 9 -->


</div> <!-- FIN ROW -->

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
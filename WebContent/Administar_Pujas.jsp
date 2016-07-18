<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ClsPujas puja = new ClsPujas(); 
String principal;
String tipo;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administar Pujas</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body>


<%
principal=request.getParameter("dato");
tipo = request.getParameter("tipo");

if(principal != null && tipo.equals("1")){
//out.print(principal);
puja.Hacer_Principal(principal);
}

if(principal != null && tipo.equals("2")){
//out.print(principal);
puja.Pujas_Historico(principal);
puja.Eliminar_Tiempo(Integer.parseInt(principal));
puja.Eiminar_Puja(Integer.parseInt(principal));
puja.Eiminar_Imagen_Puja(Integer.parseInt(principal));
}

if(principal != null && tipo.equals("3")){
//out.print(principal);
puja.Actualizar_Valor_Anterior(principal);
}
%>
<span class="label label-success"> <span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true">OFERTAS ACTUALES</span> </span> 
<% 
out.print(puja.Todas_Pujas(1)); 
%>
<span class="label label-success"> <span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true">OFERTAS TERMINADAS</span> </span> 
<%
out.print(puja.Pujas_Terminadas(2));
%>
<span class="label label-success"> <span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true">OFERTAS PARA VOLVER A VALOR ANTERIOR</span> </span> 
<%
out.print(puja.Pujas_Valor_Anterior(1));
%>







<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
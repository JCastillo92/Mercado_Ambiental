<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ClsPujas puja = new ClsPujas(); 
String principal;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administar Pujas</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body>


<%
principal=request.getParameter("dato");

if(principal != null){
//out.print(principal);
puja.Hacer_Principal(principal);
}
else{
//out.print(puja.Puja_Pricipal());
}

out.print(puja.Todas_Pujas()); %>







<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
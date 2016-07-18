<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Historial ventas trueques</title>
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
%>

<div id="wrap">
<div class="container-fluid">
<div class="container">


<center><br>
<h3><span class="label label-default">HIST&Oacute;RICO DE TRUEQUES.</span></h3>
<br></center>
<!-- ----------------------------------------------------------------------------------------------- -->
<%
String print_user_data;
Cls_Trueque obj=new Cls_Trueque();
print_user_data=obj.lista_trueques_vendidos_historial();
out.print(print_user_data);
%>

<!-- -------------------------------------------------------------------------------------- -->
</div>
<div class="container">
<br>
<center><br>
<h3><span class="label label-default">HIST&Oacute;RICO DE PUJAS.</span></h3>
<br></center>
<!-- ----------------------------------------------------------------------------------------------- -->
<%
String print_user_data2;
print_user_data2=obj.lista_trueques_vendidos_puja();
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
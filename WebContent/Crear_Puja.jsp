<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ClsPujas puja = new ClsPujas(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Puja</title>
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
</head>
<body>

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
<div class="container">
 
 
 	<form action="Ingreso_Puja" method="post">
  	<div class="form-group">
  	<h4><label for="nombre">Nombre del Producto</label></h4>
  	<input type="text" class="form-control" name="nombre" required>
	</div>
	
	<div class="form-group">
  	<h4><label for="comment">Descripción del Producto</label></h4>
  	<textarea class="form-control" rows="3" name="descripcion" required></textarea>
	</div>
	
	<div class="form-group">
  	<h4><label for="nombre">Cantidad del Producto</label></h4>
  	<input type="text" class="form-control" name="cantidad" required>
	</div>

	
	<div class="form-group">
  	<h4><label for="sel1">Tipo de Moneda</label></h4>
 	<%out.print(puja.Moneda()); %>
	</div>
	
	<div class="form-group">
  	<h4><label for="sel1">Categorias</label></h4>
 	<%out.print(puja.cmbCategorias()); %>
	</div>
	
	<div class="form-group">
  	<h4><label for="pwd">Valor inicial de la Puja</label></h4>
  	<input type="text" class="form-control" name="valor" required>
	</div>
	
	<div class="form-group">
    <h4><label for="exampleInputFile">Seleccione la Primera Imagen</label></h4>
    <input type="file" name="exampleInputFile1" required>
  	</div>
	
	<div class="form-group">
    <h4><label for="exampleInputFile">Seleccione la Segunda Imagen</label></h4>
    <input type="file" name="exampleInputFile2" required>
  	</div>
	
	<div class="form-group">
    <h4><label for="exampleInputFile">Seleccione la Tercera Imagen</label></h4>
    <input type="file" name="exampleInputFile3" required>
  	</div>
  	
  	<div class="form-group">
    <h4><label for="exampleInputFile">Seleccione la Cuarta Imagen</label></h4>
    <input type="file" name="exampleInputFile4" required>
  	</div>
  	
  	<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon glyphicon-plus-sign" aria-hidden="true"> Crear Puja</span></button>
	</form>
</div>






<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>
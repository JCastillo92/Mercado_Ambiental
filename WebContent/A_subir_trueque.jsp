<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ClsPujas trueque = new ClsPujas(); %>
<%ClsAdmin cate = new ClsAdmin(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Subir un nuevo trueque</title>
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
	response.sendRedirect("index.jsp?error=false&msg=No tiene privilegios para acceder a este lugar");
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
	  <strong>ESTADO</strong>.<%=" Se ha producido un error, por favor actualize y vuelva a intentar, revise que el FORMATO de foto sea .jpg y que todos los campos se encuentren llenos "%>
	</div>
<%
}
%>
<!--FIN MENSAJE DEL SERVLET -->
<div id="wrap">
<div class="container-fluid">
<div class="row">
<center><h2><span title="Aqu&iacute; se procede a ingresar el producto para el trueque, se debe respetar los pasos para el ingreso del mismo" class="label label-default">INGRESO DE UN PRODUCTO PARA EL TRUEQUE</span></h2></center>

<div class="col-md-2">
<!-- NO PONER NADA AQUI -->
</div>

<div class="col-md-8">
<form action="Sr_A_ingresa_trueque" method="post" enctype="multipart/form-data">

<!-- /////////////////////////////////////////////////////////////////////////////// -->
<center>
<br>
        <h2><span class="label label-default" id="gridSystemModalLabel">Ingresar los datos del producto o art&iacute;culo</span></h2>
  <!-- PONER LO DEL BRYAN AQUI -->
  <table class="table table-hover"><tr>
<td> <span class="input-group-addon" id="basic-addon1">Descripci&oacute;n del producto: </span>
  <center><textarea id="txtArea" rows="10" cols="80" name="txtArea" aria-describedby="basic-addon1"  placeholder="ejem. Balon de la FIFA # 5" style="text-transform:uppercase" required></textarea></center></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1">Nombre del Producto: </span>
  <input type="text" class="form-control" name="txtProducto" placeholder="ejem. Nokia Lumia 520" aria-describedby="basic-addon1" style="text-transform:uppercase" maxlength="25" required></td>
</tr>
</table>

<table>
<tr>
<td><span class="input-group-addon" id="basic-addon1">Categor&iacute;a del Producto: </span>
 <%out.print(cate.Categoria()); %> </td>
 </tr>
</table>

<table>
<tr>
<td><span class="input-group-addon" id="basic-addon1">Ofertado por: </span>
 <%out.print(trueque.Moneda()); %> </td>
  <td><span class="input-group-addon" id="basic-addon1">cantidad </span>
  <input type="number" class="form-control" name="txtCantidad"  placeholder="ejem. 20" aria-describedby="basic-addon1" title="ingrese solo numeros" style="text-transform:uppercase" required></td>
</tr>
</table>

  <!-- //////////////////////////////////////PARTE DEL BRYAN INGRESO DEL ARTICULO O PRODUCTO/////////////////// -->
<!-- //////////////////////////////////////MI PARTE AQUI ABAJO INGRESO DE FOTOS/////////////////// -->
<br>
        <h2><span title="El ingreso de las 4 im&aacute;genes es obligatorio" class="label label-default" id="gridSystemModalLabel">Ingresar 4* fotos formato .jpg</span></h2>
        <br>
    <!--     ///////////////////  1 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 1 (.jpg)<span class="fileupload-new"></span>
     <input title="Foto 1 obligatoria" type="file" id="inputfoto1" accept="image/jpeg" name="img0" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
      <!--     ///////////////////  2 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 2 (.jpg)<span class="fileupload-new"></span>
     <input title="Foto 2 obligatoria" type="file" id="inputfoto2" accept="image/jpeg" name="img1" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
  <!--     ///////////////////  3 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 3 (.jpg)<span class="fileupload-new"></span>
    <input title="Foto 3 obligatoria" type="file" id="inputfoto3" accept="image/jpeg" name="img2" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
  <!--     ///////////////////  4 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 4 (.jpg)<span class="fileupload-new"></span>
    <input title="Foto 4 obligatoria" type="file" id="inputfoto4" accept="image/jpeg" name="img3" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
  		
        <input type="submit" name="btnRegistar" class="btn btn-success" role="button" value="AGREGAR TRUEQUE">
        </center>
        <br>
</form>
</div>
<!-- ------------------------------------ -->
<div class="col-md-2">
<!-- NO PONER NADA AQUI -->
</div>

</div><!--row -->
</div><!--Container-fluid -->
</div><!--Wrap-->


	<script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
    
</body>
</html>
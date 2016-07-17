<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ClsPujas trueque = new ClsPujas(); %>
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
	response.sendRedirect("index.jsp");
}else{
	perf=(Integer)sessionok.getAttribute("log");
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
<form action="Sr_A_ingresa_trueque" method="post">

<!-- /////////////////////////////////////////////////////////////////////////////// -->
<center>
<br>
        <h2><span class="label label-default" id="gridSystemModalLabel">Ingresar los datos y moneda del producto</span></h2>
  <!-- PONER LO DEL BRYAN AQUI -->
  <table class="table table-hover"><tr>
<td> <span class="input-group-addon" id="basic-addon1">Descripci&oacute;n del producto: </span>
  <center><textarea id="txtArea" rows="10" cols="80" name="txtArea" aria-describedby="basic-addon1"  placeholder="ejem. Balon de la FIFA # 5" style="text-transform:uppercase" required></textarea></center></td>
</tr>

<tr>
<td> <span class="input-group-addon" id="basic-addon1">Nombre del Producto: </span>
  <input type="text" class="form-control" name="txtProducto" placeholder="ejem. Nokia Lumia 520" aria-describedby="basic-addon1" style="text-transform:uppercase" required></td>
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
  		<!-- PATH IMAGENES INVISIBLES -->
  		<input type="hidden" id="input01" name="path_imagen1">
  		<input type="hidden" id="input02" name="path_imagen2">
  		<input type="hidden" id="input03" name="path_imagen3">
  		<input type="hidden" id="input04" name="path_imagen4">
  		
        <input type="submit" name="btnRegistar" class="btn btn-success" onclick="detectarnav();" role="button" value="AGREGAR TRUEQUE">
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
    
    <!-- SCRIPT PARA SACAR PATH DE LAS IMAGENES -->
    <script type="text/javascript">

	function detectarnav(){
		var version = detectIE();
		var antiguo,antiguo2,antiguo3,antiguo4;
		antiguo=document.getElementById('inputfoto1').value;
		antiguo2=document.getElementById('inputfoto2').value;
		antiguo3=document.getElementById('inputfoto3').value;
		antiguo4=document.getElementById('inputfoto4').value;
		if (version === false) {
		  var path; 
		  var nAgt = navigator.userAgent;
		  var verOffset;
		  path = "C:/Imagenes/";
		  if ((verOffset=nAgt.indexOf("Firefox"))!=-1) {
			  document.getElementById('input01').value = path+antiguo;
			  document.getElementById('input02').value = path+antiguo2;
			  document.getElementById('input03').value = path+antiguo3;
			  document.getElementById('input04').value = path+antiguo4;
			 }else{
				 var longitud_nombre = antiguo.length;
				 var longitud_nombre2 = antiguo2.length;
				 var longitud_nombre3 = antiguo3.length;
				 var longitud_nombre4 = antiguo4.length;
				 var imagen_nombre = antiguo.substring(12, longitud_nombre);
				 var imagen_nombre2 = antiguo2.substring(12, longitud_nombre2);
				 var imagen_nombre3 = antiguo3.substring(12, longitud_nombre3);
				 var imagen_nombre4 = antiguo4.substring(12, longitud_nombre4);
				 document.getElementById('input01').value = path+imagen_nombre;
				 document.getElementById('input02').value = path+imagen_nombre2;
				 document.getElementById('input03').value = path+imagen_nombre3;
				 document.getElementById('input04').value = path+imagen_nombre4;
			 }
		  
		} else if (version >= 12) {
		  document.getElementById('input01').value = antiguo;
		  document.getElementById('input02').value = antiguo2;
		  document.getElementById('input03').value = antiguo3;
		  document.getElementById('input04').value = antiguo4;
		} else {
		  document.getElementById('input01').value = antiguo;
		  document.getElementById('input02').value = antiguo2;
		  document.getElementById('input03').value = antiguo3;
		  document.getElementById('input04').value = antiguo4;
		}
	}
	
	/**
	 * detect IE
	 * returns version of IE or false, if browser is not Internet Explorer
	 */
	function detectIE() {
		 
		 
	  var ua = window.navigator.userAgent;
	
	  // Test values; Uncomment to check result …
	
	  // IE 10
	  // ua = 'Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)';
	  
	  // IE 11
	  // ua = 'Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv:11.0) like Gecko';
	  
	  // Edge 12 (Spartan)
	  // ua = 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36 Edge/12.0';
	  
	  // Edge 13
	  // ua = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586';
	
	  var msie = ua.indexOf('MSIE ');
	  if (msie > 0) {
	    // IE 10 or older => return version number
	    return parseInt(ua.substring(msie + 5, ua.indexOf('.', msie)), 10);
	  }
	
	  var trident = ua.indexOf('Trident/');
	  if (trident > 0) {
	    // IE 11 => return version number
	    var rv = ua.indexOf('rv:');
	    return parseInt(ua.substring(rv + 3, ua.indexOf('.', rv)), 10);
	  }
	
	  var edge = ua.indexOf('Edge/');
	  if (edge > 0) {
	    // Edge (IE 12+) => return version number
	    return parseInt(ua.substring(edge + 5, ua.indexOf('.', edge)), 10);
	  }
	
	  // other browser
	  return false;
	}
	
	</script>
    <!-- FIN DEL SCRIPT -->
    
</body>
</html>
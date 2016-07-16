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
	
	<table class="table table-inverse">
	<tr>
	<th>Año Límite</th>
	<th>Mes Límite</th>
	<th>Día Límite</th>
	<th>Hora Límite</th>
	<th>Minuto Límiteyy</th>
	</tr>
	
	<tr>
	<td><input type="text" class="form-control" name="año" required></td>
	<td><input type="text" class="form-control" name="mes" required></td>
	<td><input type="text" class="form-control" name="dia" required></td>
	<td><input type="text" class="form-control" name="hora" required></td>
	<td><input type="text" class="form-control" name="minuto" required></td>
	</tr>
  
	</table>
	
	<br>
	
  <div class="form-group">
    <center>
    <!--     ///////////////////  1 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 1 (.jpg)<span class="fileupload-new"></span>
     <input title="Foto 1 obligatoria" type="file" id="inputfoto1" accept="image/jpeg" name="img1" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
      <!--     ///////////////////  2 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 2 (.jpg)<span class="fileupload-new"></span>
     <input title="Foto 2 obligatoria" type="file" id="inputfoto2" accept="image/jpeg" name="img2" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
  <!--     ///////////////////  3 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 3 (.jpg)<span class="fileupload-new"></span>
    <input title="Foto 3 obligatoria" type="file" id="inputfoto3" accept="image/jpeg" name="img3" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
  <!--     ///////////////////  4 ////////////////////////////////       -->
     <div class="fileupload fileupload-new">
    <span class="btn btn-primary btn-file">FOTO 4 (.jpg)<span class="fileupload-new"></span>
    <input title="Foto 4 obligatoria" type="file" id="inputfoto4" accept="image/jpeg" name="img4" required>
    </span>
    <span class="fileupload-preview"></span>
  </div>
  <br>
  </center>
  </div>
  	
  	<!-- PATH IMAGENES INVISIBLES -->
  		<input type="hidden" id="input01" name="path_imagen1">
  		<input type="hidden" id="input02" name="path_imagen2">
  		<input type="hidden" id="input03" name="path_imagen3">
  		<input type="hidden" id="input04" name="path_imagen4">
  	<button type="submit" class="btn btn-info" onclick="detectarnav();"><span class="glyphicon glyphicon glyphicon-plus-sign" aria-hidden="true"> Crear Puja</span></button>
	</form>
</div>






<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>

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
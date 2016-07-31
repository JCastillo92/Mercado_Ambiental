<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">

<!-- JAVASCRIPT DETECTAR MI NAVEGDOR -->
<script type="text/javascript">

var nVer = navigator.appVersion;
var nAgt = navigator.userAgent;
var browserName  = navigator.appName;
var fullVersion  = ''+parseFloat(navigator.appVersion); 
var majorVersion = parseInt(navigator.appVersion,10);
var nameOffset,verOffset,ix;

// In Opera, the true version is after "Opera" or after "Version"
if ((verOffset=nAgt.indexOf("Opera"))!=-1) {
 browserName = "Opera";
 fullVersion = nAgt.substring(verOffset+6);
 if ((verOffset=nAgt.indexOf("Version"))!=-1) 
   fullVersion = nAgt.substring(verOffset+8);
}
// In Chrome, the true version is after "Chrome" 
else if ((verOffset=nAgt.indexOf("Chrome"))!=-1) {
 browserName = "Chrome";
 fullVersion = nAgt.substring(verOffset+7);
}
// In Safari, the true version is after "Safari" or after "Version" 
else if ((verOffset=nAgt.indexOf("Safari"))!=-1) {
 browserName = "Safari";
 fullVersion = nAgt.substring(verOffset+7);
 if ((verOffset=nAgt.indexOf("Version"))!=-1) 
   fullVersion = nAgt.substring(verOffset+8);
}
// In Firefox, the true version is after "Firefox" 
else if ((verOffset=nAgt.indexOf("Firefox"))!=-1) {
 browserName = "Firefox";
 fullVersion = nAgt.substring(verOffset+8);
}
// In most other browsers, "name/version" is at the end of userAgent 
else if ( (nameOffset=nAgt.lastIndexOf(' ')+1) < 
          (verOffset=nAgt.lastIndexOf('/')) ) 
{
 browserName = nAgt.substring(nameOffset,verOffset);
 fullVersion = nAgt.substring(verOffset+1);
 if (browserName.toLowerCase()==browserName.toUpperCase()) {
  browserName = navigator.appName;
 }
}
// trim the fullVersion string at semicolon/space if present
if ((ix=fullVersion.indexOf(";"))!=-1)
   fullVersion=fullVersion.substring(0,ix);
if ((ix=fullVersion.indexOf(" "))!=-1)
   fullVersion=fullVersion.substring(0,ix);

majorVersion = parseInt(''+fullVersion,10);
if (isNaN(majorVersion)) {
 fullVersion  = ''+parseFloat(navigator.appVersion); 
 majorVersion = parseInt(navigator.appVersion,10);
}

document.write(''
 +'Browser name  = '+browserName+'<br>'
 +'Full version  = '+fullVersion+'<br>'
 +'Major version = '+majorVersion+'<br>'
 +'navigator.appName = '+navigator.appName+'<br>'
 +'navigator.userAgent = '+navigator.userAgent+'<br>'
);

//window.location.replace("A_subir_trueque.jsp");

</script>
<!-- FIN JAVASCRIPT -->

<title>Insert title here</title>
</head>
<body>

<!-- INICIO CONTENIDO -->

<div id="wrap">

<div class="container-fluid">

<div class="row">
<div class="col-md-3">
<h3><span class="label label-default">Imagen Perfil:</span></h3><img src="imagen" class="img-responsive" alt="Cruz Azul">
</div>
<div class="col-md-7">

<form class="form-horizontal" method="post" action="prueba_imagen">
  
  <div class="form-group">
    <label for="inputfoto" class="col-sm-2 control-label">Escoger Foto</label>
    <div class="col-sm-10">
      <input title="Foto obligatoria" type="file" class="form-control" id="inputfoto" accept="image/jpeg" name="btnarchivo" required>​
    </div>
  </div>
  <input type="hidden" id="input02" name="path_imagen">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" onclick="detectarnav();">Registrarse</button>
    </div>
  </div>
</form>
<h1 id="result2">detecting…</h1>
<h2 id="result">detecting…</h2>
<input type="text" id="input01">

<button type="button" onclick="detectarnav();">

<!-- PRUEBA SUBIR IMAGEN -->
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>


</div>

<div class="col-md-2">

<div style="position:relative;">
        <a class='btn btn-primary' href='javascript:;'>
            Choose File...
            <input type="file" style='position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";opacity:0;background-color:transparent;color:transparent;' name="file_source" size="40"  onchange='$("#upload-file-info").html($(this).val());'>
        </a>
        &nbsp;
        <span class='label label-info' id="upload-file-info"></span>
</div>

</div>

</div>

</div>  <!-- FIN CONTAINER -->

</div> <!-- FIN WRAP  -->

  
    
<div id="footer">
<div class="container text-center">
<br>
Copyright © JJCompany<br>
Desarrollado por: JCastillo,JFlores
<br>
jcastillor1@est.ups.edu.ec, jfloresg1@est.ups.edu.ec

</div>
</div>   

<!-- FIN CONTENIDO -->

<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
    
    <!-- JAVASCRIPT DETECTAR MI NAVEGDOR -->
<script type="text/javascript">

function detectarnav(){
	var version = detectIE();
	var antiguo;
	antiguo=document.getElementById('inputfoto').value;
	if (version === false) {
	  document.getElementById('result').innerHTML = 'IE/Edge';
	  var path; 
	  var nAgt = navigator.userAgent;
	  var verOffset;
	  path = "C:/Imagenes/";
	  if ((verOffset=nAgt.indexOf("Firefox"))!=-1) {
		  document.getElementById('result2').innerHTML = path+antiguo;
		  document.getElementById('input01').value = path+antiguo;
		  document.getElementById('input02').value = path+antiguo;
		 }else{
			 var longitud_nombre = antiguo.length;
			 var imagen_nombre = antiguo.substring(12, longitud_nombre);
			 document.getElementById('result2').innerHTML = path+imagen_nombre; 
			 document.getElementById('input01').value = path+imagen_nombre;
			 document.getElementById('input02').value = path+imagen_nombre;
		 }
	  
	  //document.getElementById('inputfoto').innerHTML = hola+antiguo;
	} else if (version >= 12) {
	  document.getElementById('result').innerHTML = 'Edge ' + version;
	  document.getElementById('input02').value = antiguo;
	} else {
	  document.getElementById('result').innerHTML = 'IE ' + version;
	  document.getElementById('input02').value = antiguo;
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

<script type="text/javascript">

function changeImage(lugar){
	var imagen_antigua;
	var str;
	str=document.getElementById("zoom_01").src;
	    var pos = str.indexOf("place=");
	    var pos2 = str.indexOf("&i_tipo");
	    var res2 = str.substring(pos, pos2);
	    var res = str.replace(res2, "place="+lugar);
	    document.getElementById("zoom_01").src = res;
}

</script>
</body>
</html>
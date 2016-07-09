<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">

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
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Registrarse</button>
    </div>
  </div>
</form>

</div>

<div class="col-md-2">

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

</body>
</html>
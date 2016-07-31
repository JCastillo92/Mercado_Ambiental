<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="metodos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
HttpSession sessionok = request.getSession();
Cls_General obj= new Cls_General();
int perf;
double ag,lz,tel,inte,tot;
if(sessionok.getAttribute("log")==null){
	perf = 0; 
}else{
	perf = (Integer)sessionok.getAttribute("log");
}

if(perf !=2){
	response.sendRedirect("index.jsp?error=false&msg=No tiene privilegios para acceder a este lugar");
}
ClsPujas puja = new ClsPujas(); 
%>
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
 
 
 	<form action="Ingreso_Puja" method="post" enctype="multipart/form-data">
  	<div class="form-group">
  	<h4><label for="nombre">Nombre del Producto</label></h4>
  	<input type="text" class="form-control" name="nombre" required>
	</div>
	
	<div class="form-group">
  	<h4><label for="comment">Descripci&oacute;n del Producto</label></h4>
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
  	<h4><label for="sel1">Categor&iacute;as</label></h4>
 	<%out.print(puja.cmbCategorias()); %>
	</div>
	
	<div class="form-group">
  	<h4><label for="pwd">Valor inicial de la Puja</label></h4>
  	<input type="text" class="form-control" name="valor" required>
	</div>
	
	<table class="table table-inverse">
	<tr>
	<th>A&ntilde;o L&iacute;mite</th>
	<th>Mes L&iacute;mite</th>
	<th>D&iacute;a L&iacute;mite</th>
	<th>Hora L&iacute;mite</th>
	<th>Minuto L&iacute;mite</th>
	</tr>
	
	<tr>
	<td>
	<select class="form-control" name="anio">
 	<option>2016</option>
  	<option>2017</option>
  	<option>2018</option>
  	<option>2019</option>
  	<option>2020</option>
  	<option>2021</option>
  	<option>2022</option>
  	<option>2023</option>
  	<option>2024</option>
  	<option>2025</option>
  	<option>2026</option>
  	<option>2027</option>
  	<option>2028</option>
  	<option>2029</option>
  	<option>2030</option>
  	<option>2031</option>
  	<option>2032</option>
  	<option>2033</option>
  	<option>2034</option>
  	<option>2035</option>
  	<option>2036</option>
  	<option>2037</option>
  	<option>2038</option>
  	<option>2039</option>
  	<option>2040</option>
	</select>
	</td>
	
	<td>
	<select class="form-control" name="mes">
 	<option>January</option>
  	<option>February</option>
  	<option>March</option>
  	<option>April</option>
  	<option>June</option>
  	<option>July</option>
  	<option>August</option>
  	<option>September</option>
  	<option>October</option>
  	<option>November</option>
  	<option>December</option>
	</select>
	</td>
	
	<td>
	<select class="form-control" name="dia">
 	<option>01</option>
  	<option>02</option>
  	<option>03</option>
  	<option>04</option>
  	<option>05</option>
  	<option>06</option>
  	<option>07</option>
  	<option>08</option>
  	<option>09</option>
  	<option>10</option>
  	<option>11</option>
  	<option>12</option>
  	<option>13</option>
  	<option>14</option>
  	<option>15</option>
  	<option>16</option>
  	<option>17</option>
  	<option>18</option>
  	<option>19</option>
  	<option>20</option>
  	<option>21</option>
  	<option>22</option>
  	<option>23</option>
  	<option>24</option>
  	<option>25</option>
  	<option>26</option>
  	<option>27</option>
  	<option>28</option>
  	<option>29</option>
  	<option>30</option>
  	<option>31</option>
	</select>
	</td>
	
	<td>
	<select class="form-control" name="hora">
	<option>00</option>
 	<option>01</option>
  	<option>02</option>
  	<option>03</option>
  	<option>04</option>
  	<option>05</option>
  	<option>06</option>
  	<option>07</option>
  	<option>08</option>
  	<option>09</option>
  	<option>10</option>
  	<option>11</option>
  	<option>12</option>
  	<option>13</option>
  	<option>14</option>
  	<option>15</option>
  	<option>16</option>
  	<option>17</option>
  	<option>18</option>
  	<option>19</option>
  	<option>20</option>
  	<option>21</option>
  	<option>22</option>
  	<option>23</option>
	</select>
	</td>
	
	<td>
	<select class="form-control" name="minuto">
	<option>00</option>
 	<option>01</option>
  	<option>02</option>
  	<option>03</option>
  	<option>04</option>
  	<option>05</option>
  	<option>06</option>
  	<option>07</option>
  	<option>08</option>
  	<option>09</option>
  	<option>10</option>
  	<option>11</option>
  	<option>12</option>
  	<option>13</option>
  	<option>14</option>
  	<option>15</option>
  	<option>16</option>
  	<option>17</option>
  	<option>18</option>
  	<option>19</option>
  	<option>20</option>
  	<option>21</option>
  	<option>22</option>
  	<option>23</option>
  	<option>24</option>
  	<option>25</option>
  	<option>26</option>
  	<option>27</option>
  	<option>28</option>
  	<option>29</option>
  	<option>30</option>
  	<option>31</option>
  	<option>32</option>
  	<option>33</option>
  	<option>34</option>
  	<option>35</option>
  	<option>36</option>
  	<option>37</option>
  	<option>38</option>
  	<option>39</option>
  	<option>40</option>
  	<option>41</option>
  	<option>42</option>
  	<option>43</option>
  	<option>44</option>
  	<option>45</option>
  	<option>46</option>
  	<option>47</option>
  	<option>48</option>
  	<option>49</option>
  	<option>40</option>
  	<option>51</option>
  	<option>52</option>
  	<option>53</option>
  	<option>54</option>
  	<option>55</option>
  	<option>56</option>
  	<option>57</option>
  	<option>58</option>
  	<option>59</option>
	</select>
	</td>

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
  	
  	<center><button type="submit" class="btn btn-success" onclick="detectarnav();"><span class="glyphicon glyphicon glyphicon-plus-sign" aria-hidden="true"> Crear Puja</span></button></center>
	</form>
	<br>
</div>

<script src="css/jquery-2.1.4.min.js"></script>
<script src="css/bootstrap.min.js"></script>

</body>
</html>
package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.ClsConexion;

public class Cls_General {
	
	String nombre;
	int log;
	int perfil;
	String cedula;
	public int getPerfil() {
	return perfil;
	}
	public void setPerfil(int perfil) {
	this.perfil = perfil;
	}

	public String getNombre() {
	return nombre;
	}

	public void setNombre(String nombre) {
	this.nombre = nombre;
	}

	public int getLog() {
	return log;
	}

	public void setLog(int log) {
	this.log = log;
	}
	
	public String getCedula(){
	return cedula;
	}
	public void setCedula(String cedula){
	this.cedula=cedula;
	}

	public String desplegarmenus(int perfil){
		
		boolean t =false;
		String menu = "<nav class=\"navbar navbar-default\" role=\"navigation\">";
		menu += "<div class=\"container-fluid\">";
		menu +="<div class=\"navbar-header\">";
		menu +="<a href=\"index.jsp\"><img src=\"imagenes/ups.png\" align=\"left\" alt=\"Logo\" style=\"max-width:100%;height:auto;\"></a>";
		menu +="<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">";
		menu +="<span class=\"sr-only\">Toggle navigation</span>"
				+ "<span class=\"icon-bar\"></span>"
	                    +"<span class=\"icon-bar\"></span>"
	                    +"<span class=\"icon-bar\"></span>"
	                +"</button></div>";
		menu +="<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">"+
	                "<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"index.jsp\"><span class=\"glyphicon glyphicon-home\" aria-hidden=\"true\"></span></a></li>";
		
		
		if(perfil != 0){
			String sql = "select nombre_pag, url from tb_paginas, tb_pagper where id_pagina = fk_id_pag and fk_id_perfil ="+perfil;
			ClsConexion obj = new ClsConexion();
			ResultSet rs = null;
			
			try {
				rs=obj.Consulta(sql);
				while(rs.next()){
					
					menu += "<li><a href=\""+rs.getString(2)+"\"><span class=\"glyphicon glyphicon-th-list\" aria-hidden=\"true\"></span>"+rs.getString(1)+"</a></li>";
					
					t=true;
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				rs.close();
				obj.getConexion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		//menu +="<p class=\"navbar-text\">Logueado como <%= usuariorec %></p>";
		if(t){
			/*
			menu += "<li><a href=\"puja.jsp\"><span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>Puja</a></li>";
			menu += "<li><a href=\"descripcion.jsp\"><span class=\"glyphicon glyphicon-tasks\" aria-hidden=\"true\"></span>Trueque</a></li>";
			menu += "<li><a href=\"Usuario_peronal.jsp\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>Mi Perfil</a></li>";*/
			menu += "<li><a href=\"cerrando\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> Cerrar Sesi&oacute;n</a></li>";
		}else{
			
	      	menu +="<form class=\"navbar-form navbar-left\" role=\"search\" action=\"logueame\">"+
	      			"<div class=\"form-group\">"+
	      			"<input type=\"text\" class=\"form-control\" name=\"txtuser\"autofocus placeholder=\"Usuario\"></div>"+
	      			"<div class=\"form-group\">"+
	      			"<input type=\"password\" class=\"form-control\" name=\"txtpassword\" placeholder=\"Password\"></div>"+
	      			"<button type=\"submit\" class=\"btn btn-default\">Login</button></form>"+
	      			"<li><a href=\"registro.jsp\"><span class=\"glyphicon glyphicon-check\" aria-hidden=\"true\"></span>Registrar</a></li>";;
		}
		
		menu +="</ul></div></div></nav>";
		return menu;		
	}
	
	public boolean ComprobarLoguin(String usuario, String clave){
		boolean t = false;
		ClsConexion obj = new ClsConexion();
		ResultSet rs=null;
		String sql,sql2,nombre2,login_us2,direccion2;int perfil2=0 ,cedula = 0;
		byte[] imgBytes3;
		sql = "Select * from tb_usuarios where id_usuario='"+usuario+"' and clave='"+clave+"';";
		sql2="Select tb_usuarios.id_usuario,nombre,apellido,clave,correo,direccion,celular,perfil,tb_activos_usuarios.estado from tb_usuarios,tb_activos_usuarios where tb_usuarios.id_usuario='"+usuario+"' and tb_usuarios.clave='"+clave+"' and tb_usuarios.id_usuario=tb_activos_usuarios.id_fk_usuario and tb_activos_usuarios.estado=true"+
				" group by tb_usuarios.id_usuario,nombre,apellido,clave,correo,direccion,celular,perfil,tb_activos_usuarios.estado;";
		try {
			rs = obj.Consulta(sql2);
			while(rs.next()){
				login_us2= rs.getString(1);
				nombre2 = rs.getString(2);
				perfil2 = rs.getInt(8);
				setLog(perfil2);
				setPerfil(perfil2);
				setNombre(nombre2);
				setCedula(login_us2);
				t=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(t);
		System.out.println(sql);
		
		try {
			rs.close();
			obj.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public int conteo_trueques(){
		int contador=0;
		String sql = "select * from tb_trueque";
		ClsConexion obj = new ClsConexion();
		ResultSet rs = null;
		try {
			rs=obj.Consulta(sql);
			while(rs.next()){
				contador++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			rs.close();
			obj.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contador;
	}
	
	public String carruseles(){
		String c = "";
		
		//Saco cuantos trueques existen
		int numero_trueques;
		numero_trueques = conteo_trueques();
		ClsConexion obj = new ClsConexion();
		ResultSet rs = null;
		ArrayList<String> id_producto_trs = new ArrayList<String>();
		ArrayList<String> titulos = new ArrayList<String>();
		ArrayList<String> cantidades = new ArrayList<String>();
		ArrayList<String> monedas= new ArrayList<String>();
		String sql ="select id_producto_tr, titulo, cantidad, tb_monedas.descripcion " 
					+"from tb_trueque,tb_monedas "
					+"where moneda = id_moneda "
					+"order by fecha_trueque DESC "
					+"limit 4";
		switch(numero_trueques){
			case 0:
				// NO HAY TRUEQUES
				c ="<h2>De momento no contamos con trueques</h2>";
				break;
			case 1:
				c = "<center><h3><span class=\"label label-info\">";
				try {
					rs=obj.Consulta(sql);
					while(rs.next()){
						id_producto_trs.add(rs.getString(1));
						titulos.add(rs.getString(2));
						cantidades.add(rs.getString(3));
						monedas.add(rs.getString(4));
					}
					/*id_producto_trs.get(0);
					titulos.get(0);
					cantidades.get(0);
					monedas.get(0); */
					c +="<span class=\"glyphicon glyphicon glyphicon-education\" aria-hidden=\"true\">"+titulos.get(0)+"</span>" ;
					c +="</span></h3></center>";
					c +="<div id=\"carrusel-1\" class=\"carousel slide\" data-ride=\"carousel\">";
					c +="<ol class=\"carousel-indicators\">";
					c +="<li data-target=\"carrusel-1\" data-slide-to=\"0\" class=\"active\"></li>";
					c +="<li data-target=\"carrusel-1\" data-slide-to=\"1\"></li>";
					c +="<li data-target=\"carrusel-1\" data-slide-to=\"2\"></li></ol>";
					c +="<div class=\"carousel-inner\">";
					c +="<div class=\"item active\">";
					c +="<img src=\"imagen?prod="+id_producto_trs.get(0)+"&place=<%=1%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
					c +="<div class=\"carousel-caption\"></div>";
					c +="<center><h6><font color=\"white\">"+cantidades.get(0)+" "+monedas.get(0)+"</font></h6></center></div>";
					c +="<div class=\"item\">";
					c +="<img src=\"imagen?prod="+id_producto_trs.get(0)+"&place=<%=2%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
					c +="<div class=\"carousel-caption\"></div>";
					c +="<center><h6><font color=\"white\">"+cantidades.get(0)+" "+monedas.get(0)+"</font></h6></center></div>";
					c +="<div class=\"item\">";
					c +="<img src=\"imagen?prod="+id_producto_trs.get(0)+"&place=<%=3%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
					c +="<div class=\"carousel-caption\"></div>";
					c +="<center><h6><font color=\"white\">"+cantidades.get(0)+" "+monedas.get(0)+"</font></h6></center></div>";
					c +="</div></div>";
					c +="<a class=\"left carousel-control\" href=\"#carrusel-1\" role=\"button\" data-slide=\"prev\">";
					c +="<span class=\"glyphicon glyphicon-chevron-left\"></span></a>";
					c +="<a class=\"right carousel-control\" href=\"#carrusel-1\" role=\"button\" data-slide=\"next\">";
					c +="<span class=\"glyphicon glyphicon-chevron-right\"></span></a><br>";
					c +="<center><h4><a href=\"descripcion.jsp?id="+id_producto_trs.get(0)+"\"><span class=\"label label-success\">";
					c +="SABER MÁS</span></a></h4></center>";
					c +="";
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				break;
			case 2:
				//AQUI EMPIEZA EL 1ER
				
				try {
					rs=obj.Consulta(sql);
					while(rs.next()){
						id_producto_trs.add(rs.getString(1));
						titulos.add(rs.getString(2));
						cantidades.add(rs.getString(3));
						monedas.add(rs.getString(4));
					}
					
					for (int i = 0; i < titulos.size(); i++) {
						c +="<div class=\"col-md-6\">";
						c += "<center><h3><span class=\"label label-info\">";
						c +="<span class=\"glyphicon glyphicon glyphicon-education\" aria-hidden=\"true\">"+titulos.get(i)+"</span>" ;
						c +="</span></h3></center>";
						c +="<div id=\"carrusel-1\" class=\"carousel slide\" data-ride=\"carousel\">";
						c +="<ol class=\"carousel-indicators\">";
						c +="<li data-target=\"carrusel-1\" data-slide-to=\"0\" class=\"active\"></li>";
						c +="<li data-target=\"carrusel-1\" data-slide-to=\"1\"></li>";
						c +="<li data-target=\"carrusel-1\" data-slide-to=\"2\"></li></ol>";
						c +="<div class=\"carousel-inner\">";
						c +="<div class=\"item active\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=<%=1%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=<%=2%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=<%=3%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="</div></div>";
						c +="<a class=\"left carousel-control\" href=\"#carrusel-1\" role=\"button\" data-slide=\"prev\">";
						c +="<span class=\"glyphicon glyphicon-chevron-left\"></span></a>";
						c +="<a class=\"right carousel-control\" href=\"#carrusel-1\" role=\"button\" data-slide=\"next\">";
						c +="<span class=\"glyphicon glyphicon-chevron-right\"></span></a><br>";
						c +="<center><h4><a href=\"descripcion.jsp?id="+id_producto_trs.get(0)+"\"><span class=\"label label-success\">";
						c +="SABER MÁS</span></a></h4></center></div>";
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				break;
			case 3:
				
				try {
					rs=obj.Consulta(sql);
					while(rs.next()){
						id_producto_trs.add(rs.getString(1));
						titulos.add(rs.getString(2));
						cantidades.add(rs.getString(3));
						monedas.add(rs.getString(4));
					}
					
					for (int i = 0; i < titulos.size(); i++) {
						c +="<div class=\"col-md-4\">";
						c += "<center><h3><span class=\"label label-info\">";
						c +="<span class=\"glyphicon glyphicon glyphicon-education\" aria-hidden=\"true\">"+titulos.get(i)+"</span>" ;
						c +="</span></h3></center>";
						c +="<div id=\"carrusel-1\" class=\"carousel slide\" data-ride=\"carousel\">";
						c +="<ol class=\"carousel-indicators\">";
						c +="<li data-target=\"carrusel-1\" data-slide-to=\"0\" class=\"active\"></li>";
						c +="<li data-target=\"carrusel-1\" data-slide-to=\"1\"></li>";
						c +="<li data-target=\"carrusel-1\" data-slide-to=\"2\"></li></ol>";
						c +="<div class=\"carousel-inner\">";
						c +="<div class=\"item active\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=<%=1%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=<%=2%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=<%=3%>&i_tipo=<%=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="</div></div>";
						c +="<a class=\"left carousel-control\" href=\"#carrusel-1\" role=\"button\" data-slide=\"prev\">";
						c +="<span class=\"glyphicon glyphicon-chevron-left\"></span></a>";
						c +="<a class=\"right carousel-control\" href=\"#carrusel-1\" role=\"button\" data-slide=\"next\">";
						c +="<span class=\"glyphicon glyphicon-chevron-right\"></span></a><br>";
						c +="<center><h4><a href=\"descripcion.jsp?id="+id_producto_trs.get(0)+"\"><span class=\"label label-success\">";
						c +="SABER MÁS</span></a></h4></center></div>";
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				break;
			
			default:
				
				try {
					rs=obj.Consulta(sql);
					while(rs.next()){
						id_producto_trs.add(rs.getString(1));
						titulos.add(rs.getString(2));
						cantidades.add(rs.getString(3));
						monedas.add(rs.getString(4));
					}
					
					for (int i = 0; i < titulos.size(); i++) {
						c +="<div class=\"col-md-3\">";
						c += "<center><h3><span class=\"label label-info\">";
						c +="<span class=\"glyphicon glyphicon glyphicon-education\" aria-hidden=\"true\">"+titulos.get(i)+"</span>" ;
						c +="</span></h3></center>";
						c +="<div id=\"carrusel-"+i+"\" class=\"carousel slide\" data-ride=\"carousel\">";
						c +="<ol class=\"carousel-indicators\">";
						c +="<li data-target=\"carrusel-"+i+"\" data-slide-to=\"0\" class=\"active\"></li>";
						c +="<li data-target=\"carrusel-"+i+"\" data-slide-to=\"1\"></li>";
						c +="<li data-target=\"carrusel-"+i+"\" data-slide-to=\"2\"></li>";
						c +="<li data-target=\"carrusel-"+i+"\" data-slide-to=\"3\"></li></ol>";
						c +="<div class=\"carousel-inner\">";
						c +="<div class=\"item active\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=1%>&i_tipo=1%>\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=2&i_tipo=1\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=3&i_tipo=1\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="<div class=\"item\">";
						c +="<img src=\"imagen?prod="+id_producto_trs.get(i)+"&place=4&i_tipo=1\" alt=\"...\"  style=\"width:175px;height:150px;border:0\" class=\"center-block\" class=\"img-thumbnail\">";
						c +="<div class=\"carousel-caption\"></div>";
						c +="<center><h6><font color=\"white\">"+cantidades.get(i)+" "+monedas.get(i)+"</font></h6></center></div>";
						c +="</div></div>";
						c +="<a class=\"left carousel-control\" href=\"#carrusel-"+i+"\" role=\"button\" data-slide=\"prev\">";
						c +="<span class=\"glyphicon glyphicon-chevron-left\"></span></a>";
						c +="<a class=\"right carousel-control\" href=\"#carrusel-"+i+"\" role=\"button\" data-slide=\"next\">";
						c +="<span class=\"glyphicon glyphicon-chevron-right\"></span></a><br>";
						c +="<center><h4><a href=\"descripcion.jsp?id="+id_producto_trs.get(0)+"\"><span class=\"label label-success\">";
						c +="SABER MÁS</span></a></h4></center></div>";
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
		} // fin switch

		
		try {
			rs.close();
			obj.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}


}

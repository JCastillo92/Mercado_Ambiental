package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;

import datos.ClsConexion;

public class Cls_General {
	
	String nombre;
	int log;
	int perfil;
	
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
		}

		
		//menu +="<p class=\"navbar-text\">Logueado como <%= usuariorec %></p>";
		if(t){
			/*
			menu += "<li><a href=\"puja.jsp\"><span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>Puja</a></li>";
			menu += "<li><a href=\"descripcion.jsp\"><span class=\"glyphicon glyphicon-tasks\" aria-hidden=\"true\"></span>Trueque</a></li>";
			menu += "<li><a href=\"Usuario_peronal.jsp\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>Mi Perfil</a></li>";*/
			menu += "<li><a href=\"cerrando\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span>Cerrar Sesion</a></li>";
		}else{
			
	      	menu +="<form class=\"navbar-form navbar-left\" role=\"search\" action=\"logueame\">"+
	      			"<div class=\"form-group\">"+
	      			"<input type=\"text\" class=\"form-control\" name=\"txtuser\" placeholder=\"Usuario\"></div>"+
	      			"<div class=\"form-group\">"+
	      			"<input type=\"password\" class=\"form-control\" name=\"txtpassword\" placeholder=\"Password\"></div>"+
	      			"<button type=\"submit\" class=\"btn btn-default\">Login</button></form>"+
	      			"<li><a href=\"registro.jsp\"><span class=\"glyphicon glyphicon-check\" aria-hidden=\"true\"></span>Registrar</a></li>";;
		}
		
		menu +="</ul></div></div></nav>";
		System.out.println(menu);
		return menu;		
	}
	
	public boolean ComprobarLoguin(String usuario, String clave){
		boolean t = false;
		System.out.println("Llego");
		ClsConexion obj = new ClsConexion();
		ResultSet rs=null;
		String sql,nombre2,login_us2,direccion2;int perfil2=0 ,cedula = 0;
		byte[] imgBytes3;
		sql = "Select * from tb_usuarios where id_usuario='"+usuario+"' and clave='"+clave+"'";
		try {
			rs = obj.Consulta(sql);
			while(rs.next()){
				
				login_us2= rs.getString(1);
				nombre2 = rs.getString(2);
				perfil2 = rs.getInt(8);
				setLog(perfil2);
				setPerfil(perfil2);
				setNombre(nombre2);
				t=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(t);
		System.out.println(sql);
		
		try {
			obj.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}


}

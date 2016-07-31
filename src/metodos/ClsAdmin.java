package metodos;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import datos.ClsConexion;

public class ClsAdmin {
	public boolean agregarmoneda(String descripcion){
		boolean t=false;
		datos.ClsConexion con = new datos.ClsConexion();
		String sql="insert into tb_monedas (descripcion) values ('"+descripcion.toUpperCase()+"');";
		try {
			con.Ejecutar(sql);
			t=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//nuevo codigo cerrar sesion
		try {
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	//******************************************************************************************************************************************
public String consulta_monedas(){
		String sql="select id_moneda, descripcion from tb_monedas;";
		ClsConexion con = new datos.ClsConexion();
		ResultSet rs=null;
		String acumulada="<table class=\"table table-striped\"> ";
		acumulada+=" <thead><tr><th>Descripci&oacute;n Moneda</th><th>Acci&oacute;n</th></tr></thead><tbody> ";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acumulada+="<tr><td>"+rs.getString(2)+"</td><td><a class=\"btn btn-danger\" href=\"Se_elimina_moneda?dato="+rs.getInt(1)+"\" role=\"button\">Eliminar</a></td></tr>";
			}
			acumulada+="</tbody></table>";
			}catch(Exception e){
			e.getMessage();	
			}
		//nuevo codigo cerrar sesion
				try {
					rs.close();
					con.getConexion().close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			return acumulada;
	}	

public boolean elimina_moneda(int id){
	boolean hh=false;
	String sentencia="delete from tb_monedas where id_moneda="+id;
	ClsConexion con = new datos.ClsConexion();
	try {
		
		con.Ejecutar(sentencia);
		hh=true;
		con.getConexion().close();
	} catch (Exception e) {
		e.getMessage();
	}
	//nuevo codigo cerrar sesion
	try {
		con.getConexion().close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return hh;
}
	//******************************************************************************************************************************************

	public String retorno_lista_add_remove(){
		//select nombre,apellido,correo,direccion,celular,id_usuario from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and tb_activos_usuarios.estado=FALSE and tb_activos_usuarios.bloqueado is null;
		String sql="select nombre,apellido,correo,direccion,celular,id_usuario from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and tb_activos_usuarios.estado=FALSE and tb_activos_usuarios.bloqueado is null;";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>NOMBRE</th><th>APELLIDO</th><th>CORREO</th><th>DIRECCI&Oacute;N</th><th>CELULAR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>"
						+ "<td><a class=\"btn btn-primary\" href=\"Sr_A_accept_user?dato="+rs.getString(6)+"\" role=\"button\">Aceptar</a></td>"
						+ "<td><a class=\"btn btn-danger\" href=\"Sr_A_deny_user?dato2="+rs.getString(6)+"\" role=\"button\">Eliminar</a></td></tr>";
			}
			acum_jsp+="</tbody></table>";
			}catch(Exception e){
				e.getMessage();
			}
		//nuevo codigo cerrar sesion
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return acum_jsp;
	}//fin lista add remove usuarios
	
public boolean accept_user(String recibo_dato_aceptar){
		boolean t=false;
		//update tb_activos_usuarios set estado='TRUE' where id_fk_usuario='12345';
		ClsConexion con=new ClsConexion();
		Cls_mailing mailto= new Cls_mailing();
		String sql="update tb_activos_usuarios set estado='TRUE' where id_fk_usuario='"+recibo_dato_aceptar+"';";
		try {
			con.Ejecutar(sql);
			t=true;
			mailto.deliver(1,recibo_dato_aceptar);
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		//nuevo codigo cerrar sesion
				try {
					con.getConexion().close();
				} catch (Exception e) {
					// TODO: handle exception
				}
		return t;
	}//fin public boolean accept_user
public boolean desbloquear_usuario(String recibo_dato_aceptar){
	boolean t=false;
	ClsConexion con=new ClsConexion();
	Cls_mailing mailto= new Cls_mailing();
	String sql="update tb_activos_usuarios set estado='TRUE',bloqueado=null where id_fk_usuario='"+recibo_dato_aceptar+"';";
	try {
		con.Ejecutar(sql);
		t=true;
		mailto.deliver(7,recibo_dato_aceptar);
	} catch (Exception e) {
		t=false;
		e.printStackTrace();
	}
	//nuevo codigo cerrar sesion
			try {
				con.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	return t;
}
	
	public boolean delete_user(String recibo_dato_eliminar){
		boolean t=false;
		//1) delete from tb_activos_usuarios where id_fk_usuario='1111';
		//2) delete from tb_usuarios where id_usuario='1111';
		ClsConexion con=new ClsConexion();
		Cls_mailing mailto= new Cls_mailing();
		String sql1="delete from tb_activos_usuarios where id_fk_usuario='"+recibo_dato_eliminar+"';";
		String sql2="delete from tb_usuarios where id_usuario='"+recibo_dato_eliminar+"';";
		try {
			mailto.deliver(2,recibo_dato_eliminar);
			con.Ejecutar(sql1);
			con.Ejecutar(sql2);
			t=true;
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		//nuevo codigo cerrar sesion
				try {
					con.getConexion().close();
				} catch (Exception e) {
					// TODO: handle exception
				}
		return t;
	}//fin public boolean deny_user
	public String control_usuarios(){
		//select id_usuario,nombre, apellido,correo, direccion,celular from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and estado=TRUE;
		String sql="select nombre,apellido,correo,direccion,celular,id_usuario from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and estado=TRUE;";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>NOMBRE</th><th>APELLIDO</th><th>CORREO</th><th>DIRECCION</th><th>CELULAR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>"
						+ "<td><a class=\"btn btn-warning\" href=\"Sr_A_control?dato="+rs.getString(6)+"\" role=\"button\">Bloquear</a></td>";
			}
			acum_jsp+="</tbody></table>";
			
			}catch(Exception e){
			e.getMessage();	
			}
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return acum_jsp;
	}//fin control_usuarios
	public String lista_usuarios_bloqueados(){
		//select nombre,apellido,correo,direccion,celular,id_usuario from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and estado=FALSE and bloqueado='b';
		String sql="select nombre,apellido,correo,direccion,celular,id_usuario from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and estado=FALSE and bloqueado='b';";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>NOMBRE</th><th>APELLIDO</th><th>CORREO</th><th>DIRECCION</th><th>CELULAR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>"
						+ "<td><a class=\"btn btn-success\" href=\"Sr_A_desbloquear_usuario?dato="+rs.getString(6)+"\" role=\"button\">Desbloquear / Habilitar</a></td>";
			}
			acum_jsp+="</tbody></table>";
			}catch(Exception e){
			e.getMessage();	
			}
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return acum_jsp;
	}//fin control_usuarios
	public boolean control_user(String id){
		boolean t=false;
		ClsConexion obj=new ClsConexion();
		Cls_mailing mailto= new Cls_mailing();
		//update  tb_activos_usuarios set estado='FALSE' where id_fk_usuario='1718900188';
		String sql1="update  tb_activos_usuarios set estado='FALSE',bloqueado='b' where id_fk_usuario='"+id+"';";
		try {
			obj.Ejecutar(sql1);
			mailto.deliver(3,id);
			t=true;
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		
		try {
			obj.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}//fin boolean control_user
	
	//******************************************************************************************************************************************
		public boolean agregarTrueque(String descripcion ,int cantidad,int moneda,String titulo,int categoria ,int estado ){
			Date date = new Date();
	        SimpleDateFormat fecha_sys = new SimpleDateFormat("yyyy-MM-dd");
			boolean t=false;
			ClsConexion obj = new ClsConexion();
			String sql="insert into tb_trueque (descripcion,cantidad,moneda,titulo,fk_categoria,estado,fecha_trueque) values ('"+descripcion+"',"+cantidad+","+moneda+",'"+titulo+"',"+categoria+",'"+estado+"','"+fecha_sys.format(date)+"');";
			System.out.println(sql);
			try {
				obj.Ejecutar(sql);
				t=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				obj.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return t;
		}
		
		//******************************************************************************************************************************************

		public String Moneda(){

			String moneda="<select class=form-control name=moneda>"
			+ "<option> </option>";
		  
			datos.ClsConexion obj = new datos.ClsConexion();
			ResultSet rs=null;
			
			String sql="Select descripcion from tb_monedas;";
			try{
			rs=obj.Consulta(sql);
			while(rs.next()){
			moneda+="<option>"+rs.getString(1)+"</option>";
			}
			
			}catch(Exception e){
				e.getMessage();
			}
			moneda+="</select>";
			
			try {
				rs.close();
				obj.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return moneda;
			}
		
		//*****************************************************************************************************+
		
		public int Moneda_id(String moneda){
			int id=0;
			datos.ClsConexion obj = new datos.ClsConexion();
			ResultSet rs=null;
			
			String sql="Select id_moneda from tb_monedas where descripcion="+"'"+moneda+"';";
			try{
			rs=obj.Consulta(sql);
			while(rs.next()){
			id=rs.getInt(1);
			}
			}catch(Exception e){
			e.getMessage();	
			}
			
			try {
				rs.close();
				obj.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return id;
			}
		
		//******************************************************
		
		public boolean agregarInformacion(String descripcion){
			boolean t=false;
			datos.ClsConexion obj = new datos.ClsConexion();
			//String sql="insert into tb_informacion (descripcion) values ('"+descripcion+"');";
			String sql="update tb_informacion set  descripcion='"+descripcion+"' where id_informacion='"+1+"';";
			try {
				obj.Ejecutar(sql);
				t=true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			try {
				obj.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return t;
		}
		
		public String devuelvo_Informacion(){
			String sql="Select descripcion from tb_informacion;";
			//String sql="update tb_informacion set  descripcion='"+descripcion+"' where id_informacion='"+1+"';";
			
			ClsConexion con =new ClsConexion();
			ResultSet rs=null;
			String codigo_jsp="";
			
			try{
				rs=con.Consulta(sql);
				
				while(rs.next()){
				codigo_jsp+=rs.getString(1);
				}
				}catch(Exception e){
				System.out.print(e.getMessage());	
				}
			
			try {
				rs.close();
				con.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return codigo_jsp;
		}
		
		public String Categoria(){

			String categoria="<select class=form-control name=categoria>"
			+ "<option> </option>";
		  
			datos.ClsConexion obj = new datos.ClsConexion();
			ResultSet rs=null;
			
			String sql="Select descripcion from tb_categorias order by descripcion asc;";
			try{
			rs=obj.Consulta(sql);
			while(rs.next()){
				categoria+="<option>"+rs.getString(1)+"</option>";
			}
			}catch(Exception e){
				e.getMessage();
			}
			categoria+="</select>";
			
			try {
				rs.close();
				obj.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return categoria;
			}
		
		//*****************************************************************************************************+
		
		public int Categoria_id(String categoria){
			int id=0;
			datos.ClsConexion obj = new datos.ClsConexion();
			ResultSet rs=null;
			
			String sql="Select id_cat from tb_categorias where descripcion="+"'"+categoria+"';";
			try{
			rs=obj.Consulta(sql);
			while(rs.next()){
			id=rs.getInt(1);
			}
			}catch(Exception e){
			e.getMessage();	
			}
			
			try {
				rs.close();
				obj.getConexion().close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return id;
			}
		
		//******************************************************
		
}//FIN TODO
package metodos;
import java.sql.ResultSet;

import datos.ClsConexion;
public class ClsUsuario {
	String cedula, nombre ,direccion,apellido,correo,clave;
	int telefono;
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}



	public boolean agregarusuario(String cedula,String nombre,String apellido,String correo ,String direccion,String telefono, String clave){
		boolean t=false;
		datos.ClsConexion obj = new datos.ClsConexion();
		String sql="INSERT INTO tb_usuarios (id_usuario,nombre,apellido,clave,correo,direccion,celular) values ('"+cedula+"','"+nombre.toUpperCase()+"','"+apellido.toUpperCase()+"','"+correo+"','"+direccion.toUpperCase()+"','"+telefono+"','"+clave+"');";
		System.out.println(sql);
		try {
			obj.Ejecutar(sql);
			t=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}
	
	public String devuelvo_para_actualizar(String ci){
		String sql="select direccion,celular from tb_usuarios where id_usuario='"+ci+"'";
		ClsConexion con =new ClsConexion();
		ResultSet rs=null;
		String codigo_jsp="";
		
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
			codigo_jsp+="<span class=\"input-group-addon\" id=\"basic-addon1\">Direcci�n Domiliciliaria: </span>"
					+ "  <input type=\"text\" class=\"form-control\" name=\"txtDireccion\" value=\""+rs.getString(1)+"\" aria-describedby=\"basic-addon1\" style=\"text-transform:uppercase\" required>"
							+ " <span class=\"input-group-addon\" id=\"basic-addon1\"> Tel�fono:</span>"
							+ "  <input type=\"number\" class=\"form-control\" name=\"txtTelefono\" pattern=\"[0-9]{7-10}\" value=\""+rs.getString(2)+"\" aria-describedby=\"basic-addon1\" required>";
			}
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return codigo_jsp;
	}
	public void actualuza_el_usuario(String dir,String tel, String p1,String ci){
		ClsConexion obj=new ClsConexion();
		String sql="update tb_usuarios set direccion='"+dir.toUpperCase()+"', celular='"+tel+"', clave='"+p1+"' where id_usuario='"+ci+"';";
		try {
			obj.Ejecutar(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//FIN VOID
	
public String consula_usuario_personal(String ci_usuario){
		
		String sql="select * from tb_usuarios where id_usuario='"+ci_usuario+"';";
		ClsConexion con =new ClsConexion();
		ResultSet rs=null;
		String codigo_jsp="";
		
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
			codigo_jsp+="<div class=\"col-md-6\"><h3><span class=\"label label-default\">Bienvenid@:</span></h3>"
			+ "<h2><span class=\"label label-info\">"+rs.getString(2)+"</span></h2></div><div class=\"col-md-6\"><h3><span class=\"label label-default\">Apellido:</span></h3>"
			+ "<h2><span class=\"label label-info\">"+rs.getString(3)+"</span></h2></div></div><div class=\"col-md-1\"></div></div><div class=\"row\"><div class=\"col-md-1\"></div>"
			+ "<div class=\"col-md-10\"><ul class=\"list-group\">"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(1)+"</span>Cedula</li>"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(5)+"</span>Correo</li>"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(6)+"</span>Domicilio</li>"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(7)+"</span>Telefono</li></ul>";
			}
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return codigo_jsp;
	}//fin public string consula_usuario_personal

	
}

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



	public boolean agregarusuario(String cedula,String nombre,String apellido,String clave ,String correo,String direccion, String telefono, int perfil){
		boolean t=false;
		datos.ClsConexion obj = new datos.ClsConexion();
		ClsAdmin delivery=new ClsAdmin();
		String sql="insert tb_usuarios (id_usuario,nombre,apellido,clave,correo,direccion,celular,perfil) values ('"+cedula+"','"+nombre.toUpperCase()+"','"+apellido.toUpperCase()+"','"+clave+"','"+correo+"','"+direccion.toUpperCase()+"','"+telefono+"',"+perfil+");";
		System.out.println(sql);
		try {
			obj.Ejecutar(sql);
			delivery.deliver(4,cedula);
			t=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public String devuelvo_para_actualizar(String cedula){
		String sql="select direccion,celular from tb_usuarios where id_usuario='"+cedula+"'";
		ClsConexion con =new ClsConexion();
		ResultSet rs=null;
		String codigo_jsp="";
		
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
			codigo_jsp+="<span class=\"input-group-addon\" id=\"basic-addon1\">Dirección Domiliciliaria: </span>"
					+ "  <input type=\"text\" class=\"form-control\" name=\"txtDireccion\" value=\""+rs.getString(1)+"\" aria-describedby=\"basic-addon1\" style=\"text-transform:uppercase\" required>"
							+ " <span class=\"input-group-addon\" id=\"basic-addon1\"> Teléfono:</span>"
							+ "  <input type=\"number\" class=\"form-control\" name=\"txtTelefono\" pattern=\"[0-9]{7-10}\" value=\""+rs.getString(2)+"\" aria-describedby=\"basic-addon1\" required>";
			}
			rs.close();
			con.getConexion().close();
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return codigo_jsp;
	}
	public void actualuza_el_usuario(String dir,String tel,String ci){
		ClsConexion obj=new ClsConexion();
		String sql="update tb_usuarios set direccion='"+dir.toUpperCase()+"', celular='"+tel+"'where id_usuario='"+ci+"';";
		try {
			obj.Ejecutar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//FIN VOID
	
	public void actualuza_clave( String p1,String ci){
		ClsConexion obj=new ClsConexion();
		String sql="update tb_usuarios set  clave='"+p1+"' where id_usuario='"+ci+"';";
		try {
			obj.Ejecutar(sql);
		} catch (Exception e) {
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
			+ "<h2><span class=\"label label-info\">"+rs.getString(3)+"</span></h2></div><div class=\"col-md-1\"></div><div class=\"row\"><div class=\"col-md-1\"></div>"
			+ "<div class=\"col-md-10\"><ul class=\"list-group\">"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(1)+"</span>C&eacute;dula</li>"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(5)+"</span>Correo electr&oacute;nico</li>"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(6)+"</span>Domicilio</li>"
			+ "<li class=\"list-group-item\"><span class=\"badge\">"+rs.getString(7)+"</span>Tel&eacute;fono</li></ul>"
					+ "</div></div>";
			}
			rs.close();
			con.getConexion().close();
			}catch(Exception e){
			System.out.print(e.getMessage());
			}
		return codigo_jsp;
	}//fin public string consula_usuario_personal

public String Clave(String ci_usuario){
	String clave="";
	ClsConexion con =new ClsConexion();
	ResultSet rs=null;
	String sql="Select clave from tb_usuarios where id_usuario='"+ci_usuario+"';";
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	clave=rs.getString(1);
	}
	rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	return clave;
	}
	
}

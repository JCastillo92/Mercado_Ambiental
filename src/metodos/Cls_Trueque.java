package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;

import datos.ClsConexion;

public class Cls_Trueque {
	
	String id_t;
	String descripcion_t;
	String cantidad_t;
	String moneda_t;
	String titulo_t;
	
	public String getId_t() {
		return id_t;
	}

	public void setId_t(String id_t) {
		this.id_t = id_t;
	}

	public String getDescripcion_t() {
		return descripcion_t;
	}

	public void setDescripcion_t(String descripcion_t) {
		this.descripcion_t = descripcion_t;
	}

	public String getCantidad_t() {
		return cantidad_t;
	}

	public void setCantidad_t(String cantidad_t) {
		this.cantidad_t = cantidad_t;
	}

	public String getMoneda_t() {
		return moneda_t;
	}

	public void setMoneda_t(String moneda_t) {
		this.moneda_t = moneda_t;
	}

	public String getTitulo_t() {
		return titulo_t;
	}

	public void setTitulo_t(String titulo_t) {
		this.titulo_t = titulo_t;
	}

	public String lista_trueques_por_confirmar_venta(){
		//select tb_trueque.titulo,tb_trueque.cantidad,tb_monedas.descripcion,tb_usuarios.nombre,tb_usuarios.apellido,tb_usuarios.correo,tb_usuarios.celular,tb_trueque.comprador from tb_trueque,tb_monedas,tb_usuarios where estado=2 and id_moneda=moneda and id_usuario=comprador;
		//estado=2 significa que en el trueque alguien (usuario x) puso comprar luego pasaria a un estado 3 que seria vendido totalmente.
		String sql="select tb_trueque.titulo,tb_trueque.cantidad,tb_monedas.descripcion,tb_usuarios.nombre,tb_usuarios.apellido,tb_usuarios.correo,tb_usuarios.celular,tb_trueque.comprador from tb_trueque,tb_monedas,tb_usuarios where estado=2 and id_moneda=moneda and id_usuario=comprador;";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>PRODUCTO</th><th>CANT.</th><th>DESCRIPCI&Oacute;N</th><th>COMPRADOR</th><th>E-MAIL</th><th>CELULAR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				//rs.getString(8) es la cedula DEL COMPRADOR (el que ya puso comprar pero aun no se realiza la venta)
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+" "+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td>"
						+ "<td><a class=\"btn btn-success\" href=\"Sr_T_confirma_venta?datoA="+rs.getString(8)+"&datoB="+rs.getString(1)+"\" role=\"button\">Vendido</a></td>"
						+ "<td><a class=\"btn btn-warning\" href=\"Sr_T_vuelve_venta?dato2="+rs.getString(8)+"&dato2B="+rs.getString(1)+"\" role=\"button\">No se ha vendido</a></td></tr>";
			}
			acum_jsp+="</tbody></table>";
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return acum_jsp;
	}//fin lista add remove usuarios
	
	public boolean confirma_venta_trueque(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//aqui debo pasar de estado 2 a 3
		//update tb_trueque set estado=3 where titulo='' and comprador='' and descripcion='';
		boolean t=false;
		ClsConexion con=new ClsConexion();
		String sql="update tb_trueque set estado=3 where titulo='"+titulo_producto_trueque+"' and comprador='"+cedula_comprador_prod_trueque+"';";
		try {
			con.Ejecutar(sql);
			t=true;
			ingresar_venta_en_tb_historico(titulo_producto_trueque,cedula_comprador_prod_trueque);
			eliminar_el_trueque_y_la_foto(titulo_producto_trueque,cedula_comprador_prod_trueque);
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		try {
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}//fin de confirmacion de venta del truque
	private void eliminar_el_trueque_y_la_foto(String titulo_producto_trueque,String cedula_comprador_prod_trueque){
		ClsConexion con = new datos.ClsConexion();
		int id_producto=0;
		ResultSet rs=null;
		String sentecnia1="select id_producto_tr from tb_trueque where titulo='"+titulo_producto_trueque+"' and comprador='"+cedula_comprador_prod_trueque+"' and estado=3;";
		try {
			rs=con.Consulta(sentecnia1);
			while(rs.next()){
				id_producto=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//sql delete from tb_trueque where titulo='hp envy dv4' and comprador='1719130476' and estado=3;
		String sentencia2="delete from tb_imagenes where id_producto_fk="+id_producto+";";
		String sentencia3="delete from tb_trueque where titulo='"+titulo_producto_trueque+"' and comprador='"+cedula_comprador_prod_trueque+"' and estado=3;";
		
		try {
			con.Ejecutar(sentencia2);
			con.Ejecutar(sentencia3);
		} catch (Exception e) {
			e.getMessage();
		}
		//nuevo codigo cerrar sesion
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void borrar_imagen_y_dato_en_caso_de_error_trueque(int saber_id_ingreso_trueque){
		ClsConexion con=new ClsConexion();
		String sql="delete from tb_imagenes where id_producto_fk="+saber_id_ingreso_trueque+";";
		String sql2="delete from tb_trueque where id_producto_tr="+saber_id_ingreso_trueque+";";
		try {
			con.Ejecutar(sql);
			con.Ejecutar(sql2);
		} catch (Exception e) {
			e.getMessage();
		}
		//nuevo codigo cerrar sesion
		try {
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public boolean venta_no_completada_trueque(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//regreso al producto al estado uno y elimino la cedula de quien lo queria comprar
		//update tb_trueque set estado=1, comprador=null where titulo='NOKIA LUMIA 820' and comprador='1704475084';
		boolean t=false;
		ClsConexion con=new ClsConexion();
		Cls_mailing mailto= new Cls_mailing();
		String sql="update tb_trueque set estado=1, comprador=null where titulo='"+titulo_producto_trueque+"' and comprador='"+cedula_comprador_prod_trueque+"';";
		try {
			con.Ejecutar(sql);
			//case 5 enviar un mensaje de que el interesado NO quiere concluir la venta
			mailto.deliver(5,cedula_comprador_prod_trueque);
			t=true;
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		try {
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}//fin venta_no_completada_trueque
	
	public Integer saber_id_nuevo_producto_trueque(String descripcion,int cantidad,int id_moneda,String titulo,int estado){
		int a=-1;
		int toma=0;
		//select id_producto_tr from tb_trueque where descripcion='algebra de baldor usada, todas las hojas en perfecto estado.' and cantidad=4 and moneda=3 and titulo='algebra baldor' and estado=1;
		String sql="select id_producto_tr from tb_trueque where descripcion='"+descripcion+"' and cantidad="+cantidad+" and moneda="+id_moneda+" and titulo='"+titulo+"' and estado="+estado+";";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
			toma=rs.getInt(1);
		}
		}catch(Exception e){
			a=-1;
			System.out.println(e.getMessage());
		}
		a=toma;
		//nuevo codigo cerrar sesion
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}
	
	public String lista_trueques_vendidos_historial(){
		String sql="select tb_historico.descripcion,tb_historico.cantidad,tb_monedas.descripcion,tb_categorias.descripcion,tb_historico.fecha,tb_usuarios.nombre "
				+ "from tb_historico,tb_monedas,tb_categorias,tb_usuarios "
				+ "where tb_historico.fk_moneda=tb_monedas.id_moneda "
				+ "and tb_historico.fk_categoria=tb_categorias.id_cat "
				+ "and tb_historico.fk_id_usuario=tb_usuarios.id_usuario"
				+ "and tb_historico.tipo=1 "
				+ "order by tb_historico.fecha;";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>PRODUCTO</th><th>Cant.</th><th>MONEDA</th><th>CATEGOR&Iacute;A</th><th>FECHA</th><th>COMPRADOR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td>"
						+ "<td><span class=\"badge\">Trueque</span></tr>";
			}
			acum_jsp+="</tbody></table>";
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return acum_jsp;
	}//fin saber_id_nuevo_producto_trueque
	
	public String lista_trueques_vendidos_puja(){
		String sql="select tb_historico.descripcion,tb_historico.cantidad,tb_monedas.descripcion,tb_categorias.descripcion,tb_historico.fecha,tb_usuarios.nombre "
				+ "from tb_historico,tb_monedas,tb_categorias,tb_usuarios "
				+ "where tb_historico.fk_moneda=tb_monedas.id_moneda "
				+ "and tb_historico.fk_categoria=tb_categorias.id_cat "
				+ "and tb_historico.fk_id_usuario=tb_usuarios.id_usuario"
				+ "and tb_historico.tipo=2 "
				+ "order by tb_historico.fecha;";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>PRODUCTO</th><th>Cant.</th><th>MONEDA</th><th>CATEGOR&Iacute;A</th><th>FECHA</th><th>COMPRADOR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td>"
						+ "<td><span class=\"badge\">Puja</span></tr>";
			}
			acum_jsp+="</tbody></table>";
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return acum_jsp;
	}//fin saber_id_nuevo_producto_puja
	private boolean ingresar_venta_en_tb_historico(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//sql select * from tb_trueque where comprador ='1719130476' and titulo='hp envy dv4';
		//sql2 insert into tb_historico (id_producto,descripcion,tipo,cantidad,fk_moneda,fk_categoria,fecha,fk_id_usuario) values (id_prducto,'titulo',1xdefault,cantidad,moneda,fk_categoria,'2016-07-16','1719130476');
		String sql2="",sql="select * from tb_trueque where comprador ='"+cedula_comprador_prod_trueque+"' and titulo='"+titulo_producto_trueque+"';";
		boolean t=false;
		ClsConexion con = new ClsConexion();
		Cls_mailing mailto= new Cls_mailing();
		ResultSet rs=null;
		String descripcion="",fecha="",fk_id_usuario="";
		int id_producto=0,tipo=1,cantidad=0,fk_moneda=0,fk_categoria=0;
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				id_producto=rs.getInt(1);
				cantidad=rs.getInt(3);
				fk_moneda=rs.getInt(4);
				descripcion=rs.getString(5);
				fk_categoria=rs.getInt(6);
				fk_id_usuario=rs.getString(8);
				fecha=rs.getString(9);
			}
			sql2="insert into tb_historico (id_producto,descripcion,tipo,cantidad,fk_moneda,fk_categoria,fecha,fk_id_usuario) "
					+ "values ("+id_producto+",'"+descripcion+"',"+tipo+","+cantidad+","+fk_moneda+","+fk_categoria+",'"+fecha+"','"+fk_id_usuario+"'); ";
			try {
				con.Ejecutar(sql2);
				//case 6 enviar un mensaje de que el interesado SI fue exitoso
				mailto.deliver(6,cedula_comprador_prod_trueque);
				t=true;
			}catch (Exception e) {
				t=false;
				e.printStackTrace();
			}
			}catch(Exception e){
				t=false;
			System.out.print(e.getMessage());	
			}
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	public String listar_trueques(){
		
		ClsConexion con=new ClsConexion();
		
		String lista_trueque="<div class=list-group>";
		ResultSet rs=null;
		String sql="select id_producto_tr, titulo from tb_trueque where estado=1;";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
			//href="imagenes_trueque.jsp?id=<%=id%>&lug=3
			lista_trueque+="<h3><a href=trueque.jsp?id="+rs.getString(1)+" class=list-group-item><span class=badge>"
				+ "<span class=glyphicon glyphicon glyphicon-education aria-hidden=true>"
				+ "</span></span>";
			lista_trueque+=rs.getString(2)+"</a></h3>";
		}
		
		}catch(Exception e){
		System.out.print(e.getMessage());	
		}
		lista_trueque+="</div>";
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lista_trueque;
	}
	
	public void detalles_trueque_especifico(String id){
		System.out.println("Detalles Trueque");
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String sql="select id_producto_tr, titulo, tb_trueque.descripcion, cantidad, tb_monedas.descripcion" 
				+" from tb_trueque, tb_monedas where" 
				+" moneda = id_moneda and"
				+" id_producto_tr="+id+" and"
				+" estado =1";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				setId_t(rs.getString(1));
				setTitulo_t(rs.getString(2));
				setDescripcion_t(rs.getString(3));
				setCantidad_t(rs.getString(4));
				setMoneda_t(rs.getString(5));
			}
		
		}catch(Exception e){
		}
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean trueque_usuario(String id, String cedula){
		boolean t =false;
		ClsConexion con=new ClsConexion();
		String sql="update tb_trueque set estado=2, comprador='"+cedula+"' where id_producto_tr="+id;
		try {
			con.Ejecutar(sql);
			t=true;
			
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		
		try {
			con.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public String id_untrueque(){
		String miid="";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String sql="select id_producto_tr from tb_trueque where estado = 1 order by id_producto_tr DESC limit 1 ";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				miid = rs.getString(1);
			}
		
		}catch(Exception e){
		}
		
		try {
			rs.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return miid;
	}
}

package metodos;

import java.sql.ResultSet;

import datos.ClsConexion;

public class Cls_Trueque {
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
			rs.close();
			con.getConexion().close();
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return acum_jsp;
	}//fin lista add remove usuarios
	public boolean confirma_venta_trueque(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//aqui debo pasar de estado 2 a 3
		//update tb_trueque set estado=3 where titulo='' and comprador='' and descripcion='';
		boolean t=false;
		Cls_mailing mailto= new Cls_mailing();
		ClsConexion obj=new ClsConexion();
		String sql="update tb_trueque set estado=3 where titulo='"+titulo_producto_trueque+"' and comprador='"+cedula_comprador_prod_trueque+"';";
		try {
			obj.Ejecutar(sql);
			
			//case 6 enviar un mensaje de que el interesado SI fue exitoso
			mailto.deliver(6,cedula_comprador_prod_trueque);
			t=true;
			t=ingresar_venta_en_tb_historico(titulo_producto_trueque,cedula_comprador_prod_trueque);
			obj.getConexion().close();
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		return t;
	}
	public boolean venta_no_completada_trueque(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//regreso al producto al estado uno y elimino la cedula de quien lo queria comprar
		//update tb_trueque set estado=1, comprador=null where titulo='NOKIA LUMIA 820' and comprador='1704475084';
		boolean t=false;
		ClsConexion obj=new ClsConexion();
		Cls_mailing mailto= new Cls_mailing();
		String sql="update tb_trueque set estado=1, comprador=null where titulo='"+titulo_producto_trueque+"' and comprador='"+cedula_comprador_prod_trueque+"';";
		try {
			obj.Ejecutar(sql);
			//case 5 enviar un mensaje de que el interesado NO quiere concluir la venta
			mailto.deliver(5,cedula_comprador_prod_trueque);
			t=true;
			obj.getConexion().close();
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
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
		return a;
	}
	public String lista_trueques_vendidos_historial(){
		String sql="";
		
		return sql;
	}//fin saber_id_nuevo_producto_trueque
	
	private boolean ingresar_venta_en_tb_historico(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//sql select * from tb_trueque where comprador ='1719130476' and titulo='hp envy dv4';
		//sql2 insert into tb_historico (id_producto,descripcion,tipo,cantidad,fk_moneda,fk_categoria,fecha,fk_id_usuario) values (id_prducto,'titulo',1xdefault,cantidad,moneda,fk_categoria,'2016-07-16','1719130476');
		String sql2="",sql="select * from tb_trueque where comprador ='"+cedula_comprador_prod_trueque+"' and titulo='"+titulo_producto_trueque+"';";
		boolean t=true;
		ClsConexion con = new datos.ClsConexion();
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
				t=true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs.close();
			con.getConexion().close();
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return t;
	}
}

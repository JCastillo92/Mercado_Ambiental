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
	public void confirma_venta_trueque(String titulo_producto_trueque, String cedula_comprador_prod_trueque){
		//aqui debo pasar de estado 2 a 3
		Cls_mailing mailto= new Cls_mailing();
		mailto.deliver(6,cedula_comprador_prod_trueque);
		
		
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
			//mailto.deliver(5,cedula_comprador_prod_trueque);
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
		///////////************************************
		String sql="select tb_trueque.titulo,tb_trueque.cantidad,tb_monedas.descripcion,tb_usuarios.nombre,tb_usuarios.apellido,tb_usuarios.correo,tb_usuarios.celular,tb_trueque.comprador from tb_trueque,tb_monedas,tb_usuarios where estado=2 and id_moneda=moneda and id_usuario=comprador;";
		
		return sql;
	}
}

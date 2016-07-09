package metodos;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datos.ClsConexion;

public class ClsImagen {
	
	byte[] imgBytes2;
	int tipo,producto,contador;
	ClsConexion obj = new ClsConexion();
	
	public int getContador() {
		return contador;
	}
	
	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public byte[] getImgBytes2() {
		return imgBytes2;
	}

	public void setImgBytes2(byte[] imgBytes2) {
		this.imgBytes2 = imgBytes2;
	}
	public boolean insertarimagen(String path){
		System.out.println("Ya Entro "+path);
		boolean t = false;
		//ClsConexion obj = new ClsConexion();
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			//PreparedStatement ps = obj.getConexion().prepareStatement("insert into tb_usuario (nombre_im,img) values (?,?) where id_us="+cedula);
			//insert into tb_imagenes ("id_producto_fk,tipo,nombre_img,imagen_bit) values(?,?,?,?)"
			String nombrearchivo = file.getName();
			nombrearchivo = nombrearchivo.substring(nombrearchivo.length() -4, nombrearchivo.length());
			if (nombrearchivo.equals(".jpg")){
				PreparedStatement ps = obj.getConexion().prepareStatement("insert into tb_imagenes (id_producto_fk,tipo,nombre_img,imagen_bit) values(?,?,?,?)" );
				//PreparedStatement ps = obj.getConexion().prepareStatement("update tb_usuario set nombre_im = ?, img = ?" );
				ps.setInt(1, 6);
				ps.setInt(2, 1);
				ps.setString(3, file.getName());
				ps.setBinaryStream(4, fis, (int)file.length());
				System.out.println(ps);
				ps.executeUpdate();
				ps.close();
				fis.close();
				t = true;
			}else{
				fis.close();
				System.out.println("archivo incorrecto");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}
	////////////////////////////////jairo insertar imagenes trueque////////////////
	public Integer saber_id_nuevo_producto_trueque(){
		int a=-1;
		int toma=0;
		//sql=select id_producto_tr from tb_trueque order by id_producto_tr desc limit 1;
		String sql="select id_producto_tr from tb_trueque order by id_producto_tr desc limit 1;";
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
	public void falla_ingreso_imagenes_trueque(){
		//id que ingrese las imagenes pero no se cargaron todas
		String sentencia="delete from tb_imagenes where id_producto_fk="+saber_id_nuevo_producto_trueque();
		try {
			ClsConexion con = new datos.ClsConexion();
			con.Ejecutar(sentencia);
		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	

	
//*******************************************************************************************************
	public boolean insertarimagen_puja(String path, int id){
	
			//System.out.println("Ya Entro "+path);
			boolean t = false;
			//ClsConexion obj = new ClsConexion();
			try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			//PreparedStatement ps = obj.getConexion().prepareStatement("insert into tb_usuario (nombre_im,img) values (?,?) where id_us="+cedula);
			//insert into tb_imagenes ("id_producto_fk,tipo,nombre_img,imagen_bit) values(?,?,?,?)"
			String nombrearchivo = file.getName();
			nombrearchivo = nombrearchivo.substring(nombrearchivo.length() -4, nombrearchivo.length());
			if (nombrearchivo.equals(".jpg")){
			PreparedStatement ps = obj.getConexion().prepareStatement("insert into tb_imagenes (id_producto_fk,tipo,nombre_img,imagen_bit) values(?,?,?,?)" );
			//PreparedStatement ps = obj.getConexion().prepareStatement("update tb_usuario set nombre_im = ?, img = ?" );
			ps.setInt(1, id);
			ps.setInt(2, 2);
			ps.setString(3, file.getName());
			ps.setBinaryStream(4, fis, (int)file.length());
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			fis.close();
			t = true;
			}else{
			fis.close();
			System.out.println("archivo incorrecto");
			}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return t;
		}
	
//*******************************************************************************************************
	public boolean insertarimagen_trueque(String path){
		boolean t = false;
		try {
			File file = new File(path);
			//System.out.println("Ya Entro "+path);
			FileInputStream fis = new FileInputStream(file);
			String nombrearchivo = file.getName();
			System.out.println("---------------"+nombrearchivo);
			nombrearchivo = nombrearchivo.substring(nombrearchivo.length() -4, nombrearchivo.length());
			if (nombrearchivo.equals(".jpg") && (saber_id_nuevo_producto_trueque()>0)){
				PreparedStatement ps = obj.getConexion().prepareStatement("insert into tb_imagenes (id_producto_fk,tipo,nombre_img,imagen_bit) values(?,?,?,?)" );
				ps.setInt(1, saber_id_nuevo_producto_trueque());//id_producto_tr
				System.out.println(".................."+saber_id_nuevo_producto_trueque());
				ps.setInt(2, 1);//tipo trueque=1 puja=2
				ps.setString(3, file.getName());
				ps.setBinaryStream(4, fis, (int)file.length());
				System.out.println(ps);
				//if a=a(){
				ps.executeUpdate();
				ps.close();
				fis.close();
				t = true;
			}else{
				t=false;
				fis.close();
				System.out.println("archivo incorrecto o saber_id_nuevo_producto es <1");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			t=false;
			e.printStackTrace();
		}
		return t;
	}
	
	//*******************************************************************************************************

	public boolean recuperarimagen(String prod, String place){
		boolean t=false;
		int cuentame=0;
		System.out.println("Llego");
		//ClsConexion obj = new ClsConexion();
		ResultSet rs=null;
		String sql,nombre2,login_us2,direccion2;int tipo=-1 ,producto = -1;
		
		byte[] imgBytes3;
		//sql = "Select * from tb_imagenes where id_imagenes=1";
		sql = "Select * from tb_imagenes where id_producto_fk="+prod;
		
		try {
			rs = obj.Consulta(sql);
			while(rs.next()){
				cuentame++;
				if (cuentame == Integer.parseInt(place)) {
					tipo = rs.getInt(2);
					producto = rs.getInt(3);
					imgBytes3 = rs.getBytes(5);
					setTipo(tipo);
					setProducto(producto);
					setImgBytes2(imgBytes3);
					System.out.println(imgBytes3);
					t=true;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(t);
		System.out.println(sql);
		
		return t;
	}
	
	public void contador(String prod){
		System.out.println("Producto "+prod);
		System.out.println("Entro a contador");
		//ClsConexion obj = new ClsConexion();
		ResultSet rs=null;
		String sql,nombre2,login_us2,direccion2;int tipo=-1 ,producto = -1;
		contador=0;
		byte[] imgBytes3;
		sql = "Select * from tb_imagenes where id_producto_fk="+prod;
		System.out.println(sql);
		try {
			rs = obj.Consulta(sql);
			while(rs.next()){
				contador++;
			}
			setContador(contador);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sql+" contador "+contador);
		
	}

}

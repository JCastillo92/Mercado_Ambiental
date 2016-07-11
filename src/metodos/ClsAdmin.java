package metodos;

import java.sql.ResultSet;

import datos.ClsConexion;
//para enviar emails aqui abajo
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.*;
import java.util.*;
public class ClsAdmin {
	public boolean agregarmoneda(String descripcion){
		boolean t=false;
		datos.ClsConexion obj = new datos.ClsConexion();
		String sql="INSERT INTO tb_monedas (descripcion) values ('"+descripcion.toUpperCase()+"');";
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
	//******************************************************************************************************************************************
public String consulta_monedas(){
		String sql="select id_moneda, descripcion from tb_monedas;";
		ClsConexion con = new datos.ClsConexion();
		ResultSet rs=null;
		String acumulada="<table class=\"table table-striped\"> ";
		acumulada+=" <thead><tr><th>Descripción Moneda</th><th>Acción</th></tr></thead><tbody> ";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acumulada+="<tr><td>"+rs.getString(2)+"</td><td><a class=\"btn btn-primary\" href=\"Se_elimina_moneda?dato="+rs.getInt(1)+"\" role=\"button\">Eliminar</a></td></tr>";
}
			acumulada+="</tbody></table>";
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
			return acumulada;
	}	

public boolean elimina_moneda(int id){
	boolean hh=false;
	String sentencia="delete from tb_monedas where id_moneda="+id;
	try {
		ClsConexion con = new datos.ClsConexion();
		con.Ejecutar(sentencia);
		hh=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
	return hh;
}
	//******************************************************************************************************************************************

	public String retorno_lista_add_remove(){
		//select id_usuario,nombre, apellido,correo, direccion,celular from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and estado=FALSE;
		String sql="select nombre,apellido,correo,direccion,celular,id_usuario from tb_usuarios,tb_activos_usuarios where id_usuario=id_fk_usuario and estado=FALSE;";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>NOMBRE</th><th>APELLIDO</th><th>CORREO</th><th>DIRECCION</th><th>CELULAR</th></tr></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>"
						+ "<td><a class=\"btn btn-primary\" href=\"Sr_A_accept_user?dato="+rs.getString(6)+"\" role=\"button\">Aceptar</a></td>"
						+ "<td><a class=\"btn btn-primary\" href=\"Sr_A_deny_user?dato2="+rs.getString(6)+"\" role=\"button\">Eliminar</a></td></tr>";
			}
			acum_jsp+="</tbody></table>";
			rs.close();
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return acum_jsp;
	}//fin lista add remove usuarios
	
public boolean accept_user(String recibo_dato_aceptar){
		
		boolean t=false;
		//update tb_activos_usuarios set estado='TRUE' where id_fk_usuario='12345';
		ClsConexion obj=new ClsConexion();
		String sql="update tb_activos_usuarios set estado='TRUE' where id_fk_usuario='"+recibo_dato_aceptar+"';";
		try {
			obj.Ejecutar(sql);
			t=true;
			deliver(1,recibo_dato_aceptar);
		} catch (Exception e) {
			t=false;
			e.printStackTrace();
		}
		return t;
	}//fin public boolean accept_user
////////////////////////////////////
	public void deliver(int CodOperation,String IdentificationResponse){
		String ValueToFind="select * from tb_usuarios where id_usuario='"+IdentificationResponse+"';";
		String GetRecipientDestination=null,GetRecipientNick=null,LibraryPredeterminated=null;
		ClsConexion con=new ClsConexion();ResultSet resultSet=null;
		try{
			resultSet=con.Consulta(ValueToFind);
			while(resultSet.next()){
				GetRecipientNick=resultSet.getString(2);
				GetRecipientDestination=resultSet.getString(5);
			}
			resultSet.close();
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		switch (CodOperation) {
		case 1://accept
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Luego de haber confirmado tus datos "
					+ "te damos la más cordial bievenida a nuestro portal de intercambio, usamos dos "
					+ "tipos de modalidad que son trueque y puja, en las cuales tendrás varias opciones "
					+ "de productos a seleccionar y por medio de la página podras saber más del mismo.\n\n\n\n "
					+ "Las transacciones se las realizará en las instalaciones de la Universidad Politécnica Salesiana, "
					+ "en las instalaciones que posee el Club Ecológico UPS.\n\n\n";
			break;
		case 2://deny
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Luego de haber revisado tus datos, "
					+ "hemos encontrado algunas inconsistencias en los mismos.\n\n Necesitamos que seas "
					+ "estudiante de la Universidad Politécnica Salesiana y por ende que te registres con " 
					+ "tu cuenta de estudiante o docente. Los datos adicionales deben ser correctos y coherentes "
					+ "para que te podamos identificar.\n\n\n\n\n Si tienes algun problema y tus datos son "
					+ "correctos y aún no te hemos enviando un mensaje de confirmación, acercate a nuestras "
					+ "instalaciones del Club Ecológico UPS, para ayudarte en tus requerimientos.\n\n"
					+ "Hasta Pronto";
			break;
		case 3://block
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Hemos detectado actividad inusual en el "
					+ "manejo de tu cuenta, por lo que hemos procedido a inactivarla momentaneamente, "
					+ "necesitamos que te acerques a nuestras instalaciones del Club Ecológico UPS para activar tu "
					+ "cuenta, lamentamos los inconvenientes que esto te pueda causar.\n\n\nTe esperamos, hasta pronto.";
			break;
		case 4://registered welcome
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Gracias por registrarte en nuestro portal "
					+ "TRUEQUE ECOLÓGICO, necesitamos validar tus datos, por el momento no podrás acceder al portal. "
					+ "\nDentro de las siguientes 24hrs recibirás un mensaje de confirmación "
					+ "y podrás empezar a utilizar la página.\n\n\n Tu solicitud se está siendo procesada adiós.";
			break;
		default:
			
			break;
		}//fin switch
		String username = "clubecologicoups@gmail.com";
	    String password = "est.ups.edu.ec";
	    try {
	        Properties props = System.getProperties();
	        props.setProperty("mail.transport.protocol", "smtp");
	        props.setProperty("mail.host", "smtp.gmail.com");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");
	 
	        Session emailSession = Session.getInstance(props,new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("clubecologicoups@gmail.com","est.ups.edu.ec");
	        }});
	 
	        emailSession.setDebug(true);
	        Message message = new MimeMessage(emailSession);
	        message.setFrom(new InternetAddress("clubecologicoups@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(GetRecipientDestination));
	        message.setSubject("clubEcológicoUps mensaje automático");
	        message.setText(LibraryPredeterminated);
	 
	        Transport transport = emailSession.getTransport("smtps");
	        transport.connect("smtp.gmail.com", username, password);
	        transport.sendMessage(message, message.getAllRecipients());
	       } catch (MessagingException e) {
	    	   System.out.println(e.getMessage());
	       }
	}
	
////////////////////////////////////
	public boolean delete_user(String recibo_dato_eliminar){
		boolean t=false;
		//1) delete from tb_activos_usuarios where id_fk_usuario='1111';
		//2) delete from tb_usuarios where id_usuario='1111';
		ClsConexion obj=new ClsConexion();
		String sql1="delete from tb_activos_usuarios where id_fk_usuario='"+recibo_dato_eliminar+"';";
		String sql2="delete from tb_usuarios where id_usuario='"+recibo_dato_eliminar+"';";
		try {
			deliver(2,recibo_dato_eliminar);
			obj.Ejecutar(sql1);
			obj.Ejecutar(sql2);
			t=true;
		} catch (Exception e) {
			t=false;
			// TODO: handle exception
			e.printStackTrace();
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
						+ "<td><a class=\"btn btn-primary\" href=\"Sr_A_control?dato="+rs.getString(6)+"\" role=\"button\">Bloquear</a></td>";
			}
			acum_jsp+="</tbody></table>";
			rs.close();
			}catch(Exception e){
			System.out.print(e.getMessage());	
			}
		return acum_jsp;
	}//fin control_usuarios
	public boolean control_user(String id){
		boolean t=false;
		ClsConexion obj=new ClsConexion();
		//update  tb_activos_usuarios set estado='FALSE' where id_fk_usuario='1718900188';
		String sql1="update  tb_activos_usuarios set estado='FALSE' where id_fk_usuario='"+id+"';";
		try {
			obj.Ejecutar(sql1);
			deliver(3,id);
			t=true;
		} catch (Exception e) {
			t=false;
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return t;
	}//fin boolean control_user
	
	//******************************************************************************************************************************************
		public boolean agregarTrueque(String descripcion ,int cantidad,int moneda,String titulo ,int estado ){
			boolean t=false;
			datos.ClsConexion obj = new datos.ClsConexion();
			String sql="INSERT INTO tb_trueque (descripcion,cantidad,moneda,titulo,estado) values ('"+descripcion+"',"+cantidad+","+moneda+",'"+titulo+"','"+estado+"');";
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
		
		//******************************************************************************************************************************************

		public String Moneda(){

			String moneda="<select class=form-control name=moneda>"
			+ "<option> </option>";
		  
			datos.ClsConexion obj = new datos.ClsConexion();
			ResultSet rs=null;
			
			String sql="Select descripcion from tb_monedas;";
			System.out.println(sql);
			try{
			rs=obj.Consulta(sql);
			while(rs.next()){
			moneda+="<option>"+rs.getString(1)+"</option>";
			
			}
			
			}
			catch(Exception e){
			System.out.print(e.getMessage());	
			}
			moneda+="</select>";
				
			return moneda;
			}
		
		//*****************************************************************************************************+
		
		public int Moneda_id(String moneda){
			  
			int id=0;
			datos.ClsConexion obj = new datos.ClsConexion();

			
			ResultSet rs=null;
			
			String sql="Select id_moneda from tb_monedas where descripcion="+"'"+moneda+"';";
			System.out.println(sql);
			try{
			rs=obj.Consulta(sql);
			while(rs.next()){
			id=rs.getInt(1);
			}
			
			}
			catch(Exception e){
			System.out.print(e.getMessage());	
			}
				
			return id;
			}
			
		
		
}//FIN TODO
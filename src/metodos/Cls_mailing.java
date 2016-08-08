package metodos;
import javax.mail.internet.*;
import datos.ClsConexion;
import javax.mail.*;
import java.sql.ResultSet;
import java.util.*;
public class Cls_mailing {
	public void deliver(int CodOperation,String IdentificationResponse){
		String ValueToFind="select * from tb_usuarios where id_usuario='"+IdentificationResponse+"';";
		String GetRecipientDestination=null,GetRecipientNick=null,LibraryPredeterminated=null;
		String username = "clubecologicoups@gmail.com";
	    String password = "est.ups.edu.ec";
		ClsConexion con=new ClsConexion();
		ResultSet resultSet=null;
		try{
			resultSet=con.Consulta(ValueToFind);
			while(resultSet.next()){
				GetRecipientNick=resultSet.getString(2);
				GetRecipientDestination=resultSet.getString(5);
			}
			}catch(Exception e){
			e.getMessage();	
			}
		
		try {
	    	resultSet.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		switch (CodOperation) {
		case 1://accept the request of user, he is already registered
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Luego de haber confirmado tus datos "
					+ "te damos la m�s cordial bievenida a nuestro portal de intercambio, usamos dos "
					+ "tipos de modalidad que son trueque y puja, en las cuales tendr�s varias opciones "
					+ "de productos a seleccionar y por medio de la p�gina podras saber m�s del mismo.\n\n\n\n "
					+ "Las transacciones se las realizar� en las instalaciones de la Universidad Polit�cnica Salesiana, "
					+ "en las instalaciones que posee el Club Ecol�gico UPS.\n\n\n";
			break;
		case 2://deny user
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Luego de haber revisado tus datos, "
					+ "hemos encontrado algunas inconsistencias en los mismos.\n\n Necesitamos que seas "
					+ "estudiante de la Universidad Polit�cnica Salesiana y por ende que te registres con " 
					+ "tu cuenta de estudiante o docente. Los datos adicionales deben ser correctos y coherentes "
					+ "para que te podamos identificar.\n\n\n\n\n Si tienes algun problema y tus datos son "
					+ "correctos y a�n no te hemos enviando un mensaje de confirmaci�n, acercate a nuestras "
					+ "instalaciones del Club Ecol�gico UPS, para ayudarte en tus requerimientos.\n\n"
					+ "Hasta Pronto";
			break;
		case 3://block
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Hemos detectado actividad inusual en el "
					+ "manejo de tu cuenta, por lo que hemos procedido a inactivarla momentaneamente, "
					+ "necesitamos que te acerques a nuestras instalaciones del Club Ecol�gico UPS para activar tu "
					+ "cuenta, lamentamos los inconvenientes que esto te pueda causar.\n\n\nTe esperamos, hasta pronto.";
			break;
		case 4://new user registered welcome
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n Gr�cias por registrarte en nuestro portal "
					+ "TRUEQUE ECOL�GICO, necesitamos validar tus datos, por el momento no podr�s acceder al portal. "
					+ "\nDentro de las siguientes 24hrs recibir�s un mensaje de confirmaci�n "
					+ "y podr�s empezar a utilizar la p�gina.\n\n\n Tu solicitud se est� siendo procesada adi�s.";
			break;
		case 5://buyer does not bought the product
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n TRUEQUE ECOL�GICO te saluda.\n Hemos revisado en el sistema "
					+ "que el trueque por el cual t� optaste, a�n no se ha podido finiquitar. "
					+ "\nDebido a este hemos republicado el anuncio en el sistema,  "
					+ "puedes volverlo a comprar si en verdad est�s interesado.\n "
					+ "Gr�cias por tu compreni�n, hasta pronto.";
			break;
		case 6://product succesfully sold
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n TRUEQUE ECOL�GICO te saluda.\n Queremos agradecerte por "
					+ "ayudar al medio ambiente recolectando cosas reciclables. "
					+ "\nGr�cias por tu intercambio, sigue revisando nuestra p�gina, tenemos muchos art�culos  "
					+ "que te pueden interesar.\n "
					+ "Hasta pronto.";
			break;
		case 7://user unlcoked, not blocked, now he is already active
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n TRUEQUE ECOL�GICO te saluda.\n Queremos informarte "
					+ "que te hemos habilitado en la plataforma, esperamos que manejes la plataforma de la manera "
					+ "m�s adecuada. \nCuaquier duda nos puedes contactar via Facebook, de forma presencial en la U.P.S. campus Sur.\n"
					+ "Hasta pronto.";
			break;
		case 8://user push on PUJA
			LibraryPredeterminated="\nHola, "+GetRecipientNick+".\n TRUEQUE ECOL�GICO te saluda.\n Queremos informarte "
					+ "que hemos registrado los datos de tu subasta, recuerda que existe un tiempo limite para "
					+ "cada subasta. Gracias por aumentar la cantidad.\n "
					+ "Una vez terminada la subasta te llamar�mos en caso de que seas el ganador.\n "
					+ "Hasta pronto.";
			break;
		default:
			
			break;
		}//fin switch
		
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
	        message.setSubject("ClubEcol�gicoUps mensaje autom�tico");
	        message.setText(LibraryPredeterminated);
	 
	        Transport transport = emailSession.getTransport("smtps");
	        transport.connect("smtp.gmail.com", username, password);
	        transport.sendMessage(message, message.getAllRecipients());
	       } catch (MessagingException e) {
	    	  e.getMessage();
	       }
	    
	    
	}//fin clase DELIVER
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void auto_mail_to_CEUPS(int CodOperation){
		String LibraryPredeterminated=null;
		String username = "clubecologicoups@gmail.com";
	    String password = "est.ups.edu.ec";
		
		switch (CodOperation) {
		case 1://a client clicked on COMPRAR TRUEQUE
			LibraryPredeterminated="\nHola, ADMIN.\n Tenemos notificaci�nes "
					+ "de un usuario que est� interesado en un art�culo\n "
					+ "para el TRUEQUE, ingresa a la plataforma a revisar las novedades.";
			break;
		case 2://a client clicked on PUJAR
			LibraryPredeterminated="\nHola, ADMIN.\n Tenemos notificaci�nes "
					+ "de un usuario que est� interesado en un art�culo\n "
					+ "para la PUJA, ingresa a la plataforma a revisar las novedades.";
			break;
		default:
			break;
		}//fin switch
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
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(username));
	        message.setSubject("ClubEcol�gicoUps plataforma");
	        message.setText(LibraryPredeterminated);
	 
	        Transport transport = emailSession.getTransport("smtps");
	        transport.connect("smtp.gmail.com", username, password);
	        transport.sendMessage(message, message.getAllRecipients());
	       } catch (MessagingException e) {
	    	   e.getMessage();
	       }
	}//fin clase DELIVER
}//FIN TODO
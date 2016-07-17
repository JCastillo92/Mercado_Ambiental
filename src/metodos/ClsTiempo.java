package metodos;

import java.sql.ResultSet;

import datos.ClsConexion;

public class ClsTiempo {

	ClsConexion con=new ClsConexion();

//***************************************************************************************
	public String Dia(String id){
	
	String dato="";
	
	ResultSet rs=null;
	
	String sql="Select dia from tb_tiempo where id_puja="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	dato=rs.getString(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	//System.out.println("-------------------1--------------"+dato);
	return dato;
	}
//***************************************************************************************
	public String Mes(String id){
		
	String dato="";
	
	ResultSet rs=null;
	
	String sql="Select mes from tb_tiempo where id_puja="+id+";";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	dato=rs.getString(1);
	
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	System.out.println("-------------------2--------------"+dato);
	
	return dato;
	}
	
//***************************************************************************************
	public String año(String id){
		
	String dato="";
	
	ResultSet rs=null;
	
	String sql="Select año from tb_tiempo where id_puja="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	dato=rs.getString(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	//System.out.println("-------------------3--------------"+dato);
	return dato;
	}
	
//***************************************************************************************
	public String hora(String id){
		
	String dato="";
	
	ResultSet rs=null;
	
	String sql="Select hora from tb_tiempo where id_puja="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	dato=rs.getString(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	//System.out.println("-------------------4--------------"+dato);
	return dato;
}
//***************************************************************************************
	public String minutos(String id){
		
	String dato="";
	
	ResultSet rs=null;
	
	String sql="Select minutos from tb_tiempo where id_puja="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	dato=rs.getString(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	//System.out.println("-------------------5--------------"+dato);
	return dato;
}
//***************************************************************************************
	public String mn(String id){
		
	String dato="";
	
	ResultSet rs=null;
	
	String sql="Select mn from tb_tiempo where id_puja="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	dato=rs.getString(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	//System.out.println("-------------------6--------------"+dato);
	return dato;
	}

	
}

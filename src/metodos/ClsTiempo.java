package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;

import datos.ClsConexion;

public class ClsTiempo {

	

//***************************************************************************************
	public String Dia(String id){
	ClsConexion con=new ClsConexion();
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
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	//System.out.println("-------------------1--------------"+dato);
	return dato;
	}
//***************************************************************************************
	public String Mes(String id){
	ClsConexion con=new ClsConexion();
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
	//System.out.println("-------------------2--------------"+dato);
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return dato;
	}
	
//***************************************************************************************
	public String año(String id){
	ClsConexion con=new ClsConexion();
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
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	//System.out.println("-------------------3--------------"+dato);
	return dato;
	}
	
//***************************************************************************************
	public String hora(String id){
	ClsConexion con=new ClsConexion();
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
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	//System.out.println("-------------------4--------------"+dato);
	return dato;
}
//***************************************************************************************
	public String minutos(String id){
	ClsConexion con=new ClsConexion();
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
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	//System.out.println("-------------------5--------------"+dato);
	return dato;
}
//***************************************************************************************
	public String mn(String id){
	ClsConexion con=new ClsConexion();
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
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	//System.out.println("-------------------6--------------"+dato);
	return dato;
	}

	
}

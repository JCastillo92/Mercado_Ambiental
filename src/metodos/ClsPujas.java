package metodos;

import java.sql.ResultSet;

import datos.ClsConexion;

public class ClsPujas {

	
	public String Ver_Pujas(){
	String pujas="<div class=list-group>";
	System.out.println(pujas);
	
	ClsConexion con=new ClsConexion();
	ResultSet rs=null;
	
	String sql="Select id_prod_pj, titulo from tb_pujas where estado='true';";
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	pujas+="<h3><a href=puja.jsp?id="+rs.getString(1)+" class=list-group-item><span class=badge>"
			+ "<span class=glyphicon glyphicon glyphicon-education aria-hidden=true>"
			+ "</span></span>";
	pujas+=rs.getString(2)+"</a></h3>";
	System.out.println(rs.getString(2));
	//System.out.println(pujas);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	pujas+="</div>";
		
	return pujas;
	}
	
	
	
	
	
	public String Descripcion(String id){
	String descripcion="";
		
	ClsConexion con=new ClsConexion();
	ResultSet rs=null;
	
	String sql="Select descripcion from tb_pujas where id_prod_pj="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	descripcion=rs.getString(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}

		
	return descripcion;
	}
	
	
	public String Moneda(String id){
		String descripcion="";
			
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		
		String sql="Select tb_monedas.descripcion from tb_pujas, tb_monedas where moneda=id_moneda and "
		+ "id_prod_pj="+id+";";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		descripcion=rs.getString(1);
		}
		
		}
		catch(Exception e){
		System.out.print(e.getMessage());	
		}

			
		return descripcion;
		}
	
	
	public String Valor(String id){
		String descripcion="";
			
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		
		String sql="Select valor_minimo from tb_pujas where id_prod_pj="+id+";";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		descripcion=rs.getString(1);
		}
		
		}
		catch(Exception e){
		System.out.print(e.getMessage());	
		}

			
		return descripcion;
		}
	
}

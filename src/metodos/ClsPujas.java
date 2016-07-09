package metodos;

import java.sql.ResultSet;

import datos.ClsConexion;

public class ClsPujas {

	ClsConexion con=new ClsConexion();
	
	public String Ver_Pujas(){
	String pujas="<div class=list-group>";
	//System.out.println(pujas);
	

	ResultSet rs=null;
	
	String sql="Select id_prod_pj, titulo from tb_pujas where estado=1;";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	pujas+="<h3><a href=puja.jsp?id="+rs.getString(1)+" class=list-group-item><span class=badge>"
			+ "<span class=glyphicon glyphicon glyphicon-education aria-hidden=true>"
			+ "</span></span>";
	pujas+=rs.getString(2)+"</a></h3>";
	//System.out.println(rs.getString(2));
	//System.out.println(pujas);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	pujas+="</div>";
		
	return pujas;
	}
	
	
	
	//********************************************************************************************************
	
	
	public String Descripcion(String id){
	String descripcion="";
		

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

	ResultSet rs=null;
	
	String sql="Select tb_monedas.descripcion from tb_pujas, tb_monedas where moneda=id_moneda and "
	+ "id_prod_pj="+id+";";
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
	
	
	public String Valor(String id){
	String descripcion="";
		

	ResultSet rs=null;
	
	String sql="Select valor_minimo from tb_pujas where id_prod_pj="+id+";";
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
	
	
	
//********************************************************************************************************

	public String Moneda(){
	String moneda="<select class=form-control name=moneda>"
	+ "<option> </option>";
  

	ResultSet rs=null;
	
	String sql="Select descripcion from tb_monedas;";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	moneda+="<option>"+rs.getString(1)+"</option>";
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	moneda+="</select required>";
		
	return moneda;
	}
//********************************************************************************************************
	public String cmbCategorias(){
		String moneda="<select class=form-control name=categorias>"
		+ "<option> </option>";
	  

		ResultSet rs=null;
		
		String sql="Select descripcion from tb_categorias;";
		//System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		moneda+="<option>"+rs.getString(1)+"</option>";
		}
		
		}
		catch(Exception e){
		System.out.print(e.getMessage());	
		}
		moneda+="</select required>";
			
		return moneda;
		}
	
//********************************************************************************************************
	public int Moneda_id(String moneda){
  
	int id=0;
	
	ResultSet rs=null;
	
	String sql="Select id_moneda from tb_monedas where descripcion="+"'"+moneda+"';";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	id=rs.getInt(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
		
	return id;
	}
	
//********************************************************************************************************
public int Categoria_id(String categoria){
		  
		int id=0;
		
		ResultSet rs=null;
		
		String sql="Select id_cat from tb_categorias where descripcion="+"'"+categoria+"';";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		id=rs.getInt(1);
		}
		
		}
		catch(Exception e){
		System.out.print(e.getMessage());	
		}
			
		return id;
		}
		
//********************************************************************************************************
	public void Ingresar_Puja(String nombre, String descripcion, int cantidad, int moneda, double val, int categorias){
		
	String sql="INSERT INTO tb_pujas (titulo,descripcion,cantidad,moneda,valor_minimo,fk_categoria,principal, estado) values ('"+nombre+"','"+descripcion+"',"+cantidad+","+moneda+","+val+","+categorias+",'false',"+1+");";
	System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
	
	
	}
//********************************************************************************************************
	public void Eiminar_Puja(int id){
		
	String sql="delete from tb_pujas where id_prod_pj="+id+";";
	//System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
	
	
	}
	
//********************************************************************************************************
	public void Eiminar_Imagen_Puja(int id){
		
	String sql="delete from tb_imagenes where id_producto_fk="+id+" "
			+ "and tipo=2;";
	//System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
	
	
	}
//********************************************************************************************************
	public int Obtener_ID (String nombre, String descripcion, int cantidad, int moneda, double val, int categorias){
	int id =0;
	ResultSet rs=null;
	
	String sql="Select id_prod_pj from tb_pujas where "
			+ "titulo='"+nombre+"' "
			+ "and descripcion='"+descripcion+"' "
			+ "and cantidad="+cantidad+" "
			+ "and moneda="+moneda+" "
			+ "and valor_minimo="+val+" "
			+ "and fk_categoria= "+categorias+";";
	
	System.out.println(sql);
	
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	id=rs.getInt(1);
	}
	
	}
	catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	
	return id;
	}

//********************************************************************************************************
	
	public String Todas_Pujas(){
		
		String pujas="<table class=table table-condensed>";
		pujas+="<tr style=color:#456789;font-size:150%;>";
		pujas+="<th> SELECIONAR NUEVA PUJA </th>";
		pujas+="<th> PUJA </th>";
		pujas+="<th> CANTIDAD </th>";
		pujas+="<th> MONEDA </th>";
		pujas+="<th> VALOR ACTUAL </th>";
		pujas+="</tr>";
		
		//System.out.println(pujas);

		ResultSet rs=null;
		
		String sql="select id_prod_pj, tb_pujas.titulo, tb_pujas.cantidad, tb_monedas.descripcion, tb_pujas.valor_minimo from tb_pujas, tb_monedas where tb_pujas.moneda=tb_monedas.id_moneda;;";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		
			
		pujas+="<tr style=color:#456789;font-size:100%;>";
		pujas+="<td><A HREF=Administar_Pujas.jsp?dato="+rs.getString(1)+">HACER PUJA PRINCIPAL</A></td>";
		pujas+="<td>"+rs.getString(2)+"</td>";
		pujas+="<td>"+rs.getString(3)+"</td>";
		pujas+="<td>"+rs.getString(4)+"</td>";
		pujas+="<td>"+rs.getString(5)+"</td>";
		pujas+="</tr>";
		}
		
		}
		catch(Exception e){
		System.out.print(e.getMessage());	
		}
		pujas+="</table>";
			
		//System.out.println(pujas);
		return pujas;
	}
	
//********************************************************************************************************
public int Puja_Pricipal(){
		  
		int id=0;
		
		ResultSet rs=null;
		
		String sql="Select id_prod_pj from tb_pujas where principal='TRUE';";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		id=rs.getInt(1);
		}
		
		}
		catch(Exception e){
		System.out.print(e.getMessage());	
		}
			
		return id;
		}

//********************************************************************************************************
public void Hacer_Principal(String id){

	String sql="update tb_pujas set principal='FALSE' where principal='TRUE';";
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}

	String sql1="update tb_pujas set principal='TRUE' where id_prod_pj="+id+";";
	try {
	con.Ejecutar(sql1);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
}


}

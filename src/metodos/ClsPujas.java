package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import datos.ClsConexion;

public class ClsPujas {

	
	
	public String Ver_Pujas(){
		
	ClsConexion con=new ClsConexion();
	String pujas="<div class=list-group>";
	ResultSet rs=null;
	String sql="Select id_prod_pj, titulo from tb_pujas where estado=1;";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	pujas+="<h3><a href=puja.jsp?id="+rs.getString(1)+" class=list-group-item><span class=badge>"
			+ "<span class=glyphicon glyphicon glyphicon-education aria-hidden=true>"
			+ "</span></span>";
	pujas+=rs.getString(2)+"</a></h3>";
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	pujas+="</div>";
	return pujas;
	}
	
	public String Descripcion(String id){
	
	ClsConexion con=new ClsConexion();
	String descripcion="";
	ResultSet rs=null;
	String sql="Select descripcion from tb_pujas where id_prod_pj="+id+";";
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	descripcion=rs.getString(1);
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	
	
	return descripcion;
	}
	
	public String Titulo(String id){
		
		ClsConexion con=new ClsConexion();
		String descripcion="";
		ResultSet rs=null;
		String sql="Select titulo from tb_pujas where id_prod_pj="+id+";";
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		descripcion=rs.getString(1);
		}
		//rs.close();
		}catch(Exception e){
		System.out.print(e.getMessage());	
		}
		
		try {
		rs.close();
		con.getConexion().close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		}
		
		
		return descripcion;
		}
	
	public String Moneda(String id){
	
	ClsConexion con=new ClsConexion();
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
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return descripcion;
	}
	
	public String Valor(String id){
	
	ClsConexion con=new ClsConexion();	
	String descripcion="";
	ResultSet rs=null;
	String sql="Select valor_minimo from tb_pujas where id_prod_pj="+id+";";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	descripcion=rs.getString(1);
	}
	//rs.close();
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
	return descripcion;
	}
//********************************************************************************************************

	public String Moneda(){
	ClsConexion con=new ClsConexion();
	String moneda="<select class=form-control name=moneda>"
	+ "<option> </option>";
	ResultSet rs=null;
	
	String sql="Select descripcion from tb_monedas where estadotf=TRUE order by descripcion asc;";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	moneda+="<option>"+rs.getString(1)+"</option>";
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	moneda+="</select required>";
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	
	return moneda;
	}
//********************************************************************************************************
	public String cmbCategorias(){
	ClsConexion con=new ClsConexion();
	String moneda="<select class=form-control name=categorias>"
	+ "<option> </option>";
	ResultSet rs=null;
	String sql="Select descripcion from tb_categorias order by descripcion asc;";
	//System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	moneda+="<option>"+rs.getString(1)+"</option>";
	}
	moneda+="</select required>";
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return moneda;
	}
//********************************************************************************************************
	
	public int Moneda_id(String moneda){
	ClsConexion con=new ClsConexion();
	int id=0;
	ResultSet rs=null;
	String sql="Select id_moneda from tb_monedas where descripcion="+"'"+moneda+"';";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	id=rs.getInt(1);
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	
	return id;
	}
//********************************************************************************************************
public int Categoria_id(String categoria){
	ClsConexion con=new ClsConexion();
	int id=0;
	ResultSet rs=null;
	String sql="Select id_cat from tb_categorias where descripcion="+"'"+categoria+"';";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	id=rs.getInt(1);
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	
	return id;
	}
		
//********************************************************************************************************
	public void Ingresar_Puja(String nombre, String descripcion, int cantidad, int moneda, double val, int categorias){
	ClsConexion con=new ClsConexion();
	String sql="INSERT INTO tb_pujas (titulo,descripcion,cantidad,moneda,valor_minimo,fk_categoria,principal, estado) values ('"+nombre+"','"+descripcion+"',"+cantidad+","+moneda+","+val+","+categorias+",'false',"+1+");";
	System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}

	}
//********************************************************************************************************
	public void Eiminar_Puja(int id){
	ClsConexion con=new ClsConexion();
	String sql="delete from tb_pujas where id_prod_pj="+id+";";
	System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
	
//********************************************************************************************************
	public void Eiminar_Imagen_Puja(int id){
	ClsConexion con=new ClsConexion();
	String sql="delete from tb_imagenes where id_producto_fk="+id+" "
			+ "and tipo=2;";
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
//********************************************************************************************************
	public int Obtener_ID (String nombre, String descripcion, int cantidad, int moneda, double val, int categorias){
	ClsConexion con=new ClsConexion();
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
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return id;
	}

//********************************************************************************************************
	
	public String Todas_Pujas(int estado){
		
		ClsConexion con=new ClsConexion();
		
		String pujas="<table class=table table-condensed>";
		pujas+="<tr style=color:#456789;font-size:150%;>";
		pujas+="<th> SELECIONAR NUEVA PUJA </th>";
		pujas+="<th> PUJA </th>";
		pujas+="<th> CANTIDAD </th>";
		pujas+="<th> MONEDA </th>";
		pujas+="<th> VALOR ACTUAL </th>";
		pujas+="</tr>";
		ResultSet rs=null;
		String sql="select id_prod_pj, tb_pujas.titulo, tb_pujas.cantidad, tb_monedas.descripcion, tb_pujas.valor_minimo from tb_pujas, tb_monedas where tb_pujas.moneda=tb_monedas.id_moneda and tb_pujas.estado="+estado+" order by id_prod_pj desc; ";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		pujas+="<tr style=color:#456789;font-size:100%;>";
		pujas+="<td><A HREF=Administar_Pujas.jsp?dato="+rs.getString(1)+"&tipo=1>HACER PUJA PRINCIPAL</A></td>";
		pujas+="<td>"+rs.getString(2)+"</td>";
		pujas+="<td>"+rs.getString(3)+"</td>";
		pujas+="<td>"+rs.getString(4)+"</td>";
		pujas+="<td>"+rs.getString(5)+"</td>";
		pujas+="</tr>";
		}
		//rs.close();
		}catch(Exception e){
		System.out.print(e.getMessage());	
		}
		pujas+="</table>";
		
		try {
		rs.close();
		con.getConexion().close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		}
		return pujas;
	}
	
//********************************************************************************************************
public int Puja_Pricipal(){
		ClsConexion con=new ClsConexion();
		int id=0;
		ResultSet rs=null;
		String sql="Select id_prod_pj from tb_pujas where principal='TRUE';";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		id=rs.getInt(1);
		}
		//rs.close();
		}catch(Exception e){
		System.out.print(e.getMessage());	
		}
		
		try {
		rs.close();
		con.getConexion().close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		}
		return id;
		}

//********************************************************************************************************
public void Hacer_Principal(String id){
	ClsConexion con=new ClsConexion();
	String sql="update tb_pujas set principal='FALSE' where principal='TRUE';";
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	e.printStackTrace();
	}
	String sql1="update tb_pujas set principal='TRUE' where id_prod_pj="+id+";";
	try {
	con.Ejecutar(sql1);
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
}
//********************************************************************************************************
	public void Ingresar_Tiempo(int id, String dia, String mes, String año, String hora, String minutos){
	ClsConexion con=new ClsConexion();
	System.out.println("*********************************>>>>>>>>>>>>>>>"+año);
	String sql="INSERT INTO tb_tiempo (id_puja,dia,mes,año,hora,minutos) values ("+id+",'"+dia+"','"+mes+"','"+año+"','"+hora+"','"+minutos+"');";
	System.out.println(":::::::::::::::::::::::::::::::"+sql);
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
//********************************************************************************************************
	public void Eliminar_Tiempo(int id){
	ClsConexion con=new ClsConexion();
	String sql="delete from tb_tiempo where id_puja="+id;
	System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
	
	try {	
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
	
//********************************************************************************************************
	public String Id_Puja_Momento(){
	ClsConexion con=new ClsConexion();
	String id=null;
	ResultSet rs=null;
	String sql="Select id_prod_pj from tb_pujas where principal='true';";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	id=rs.getString(1);
	System.out.println("???????????????????????"+id);
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return id;
	}
//********************************************************************************************************
public void Actualizar_Comprador_Valor(String id_comprador, int valor, int id){
	ClsConexion con=new ClsConexion();
	String sql="update tb_pujas set valor_minimo="+valor+", comprador="+id_comprador+"  where id_prod_pj="+id+";";
	//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
	
	try {
	con.Ejecutar(sql);
	Cls_mailing mailto=new Cls_mailing();
	mailto.deliver(8, id_comprador);
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
//********************************************************************************************************
public void Actualizar_Estado(String id){
	ClsConexion con=new ClsConexion();
	String sql="update tb_pujas set estado=2 where id_prod_pj="+id+";";
	System.out.println("****************"+sql);
	try {
	con.Ejecutar(sql);
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
		
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
//********************************************************************************************************

public String Pujas_Terminadas(int estado){
	ClsConexion con=new ClsConexion();
	String pujas="<table class=table table-condensed>";
	pujas+="<tr style=color:#456789;font-size:150%;>";
	pujas+="<th> ELIMINAR </th>";
	pujas+="<th> DESCRIPCION </th>";
	pujas+="<th> MONEDA </th>";
	pujas+="<th> VALOR OFERTADO </th>";
	pujas+="<th> CEDULA DEL OFERTANTE </th>";
	pujas+="<th> NOMBRE </th>";
	pujas+="<th> APELLIDO </th>";
	pujas+="</tr>";
	ResultSet rs=null;
	String sql="select id_prod_pj, tb_pujas.titulo, tb_monedas.descripcion, tb_pujas.valor_minimo, comprador, tb_usuarios.nombre, tb_usuarios.apellido  from tb_pujas, tb_monedas, tb_usuarios where tb_pujas.moneda=tb_monedas.id_moneda and tb_pujas.comprador= tb_usuarios.id_usuario and tb_pujas.estado="+estado+" order by id_prod_pj desc;";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	pujas+="<tr style=color:#456789;font-size:100%;>";
	pujas+="<td><A HREF=Administar_Pujas.jsp?dato="+rs.getString(1)+"&tipo=2>ELIMINAR</A></td>";
	pujas+="<td>"+rs.getString(2)+"</td>";
	pujas+="<td>"+rs.getString(3)+"</td>";
	pujas+="<td>"+rs.getString(4)+"</td>";
	pujas+="<td>"+rs.getString(5)+"</td>";
	pujas+="<td>"+rs.getString(6)+"</td>";
	pujas+="<td>"+rs.getString(7)+"</td>";
	pujas+="</tr>";
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	pujas+="</table>";
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return pujas;
}

//********************************************************************************************************
public void Pujas_Historico(String id){
		ClsConexion con=new ClsConexion();
		
		String titulo, descripcion, comprador;
		int cantidad, moneda, valor, categoria; 
	
		ResultSet rs=null;
		String sql="Select *from tb_pujas where id_prod_pj="+id+";";
		System.out.println(sql);
		try{
		rs=con.Consulta(sql);
		while(rs.next()){
		titulo=rs.getString(2);
		//descripcion=rs.getString(3);
		cantidad=rs.getInt(4);
		moneda=rs.getInt(5);
		valor=rs.getInt(6);
		categoria=rs.getInt(7);
		comprador=rs.getString(10);
		
		Ingresar_Historia(Integer.parseInt(id), titulo, cantidad, moneda, categoria, valor, comprador);
		
		
		//System.out.println("****************************"+titulo+"  "+descripcion+"  "+cantidad+"  "+moneda+"  "+valor+"  "+categoria+"  "+comprador);
		
		
		}
		//rs.close();
		}catch(Exception e){
		System.out.print(e.getMessage());	
		}
		
		try {
		rs.close();
		con.getConexion().close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		}

		}
//********************************************************************************************************
	public void Ingresar_Historia(int id_producto, String descripcion, int cantidad, int fk_moneda, int fk_categoria, int valor_minimo, String fk_id_usuario ){
	ClsConexion con=new ClsConexion();
	Date date = new Date();
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
	String sql="INSERT INTO tb_historico (id_producto,descripcion,tipo,cantidad,fk_moneda,fk_categoria,valor_minimo,fecha,fk_id_usuario) values ("+id_producto+",'"+descripcion+"',"+2+","+cantidad+","+fk_moneda+","+fk_categoria+","+valor_minimo+",'"+dateFormat.format(date)+"','"+fk_id_usuario+"');";
	System.out.println(":::::::::::::::::::::::::::::::"+sql);
	try {
	con.Ejecutar(sql);
	} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
//********************************************************************************************************
public void Actualizar_Valor_Actual(String id, String valor){
	
	ClsConexion con=new ClsConexion();
	String sql="update tb_pujas set anterior="+valor+" where id_prod_pj="+id+";";
	//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
	try {
	con.Ejecutar(sql);
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}
//********************************************************************************************************
public String Pujas_Valor_Anterior(int estado){
	ClsConexion con=new ClsConexion();
	String pujas="<table class=table table-condensed>";
	pujas+="<tr style=color:#456789;font-size:150%;>";
	pujas+="<th> VALOR ANTERIOR </th>";
	pujas+="<th> PUJA </th>";
	pujas+="<th> MONEDA </th>";
	pujas+="<th> V. ACTUAL </th>";
	pujas+="<th> V. ANTERIOR </th>";
	pujas+="<th> CEDULA</th>";
	pujas+="<th> NOMBRE </th>";
	pujas+="<th> APELLIDO </th>";
	pujas+="</tr>";
	ResultSet rs=null;
	String sql="select id_prod_pj, tb_pujas.titulo, tb_monedas.descripcion, tb_pujas.valor_minimo, tb_pujas.anterior, comprador, tb_usuarios.nombre, tb_usuarios.apellido  from tb_pujas, tb_monedas, tb_usuarios where tb_pujas.moneda=tb_monedas.id_moneda and tb_pujas.comprador= tb_usuarios.id_usuario and tb_pujas.estado="+estado+" order by id_prod_pj desc;";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	pujas+="<tr style=color:#456789;font-size:100%;>";
	pujas+="<td><A HREF=Administar_Pujas.jsp?dato="+rs.getString(1)+"&tipo=3>VOLVER A VALOR ANTERIOR</A></td>";
	pujas+="<td>"+rs.getString(2)+"</td>";
	pujas+="<td>"+rs.getString(3)+"</td>";
	pujas+="<td>"+rs.getString(4)+"</td>";
	pujas+="<td>"+rs.getString(5)+"</td>";
	pujas+="<td>"+rs.getString(6)+"</td>";
	pujas+="<td>"+rs.getString(7)+"</td>";
	pujas+="<td>"+rs.getString(8)+"</td>";
	pujas+="</tr>";
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	pujas+="</table>";
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return pujas;
}

//********************************************************************************************************
public void Actualizar_Valor_Anterior(String id){
	ClsConexion con=new ClsConexion();
	String sql="update tb_pujas set valor_minimo=anterior where id_prod_pj="+id+";";
	//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
	try {
	con.Ejecutar(sql);
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	try {
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	}

//********************************************************************************************************
	public int Controlar_Puja(){
	
	ClsConexion con=new ClsConexion();
	int id=0;
	ResultSet rs=null;
	String sql="select count(*) from tb_pujas where estado =1;";
	System.out.println(sql);
	try{
	rs=con.Consulta(sql);
	while(rs.next()){
	id=rs.getInt(1);
	}
	//rs.close();
	}catch(Exception e){
	System.out.print(e.getMessage());	
	}
	
	try {
	rs.close();
	con.getConexion().close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	}
	return id;
	}
}//fin de TODA LA LASE


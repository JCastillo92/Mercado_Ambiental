package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsImagen;
import metodos.ClsPujas;

/**
 * Servlet implementation class Ingreso_Puja
 */
@WebServlet("/Ingreso_Puja")
public class Ingreso_Puja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ingreso_Puja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	this.doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ClsPujas puja = new ClsPujas();
		ClsImagen obj = new ClsImagen();
		
		String nombre, moneda, descripcion, cantidad, valor, categorias;
		String pathimg1,pathimg2,pathimg3,pathimg4;
		boolean t1=false,t2=false,t3=false,t4=false;
		double val = 0;
		int can = 0;
		boolean a=true;
		
		pathimg1 = request.getParameter("img0");
		System.out.println("------------------------------"+pathimg1);
		pathimg2 = request.getParameter("img1");
		pathimg3 = request.getParameter("img2");
		pathimg4 = request.getParameter("img3");
		
		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		moneda = request.getParameter("moneda");
		cantidad=request.getParameter("cantidad");
		valor=request.getParameter("valor");
		categorias=request.getParameter("categorias");
		
		
				
		
		try{
		val=Double.parseDouble(valor);
		}
		catch(Exception e){
		a=false;	
		}
		
		try{
		can=Integer.parseInt(cantidad);
		}
		catch(Exception e){
		a=false;	
		}
		
		//System.out.println(nombre+" "+descripcion+" "+moneda+" "+cantidad+" "+valor+" "+categorias);
		
		//System.out.println("moneda="+moneda);
		//System.out.println("categoria="+categorias);
		
		if(moneda.equals("")||categorias.equals("")||a==false){
		response.sendRedirect("Crear_Puja.jsp?dato=Error verifique que todos los datos hayan sido llenados o escogidos correctamente");
		
		}else{
		int mon = puja.Moneda_id(moneda);
		int cat =puja.Categoria_id(categorias);
		int id;
		puja.Ingresar_Puja(nombre, descripcion, can, mon, val, cat);
		id=puja.Obtener_ID(nombre, descripcion, can, mon, val, cat);
		
		try {
		t1=obj.insertarimagen_puja(pathimg1, id);
		t2=obj.insertarimagen_puja(pathimg2, id);
		t3=obj.insertarimagen_puja(pathimg3, id);
		t4=obj.insertarimagen_puja(pathimg4, id);
		} catch (Exception e) {
		t1=false;t2=false;t3=false;t4=false;
		}

		
		if(t1==true && t2==true && t3==true && t4==true){
		response.sendRedirect("Crear_Puja.jsp?dato=Datos Ingresados Correctamente");
		}
		else{
		response.sendRedirect("Crear_Puja.jsp?dato=Las imágenes deben ser únicamente en formato jpg");
		System.out.println("BORRAR DATOS");
		puja.Eiminar_Puja(id);
		puja.Eiminar_Imagen_Puja(id);
		}
		
		
		}
	
	
	}

}

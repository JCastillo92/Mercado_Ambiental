package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String nombre, moneda, descripcion, cantidad, valor, categorias;
		
		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		moneda = request.getParameter("moneda");
		cantidad=request.getParameter("cantidad");
		valor=request.getParameter("valor");
		categorias=request.getParameter("categorias");
		
		
		
		//System.out.println(nombre+" "+descripcion+" "+moneda+" "+cantidad+" "+valor);
		
		if(nombre != null  && descripcion != null && categorias != null && moneda != null &&  cantidad!= null &&  valor!= null ){
		response.sendRedirect("Crear_Puja.jsp?dato=Datos Ingresados Correctamente");
		
		puja.Moneda(moneda);
		}else{
		response.sendRedirect("Crear_Puja.jsp?dato=Error verifique que todos los datos hayan sido llenados o escogidos correctamente");
		}
	
	
	}

}

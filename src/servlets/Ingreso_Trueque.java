package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.*;

/**
 * Servlet implementation class Ingreso_Trueque
 */
@WebServlet("/Ingreso_Trueque")
public class Ingreso_Trueque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ingreso_Trueque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
ClsAdmin trueque = new ClsAdmin();
		
		String descripcion, titulo, moneda; int cantidad,estado; 
		
		titulo = request.getParameter("txtProducto");
		descripcion = request.getParameter("txtArea");
		moneda = (request.getParameter("moneda"));
		cantidad=Integer.parseInt(request.getParameter("txtCantidad"));
		estado=1;
		
		
		
		
		System.out.println(titulo+" "+descripcion+" "+moneda+" "+cantidad+" "+estado);
		
		if(descripcion != null  && titulo != null && moneda != null &&  cantidad!= 0 ){
			if(trueque.agregarTrueque(descripcion,cantidad,trueque.Moneda_id(moneda),titulo,estado)){
				
		response.sendRedirect("A_subir_trueque.jsp?dato=Datos Ingresados Correctamente");
		
		
		}else{
		response.sendRedirect("A_subir_trueque.jsp?dato=Error verifique que todos los datos hayan sido llenados o escogidos correctamente");
		}
	
	
	}
	}

}

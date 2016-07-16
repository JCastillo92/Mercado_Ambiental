package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sr_T_confirma_venta
 */
@WebServlet("/Sr_T_confirma_venta")
public class Sr_T_confirma_venta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_T_confirma_venta() {
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
		
		String titulo_producto_trueque=request.getParameter("datoA");//titulo producto
		String cedula_comprador_prod_trueque=request.getParameter("datoB");//cedula del comprador
		String descripcion_prod_vendido=request.getParameter("datoC");// descripcion producto
		
		
		System.out.println("================"+titulo_producto_trueque+"   "+cedula_comprador_prod_trueque);
		
	}

}

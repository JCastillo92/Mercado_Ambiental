package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsAdmin;



/**
 * Servlet implementation class Ingreso
 */
@WebServlet("/ingresoMoneda")
public class IngresoMoneda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresoMoneda() {
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
		
		String descripcion; 
		ClsAdmin obj = new ClsAdmin();
		descripcion = request.getParameter("txtMoneda");
		System.out.println(descripcion);
		
			 
			if(obj.agregarmoneda(descripcion)){
				response.sendRedirect("AgregarMoneda.jsp?msg=true");
			}else{
				response.sendRedirect("AgregarMoneda.jsp?msg=false");
			}
		
		
		
	}

	}

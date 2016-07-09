package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsAdmin;



/**
 * Servlet implementation class Se_elimina_moneda
 */
@WebServlet("/Se_elimina_moneda")
public class Se_elimina_moneda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Se_elimina_moneda() {
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
		
		ClsAdmin obj =new ClsAdmin();
		String id_a_eliminar=request.getParameter("dato");
		Integer id=Integer.parseInt(id_a_eliminar);
		
		boolean borra=obj.elimina_moneda(id);
		if(borra){
			response.sendRedirect("AgregarMoneda.jsp?msg=true");
		}else{
			response.sendRedirect("AgregarMoneda.jsp?msg=false");
		}
		
	}

}

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsAdmin;

/**
 * Servlet implementation class Sr_A_deny_user
 */
@WebServlet("/Sr_A_deny_user")
public class Sr_A_deny_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_A_deny_user() {
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
		ClsAdmin obj= new ClsAdmin();
		String recibo_dato_eliminar=request.getParameter("dato2");
		if(obj.delete_user(recibo_dato_eliminar)){
			response.sendRedirect("A_accept_delete.jsp?msg=true");
		}else{
			response.sendRedirect("A_accept_delete.jsp?msg=false");
		}
		
	}//fin void
}//Sr_A_deny_user

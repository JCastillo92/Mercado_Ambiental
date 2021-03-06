package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsAdmin;

/**
 * Servlet implementation class Sr_A_desbloquear_usuario
 */
@WebServlet("/Sr_A_desbloquear_usuario")
public class Sr_A_desbloquear_usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_A_desbloquear_usuario() {
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
		String recibo_id_para_aceptar=request.getParameter("dato");
		ClsAdmin obj=new ClsAdmin();
		if(obj.desbloquear_usuario(recibo_id_para_aceptar)){
			response.sendRedirect("A_blocked_users.jsp?dato=true");
		}else{
		response.sendRedirect("A_blocked_users.jsp?dato=false");
		}
	}

}

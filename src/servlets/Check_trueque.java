package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metodos.Cls_Trueque;

/**
 * Servlet implementation class Check_trueque
 */
@WebServlet("/check_trueque")
public class Check_trueque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_trueque() {
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
		
		String id_producto = request.getParameter("id");
		HttpSession sessionok = request.getSession();
		String cedula = (String)sessionok.getAttribute("cedula");
		Cls_Trueque obj = new Cls_Trueque();
		if(obj.trueque_usuario(id_producto, cedula)){
			response.sendRedirect("trueque.jsp?dato='Trueque realizado exitosamente'");
		}else{
			response.sendRedirect("trueque.jsp?dato='El producto ya fue cambiado'");
		}
		
		
	}

}

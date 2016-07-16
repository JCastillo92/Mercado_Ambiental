package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metodos.ClsUsuario;
import metodos.Cls_General;

/**
 * Servlet implementation class logueame
 */
@WebServlet("/logueame")
public class logueame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logueame() {
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
		
		String usuario, clave;
		usuario = request.getParameter("txtuser");
		clave = request.getParameter("txtpassword");
		Cls_General obj = new Cls_General();
		boolean t =obj.ComprobarLoguin(usuario, clave);
		if(t == true){
			//Crea session
			HttpSession sesionok = request.getSession();
			sesionok.setAttribute("log", obj.getLog());
			sesionok.setAttribute("nom", obj.getNombre());
			sesionok.setAttribute("cedula", obj.getCedula());
			response.sendRedirect("index.jsp");
		}else{
			
			response.sendRedirect("index.jsp?error=Usuario o clave incorrectos / Usuario inactivo");
			/*<jsp:forward page="index.jsp">
			<jsp:param value="Usuario o clave incorrectos" name="error"/>
			</jsp:forward>*/

		}
		
	}

}

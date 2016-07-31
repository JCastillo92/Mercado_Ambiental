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
		String id_recibo=request.getParameter("dato");
		String estado=request.getParameter("dato1");
		
		Integer id=Integer.parseInt(id_recibo);
		Integer estatus=Integer.parseInt(estado);
		
		if(estatus==1){//1 habilitar
			boolean habilitar=obj.habilitar_moneda(id);
			if(habilitar){
				response.sendRedirect("AgregarMoneda.jsp?msg=true");
			}else{
				response.sendRedirect("AgregarMoneda.jsp?msg=false");
			}
		}else{//2 deshabilitar
			boolean habilitar=obj.deshabilitar_moneda(id);
			if(habilitar){
				response.sendRedirect("AgregarMoneda.jsp?msg=true");
			}else{
				response.sendRedirect("AgregarMoneda.jsp?msg=false");
			}
		}
		
		
	}

}

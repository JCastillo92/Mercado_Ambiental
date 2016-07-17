package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsPujas;

/**
 * Servlet implementation class Pujar
 */
@WebServlet("/Pujar")
public class Pujar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pujar() {
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
		doGet(request, response);
		
		
		ClsPujas obj = new ClsPujas();
		String puja = request.getParameter("oferta");
		String valor = request.getParameter("valor");
		
		//obj.Valor(id);
		
		int oferta = 0;
		try{
		oferta=Integer.parseInt(puja);
		
		if(Integer.parseInt(valor)>=oferta){
		response.sendRedirect("puja.jsp?dato=Error ingrese una oferta mayor al Actual");	
		}
		else{
		
		}
		
		
		}
		catch(Exception e){
		response.sendRedirect("puja.jsp?dato=Error ingrese un valor correcto en el campo Ofertar Valor");
		}
		
		
		
		
	}

}

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession sesionok = request.getSession();
		
		String cedula=(String) sesionok.getAttribute("cedula");
		
		ClsPujas obj = new ClsPujas();
		String puja = request.getParameter("oferta");
		String valor = request.getParameter("valor");
		String id = request.getParameter("id_puja");
		
		
		//obj.Valor(id);
		
		int oferta = 0;
		try{
		oferta=Integer.parseInt(puja);
		//System.out.println(id+"  "+cedula+"  "+oferta);
		//System.out.println(oferta+" ********************");
		//System.out.println(valor+" ********************");
		
		if(Integer.parseInt(valor)>=oferta){
		response.sendRedirect("puja.jsp?dato=Error ingrese una oferta mayor al Actual");	
		}
		else{
		obj.Actualizar_Comprador_Valor(cedula, oferta, Integer.parseInt(id));
		response.sendRedirect("puja.jsp?dato=Oferta Realizada");
		}
		
		
		}
		catch(Exception e){
		response.sendRedirect("puja.jsp?dato=Error ingrese un valor correcto en el campo Ofertar Valor");
		}
		
		
		
		
	}

}

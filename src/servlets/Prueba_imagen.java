package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsImagen;

/**
 * Servlet implementation class Prueba_imagen
 */
@WebServlet("/prueba_imagen")
public class Prueba_imagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba_imagen() {
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
		String pathimg;
		pathimg = request.getParameter("btnarchivo");
		
		//NUEVAS LINEAS
		String path_verdadero_imagen="";
		try {
			path_verdadero_imagen = request.getParameter("path_imagen");
		} catch (Exception e) {
			// TODO: handle exception
		}
		//FIN NUEVAS LINEAS
		
		System.out.println("----------"+path_verdadero_imagen);
		ClsImagen obj = new ClsImagen();
		obj.insertarimagen(path_verdadero_imagen);
		response.sendRedirect("pruebaimagen.jsp");
	}

}

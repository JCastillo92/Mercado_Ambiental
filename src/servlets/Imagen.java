package servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsImagen;

/**
 * Servlet implementation class Imagen
 */
@WebServlet("/imagen")
public class Imagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imagen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.doPost(request, response);
		
		ClsImagen obj = new ClsImagen();
		byte hh[] = null ;
		
		//CODIGO PARA DESPLEGAR LAS IMAGENES DE UN PRODUCTO
		String productoselect, lugar, tipo;
		int cuentaimagenes;
		productoselect = request.getParameter("prod");
		lugar = request.getParameter("place");
		tipo = request.getParameter("i_tipo");
		obj.contador(productoselect);
		
		// -- MANDAR A BUSCAR IMAGENES
		cuentaimagenes = obj.getContador();
		if (Integer.parseInt(lugar) <= cuentaimagenes) {
			obj.recuperarimagen(productoselect,lugar,tipo);
			hh = (byte[])obj.getImgBytes2();
			response.setContentType("image/jpeg");
			OutputStream o = response.getOutputStream();
			o.write(hh);

		}
		
		
		//FIN CODIGO IDUP
		
		
		/*
		  	byte hh[] = null ;
		 	obj.recuperarimagen(productoselect,lugar);
			hh = (byte[])obj.getImgBytes2();
		 
		 */
		
		/*response.setContentType("image/jpeg");
		OutputStream o = response.getOutputStream();
		o.write(hh);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

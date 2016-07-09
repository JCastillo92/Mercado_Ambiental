package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metodos.ClsImagen;
/**
 * Servlet implementation class Sr_A_ingresa_trueque
 */
@WebServlet("/Sr_A_ingresa_trueque")
public class Sr_A_ingresa_trueque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_A_ingresa_trueque() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathimg1,pathimg2,pathimg3,pathimg4;
		pathimg1 = request.getParameter("img0");
		pathimg2 = request.getParameter("img1");
		pathimg3 = request.getParameter("img2");
		pathimg4 = request.getParameter("img3");
		
		ClsImagen obj = new ClsImagen();
		boolean t1=false,t2=false,t3=false,t4=false;
		try {
			t1=obj.insertarimagen_trueque(pathimg1);
			t2=obj.insertarimagen_trueque(pathimg2);
			t3=obj.insertarimagen_trueque(pathimg3);
			t4=obj.insertarimagen_trueque(pathimg4);
		} catch (Exception e) {
			t1=false;t2=false;t3=false;t4=false;
		}
		
		if(t1==true && t2==true && t3==true && t4==true){
			response.sendRedirect("A_subir_trueque.jsp?msg=true");
		}else{
			ClsImagen delete_img=new ClsImagen();
			//aqui elimino las imagenes de la base en caso de que exista un
			//error de ingreso en alguna de las 4 imagenes
			//entonces vuelve a quedar en "cero" la base
			delete_img.falla_ingreso_imagenes_trueque();
			//aqui debo eliminar lo que ingresa el Bryan
			response.sendRedirect("A_subir_trueque.jsp?msg=false");
		}
		
	}

}

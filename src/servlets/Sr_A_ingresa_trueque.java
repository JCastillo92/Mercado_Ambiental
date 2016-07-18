package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.ClsAdmin;
import metodos.ClsImagen;
import metodos.Cls_Trueque;
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
ClsAdmin trueque = new ClsAdmin();
		
		String descripcion, titulo, moneda,categoria; int cantidad,estado; 
		
		titulo = request.getParameter("txtProducto");
		descripcion = request.getParameter("txtArea");
		moneda = (request.getParameter("moneda"));
		categoria = (request.getParameter("categoria"));
		cantidad=Integer.parseInt(request.getParameter("txtCantidad"));
		estado=1;
		System.out.println(titulo+" "+descripcion+" "+moneda+" "+cantidad+" "+estado);
		
		if(descripcion != null  && titulo != null && moneda != null &&  cantidad!= 0 ){
			if(trueque.agregarTrueque(descripcion,cantidad,trueque.Moneda_id(moneda),titulo,trueque.Categoria_id(categoria),estado)){
///////////////////////I M A G E N S ////////////////////////////
	String pathimg1,pathimg2,pathimg3,pathimg4;
	int saber_id_ingreso_trueque=0;
	Cls_Trueque objeto=new Cls_Trueque();
	saber_id_ingreso_trueque=objeto.saber_id_nuevo_producto_trueque(descripcion,cantidad,trueque.Moneda_id(moneda),titulo,estado);
	
	pathimg1 = request.getParameter("path_imagen1");
	System.out.println(pathimg1);
	pathimg2 = request.getParameter("path_imagen2");
	pathimg3 = request.getParameter("path_imagen3");
	pathimg4 = request.getParameter("path_imagen4");
	
	
	ClsImagen obj = new ClsImagen();
	boolean t1=false,t2=false,t3=false,t4=false;
	try {
		t1=obj.insertarimagen_trueque(pathimg1,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
		t2=obj.insertarimagen_trueque(pathimg2,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
		t3=obj.insertarimagen_trueque(pathimg3,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
		t4=obj.insertarimagen_trueque(pathimg4,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
	} catch (Exception e) {
		t1=false;t2=false;t3=false;t4=false;
	}
	
	if(t1==true && t2==true && t3==true && t4==true){
		response.sendRedirect("A_subir_trueque.jsp?msg=true");
	}else{
		//aqui elimino las imagenes de la base en caso de que exista un
		//error de ingreso en alguna de las 4 imagenes
		//entonces vuelve a quedar en "cero" la base
		objeto.borrar_imagen_y_dato_en_caso_de_error_trueque(saber_id_ingreso_trueque);
		//aqui debo eliminar lo que ingresa el Bryan
		response.sendRedirect("A_subir_trueque.jsp?msg=false");
	}//fin else jairo
		}else{//fin if de ingreso del bryan
			response.sendRedirect("A_subir_trueque.jsp?msg=false");
		}
	}else{
		response.sendRedirect("A_subir_trueque.jsp?msg=false");
	}
		
		
	}}
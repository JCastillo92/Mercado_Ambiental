package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import metodos.ClsAdmin;
import metodos.ClsImagen;
import metodos.Cls_Trueque;
/**
 * Servlet implementation class Sr_A_ingresa_trueque
 */
@WebServlet("/Sr_A_ingresa_trueque")
@MultipartConfig
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

Cls_Trueque objeto=new Cls_Trueque();
int saber_id_ingreso_trueque=0;

		String descripcion, titulo, moneda,categoria; int cantidad,estado; 
		
		titulo = request.getParameter("txtProducto");
		descripcion = request.getParameter("txtArea");
		moneda = (request.getParameter("moneda"));
		categoria = (request.getParameter("categoria"));
		System.out.println(titulo+" "+descripcion+" "+moneda);
		cantidad=Integer.parseInt(request.getParameter("txtCantidad"));
		estado=1;
		System.out.println(titulo+" "+descripcion+" "+moneda+" "+cantidad+" "+estado);
	
		
		if(descripcion != null  && titulo != null && moneda != null &&  cantidad!= 0 ){
			if(trueque.agregarTrueque(descripcion,cantidad,trueque.Moneda_id(moneda),titulo,trueque.Categoria_id(categoria),estado)){
///////////////////////I M A G E N S ////////////////////////////
	String pathimg1,pathimg2,pathimg3,pathimg4;
	
	
	saber_id_ingreso_trueque=objeto.saber_id_nuevo_producto_trueque(descripcion,cantidad,trueque.Moneda_id(moneda),titulo,estado);
	
	/*
	pathimg1 = request.getParameter("path_imagen1");
	System.out.println(pathimg1);
	pathimg2 = request.getParameter("path_imagen2");
	pathimg3 = request.getParameter("path_imagen3");
	pathimg4 = request.getParameter("path_imagen4");
	*/
	
	//CAMBIO CODIGO IMGS
	Part filePart = request.getPart("img0"); // Retrieves <input type="file" name="file">
    String fileName = filePart.getSubmittedFileName(); //aca agarro el nombre
    InputStream fileContent = filePart.getInputStream(); //aca agarro el contenido
    int img_size = (int)filePart.getSize();
    
    Part filePart1 = request.getPart("img1");
    String fileName1 = filePart1.getSubmittedFileName(); //aca agarro el nombre
    InputStream fileContent1 = filePart1.getInputStream(); //aca agarro el contenido
    int img_size1 = (int)filePart1.getSize();
    
    Part filePart2 = request.getPart("img2");
    String fileName2 = filePart2.getSubmittedFileName(); //aca agarro el nombre
    InputStream fileContent2 = filePart2.getInputStream(); //aca agarro el contenido
    int img_size2 = (int)filePart2.getSize();
    
    Part filePart3 = request.getPart("img3");
    String fileName3 = filePart3.getSubmittedFileName(); //aca agarro el nombre
    InputStream fileContent3 = filePart3.getInputStream(); //aca agarro el contenido
    int img_size3 = (int)filePart3.getSize();
    /*COPIO EL FILE EN MI PC SERVIDOR
    File file = new File("C:/Imagenes/", fileName);
    try (InputStream input = filePart.getInputStream()) {
        Files.copy(input, file.toPath());
    }*/
	
	ClsImagen obj = new ClsImagen();
	boolean t1=false,t2=false,t3=false,t4=false;
	try {
		t1=obj.insertarimagen_trueque(fileName,fileContent,img_size,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
		t2=obj.insertarimagen_trueque(fileName1,fileContent1,img_size1,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
		t3=obj.insertarimagen_trueque(fileName2,fileContent2,img_size2,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
		t4=obj.insertarimagen_trueque(fileName3,fileContent3,img_size3,1,saber_id_ingreso_trueque);//el ,1 significa tipo=1=trueque
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
			objeto.borrar_imagen_y_dato_en_caso_de_error_trueque(saber_id_ingreso_trueque);
			response.sendRedirect("A_subir_trueque.jsp?msg=false");
		}
	}else{
		response.sendRedirect("A_subir_trueque.jsp?msg=false");
	}
		
		
	}}
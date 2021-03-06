package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import metodos.ClsUsuario;
import metodos.Cls_validacione_password;

/**
 * Servlet implementation class Sr_actualiza_user_personal
 */
@WebServlet("/Sr_actualiza_user_clave")
public class Sr_actualiza_user_clave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_actualiza_user_clave() {
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
		
		String cedula,direccion,clave,clave2,telefono,clave_antigua,clave_base ;
		ClsUsuario obj=new ClsUsuario();
		Cls_validacione_password objpasss=new Cls_validacione_password(); 
		
		HttpSession sessionok = request.getSession();
		cedula = (String)sessionok.getAttribute("cedula"); //cedula del logueado
		direccion = request.getParameter("txtDireccion");
		telefono=request.getParameter("txtTelefono");
		clave = request.getParameter("txtClave1");
		clave2 = request.getParameter("txtClave2");
		clave_antigua = request.getParameter("txtClaveN");
		clave_base=obj.Clave(cedula).trim();
		
		boolean contaseņas=false;
		contaseņas=objpasss.check_password(clave, clave2);
			
		
		
		if(clave != null  && clave2 != null && clave_antigua != null && (clave_base.equals(clave_antigua))&& contaseņas==true){
			obj.actualuza_clave(clave, cedula);
					response.sendRedirect("Usuario_peronal.jsp?dato=true");
			}else{
			response.sendRedirect("Edit_claves.jsp?dato=false");
			}
	}}//fin

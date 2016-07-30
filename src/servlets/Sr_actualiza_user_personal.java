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
@WebServlet("/Sr_actualiza_user_personal")
public class Sr_actualiza_user_personal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_actualiza_user_personal() {
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
		
		String cedula,direccion,telefono ;
		ClsUsuario obj=new ClsUsuario();
		
		HttpSession sessionok = request.getSession();
		cedula = (String)sessionok.getAttribute("cedula"); //cedula del logueado
		direccion = request.getParameter("txtDireccion");
		telefono=request.getParameter("txtTelefono");
		
		if(direccion != null  && telefono!= null){
		obj.actualuza_el_usuario(direccion, telefono, cedula);
		response.sendRedirect("Usuario_peronal.jsp?dato=true");
		}else{
			response.sendRedirect("Edit_tel_dir.jsp?dato=false");		
		}
	}}//fin


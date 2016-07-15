package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String cedula,direccion,clave,clave2,telefono,clave_antigua,clave_nueva ;
		ClsUsuario obj=new ClsUsuario();
		Cls_validacione_password objpasss=new Cls_validacione_password(); 
		
		HttpSession sessionok = request.getSession();
		cedula = (String)sessionok.getAttribute("cedula"); //cedula del logueado
		direccion = request.getParameter("txtDireccion");
		telefono=request.getParameter("txtTelefono");
		clave = request.getParameter("txtClave1");
		clave2 = request.getParameter("txtClave2");
		clave_antigua = request.getParameter("txtClave");
		clave_nueva=obj.Clave(cedula);
		
		boolean contaseņas=false;
		contaseņas=objpasss.check_password(clave, clave2);
		
		System.out.println(contaseņas);
		
		System.out.println(clave_antigua +" es igual "+obj.Clave(cedula));
		
		if(clave_antigua==clave_nueva){
			if( direccion != null && telefono != null &&  contaseņas==true ){
			obj.actualuza_el_usuario(direccion,telefono,clave,cedula);
			response.sendRedirect("index.jsp?dato=Datos Ingresados Correctamente");
			}else{
			response.sendRedirect("Edit_tel_dir.jsp?dato=Error verifique que los datos no sean vacios o que el password coincida");
			}
		}
	}
}//fin

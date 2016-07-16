package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import metodos.Cls_validacione_password;
import metodos.ClsUsuario;


/**
 * Servlet implementation class Ingreso
 */
@WebServlet("/ingreso")
public class Ingreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ingreso() {
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
		
		String cedula,nombre,apellido,correo; String direccion,clave,clave2,telefono ; int perfil; boolean estado;
		ClsUsuario obj = new ClsUsuario();
		
		Cls_validacione_password objpasss=new Cls_validacione_password();
		
		cedula = request.getParameter("txtCedula");
		nombre = request.getParameter("txtNombre");
		apellido = request.getParameter("txtApellido");
		correo = request.getParameter("txtCorreo");
		direccion = request.getParameter("txtDireccion");
			
		telefono=request.getParameter("txtTelefono");
		clave = request.getParameter("txtClave");
		clave2 = request.getParameter("txtClave2");
		perfil=1;
		estado= false;
		
		boolean contaseñas=false;
		contaseñas=objpasss.check_password(clave, clave2);
		
		System.out.println(cedula+nombre+apellido+correo +direccion+direccion+clave);
		System.out.println(contaseñas);
		if(nombre != null && cedula != null  && direccion != null  && apellido != null && correo != null && telefono != null &&  contaseñas==true ){
			 
			if(obj.agregarusuario(cedula,nombre,apellido,clave,correo,direccion,telefono,perfil)){
				obj.agregarusuario_activo(cedula, estado);
				response.sendRedirect("index.jsp?error=Datos Ingresados Correctamente");
			}else{
				response.sendRedirect("index.jsp?error=Datos Ingresados Equivocos");
			}
		}else{
			response.sendRedirect("registro.jsp?error=Datos Ingresados Equivocos Verifique que las claves sean iguales");
			JOptionPane.showMessageDialog(null,"Datos Ingresados Equivocos Verifique que las claves sean iguales");
		}
		
		
	}

	}

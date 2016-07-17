package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;

import datos.ClsConexion;

public class Cls_index_components {
	
	public String top_5_user_index(){
		//top 5 usuarios que mas compran, en TRUEQUE y PUJA
		//sql SELECT tb_usuarios.nombre,count(tb_historico.fk_id_usuario) FROM tb_historico,tb_usuarios	WHERE tb_historico.fk_id_usuario=tb_usuarios.id_usuario	GROUP BY tb_usuarios.nombre;
		String sql="SELECT tb_usuarios.nombre,count(tb_historico.fk_id_usuario)FROM tb_historico,tb_usuarios WHERE tb_historico.fk_id_usuario=tb_usuarios.id_usuario GROUP BY tb_usuarios.nombre;";
		ClsConexion con=new ClsConexion();
		ResultSet rs=null;
		String acum_jsp="<table class=\"table table-striped\"> ";
		acum_jsp+=" <thead><tr><th>NOMBRE</th><th># COMPRAS</th></thead><tbody>";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acum_jsp=acum_jsp+"<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>";
			}
			acum_jsp+="</tbody></table>";
			}catch(Exception e){
				e.getMessage();
			}
		//aqui abajo SIEMPRE CIERRO CONEXIONES con try
		try {
			rs.close();
			con.getConexion().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acum_jsp;
	}
	
}

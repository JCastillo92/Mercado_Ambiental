package metodos;

public class Cls_validacione_password {
	
	public boolean check_password(String p1, String p2){
		if(p1.equals("") || p2.equals("")) {
		    return false;
		  }
		  
		  if(!p1.equals("")  && p1.equals(p2)) {
		      return true;
		  }else{
		    return false;
		  }
	}

}

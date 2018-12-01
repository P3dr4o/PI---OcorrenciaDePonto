package Controller;

import java.util.ArrayList;
import Model.Funcionario;
import Model.Login;

public class LoginController {
	
	
	public static Funcionario verificaLogin(String usu, String senha) {
		ArrayList<Login> logins = getLogins();
		for (int i = 0; i < logins.size(); i++) {
			if(logins.get(i).autentica(usu, senha))
				return logins.get(i).getFuncionario();
		}
		return null;
	}
	
	public static ArrayList<Login> getLogins() {
		return new ArrayList<Login>();
	}
	

}

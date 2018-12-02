package Controller;

import java.util.ArrayList;
import Model.Funcionario;
import Model.Login;

public class LoginController {
	
	
	public static Funcionario verificaLogin(String usu, char[] senha) {
		ArrayList<Login> logins = getLogins();
		String sen = "";
		for (int i = 0; i < senha.length; i++) {
			sen = sen+senha[i];	
		}
		for (int i = 0; i < logins.size(); i++) {
			if(logins.get(i).autentica(usu, sen))
				return logins.get(i).getFuncionario();
		}
		return null;
	}
	
	public static ArrayList<Login> getLogins() {
		return new ArrayList<Login>();
	}
	

}

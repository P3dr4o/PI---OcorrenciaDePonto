package Controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import DAO.LoginDao;
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
			if(logins.get(i).autentica(usu, sen)) {
				if(usu.equals("admin"))
					return new Funcionario(0, "Administrador", 0, null, null);
				else
					return logins.get(i).getFuncionario();
			}
				
		}
		return null;
	}
	
	public static ArrayList<Login> getLogins() {
		ArrayList<Login> lo = new LoginDao().selectAllLogins();
		return (ArrayList<Login>) Objetos.cloneSerializable(lo);
	}
	
	public static boolean isExist(int id) {
		//codigo para verificar se esse id existe
		ArrayList<Login> logins = getLogins();
		for (int i = 0; i < logins.size(); i++) {
			if(logins.get(i).getIdLogin() == id)
				return true;
		}
		return false;
	}
	
	public static String getMD5(String senha) {
		if (senha != null) {
			String sen = "";
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			sen = hash.toString(16);
			return sen;
		} else
			return null;
	}

}

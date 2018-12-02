package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Login {

	private int idLogin;
	private String usuario;
	private String senha;
	private Date ultimoLogin;
	private Funcionario funcionario;

	public Login(String usuario, String senhaMD5, Funcionario funcionario) {
		setUsuario(usuario);
		this.senha = senhaMD5;
		this.funcionario = funcionario;
	}
	
	
	public boolean autentica(String usuario, String senha) {
		String sen = getMD5(senha);
		if(usuario.equals(this.usuario) && sen.equals(this.senha))
			return true;
		else
			return false;
	}
	
	
	
	public boolean mudarSenha(String usuario, String senhaAntiga, String senhaNova) {
		String senN = getMD5(senhaNova);
		if(autentica(usuario, senhaAntiga)) {
			this.senha = senN;
			return persistir();//somente retorna verdadeiro se conseguir gravar no banco de dados 
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
	
	public boolean persistir() {
		//implementar codigo para realizar a persistencia no banco de dados;
		return false;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public Date getUltimoLogin() {
		return ultimoLogin;
	}
	
	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public int getIdLogin() {
		return idLogin;
	}


	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	
	

}

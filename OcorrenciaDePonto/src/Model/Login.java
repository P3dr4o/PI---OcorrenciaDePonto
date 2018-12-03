package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import Controller.LoginController;
import DAO.LoginDao;




public class Login {

	private int idLogin;
	private String usuario;
	private String senha;
	private Funcionario funcionario;
	private Date ultimoLogin;
	private LoginDao loginDao;

	public Login(String usuario, String senhaMD5, Funcionario funcionario) {
		setUsuario(usuario);
		this.senha = senhaMD5;
		this.funcionario = funcionario;
		loginDao = new LoginDao();
	}
	
	
	public boolean autentica(String usuario, String senha) {
		String sen = LoginController.getMD5(senha);
		if(usuario.equals(this.usuario) && sen.equals(this.senha)) {
			this.ultimoLogin = new Date();//armazena o horário e data do ultimo login
			persistir();//persiste no banco de dados as informações
			return true;	
		}else
			return false;
	}
	
	
	
	public boolean mudarSenha(String usuario, String senhaAntiga, String senhaNova) {
		String senN = LoginController.getMD5(senhaNova);
		if(autentica(usuario, senhaAntiga)) {
			this.senha = senN;
			return persistir();//somente retorna verdadeiro se conseguir gravar no banco de dados 
		}
		return false;
	}
	
	
	public boolean persistir() {
		if(LoginController.isExist(this.idLogin))
			loginDao.updateLogin(this);
		else
			loginDao.createLogin(this);
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

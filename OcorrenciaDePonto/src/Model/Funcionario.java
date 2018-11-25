package Model;

import java.io.Serializable;

public class Funcionario implements Serializable{
	private int id_Funcionario;
	private String nome_Funcionario;
	private int num_Registro;
	
	private String login;
	private String senha;
	
	private Cargo cargo;
	private Setor setor;
	
	//private Apontamentos apontamentos;
	
	
	
	public Funcionario(int id_Funcionario, String nome_Funcionario, int num_Registro, Cargo Cargo, Setor setor) {
		setId_Funcionario(id_Funcionario);
		setNome_Funcionario(nome_Funcionario);
		setNum_Registro(num_Registro);
		setCargo(cargo);
		setSetor(setor);
		//apontamentos = new Apontamentos();
	}


	public boolean persistir() {
		
/*		Implementar aqui um código para comunicar 
		com a camada Dao solicitando para persistir
		os as informações deste(this) funcionário
		no banco de dados.*/
		return false;
	}


	public String getNome_Funcionario() {
		return nome_Funcionario;
	}


	public void setNome_Funcionario(String nome_Funcionario) {
		/*Aqui deve ser implementado um código,
		caso necessário, para relizar as devidas
		validações dos dados vindos do usuário*/
		this.nome_Funcionario = nome_Funcionario;
	}


	public int getNum_Registro() {
		return num_Registro;
	}


	public void setNum_Registro(int num_Registro) throws NumberFormatException {
		/*Aqui deve ser implementado um código,
		caso necessário, para relizar as devidas
		validações dos dados vindos do usuário*/
		this.num_Registro =num_Registro;
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) throws NumberFormatException {
		/*Aqui deve ser implementado um código,
		caso necessário, para relizar as devidas
		validações dos dados vindos do usuário*/
		this.cargo = cargo;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		/*Aqui deve ser implementado um código,
		caso necessário, para relizar as devidas
		validações dos dados vindos do usuário*/
		this.setor = setor;
	}


	/*public Apontamentos getApontamentos() {
		return apontamentos;
	}
*/

	/*public void setApontamentos(Apontamentos apontamentos) {
		Aqui deve ser implementado um código,
		caso necessário, para relizar as devidas
		validações dos dados vindos do usuário
		this.apontamentos = apontamentos;
	}*/


	public int getId_Funcionario() {
		return id_Funcionario;
	}


	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}

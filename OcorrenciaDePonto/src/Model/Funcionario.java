package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Funcionario implements Serializable{
	private int id_Funcionario;
	private String nome_Funcionario;
	private int num_Registro;
	
	//private String login;
	//private String senha;
	
	private Cargo cargo;
	private Setor setor;
	
	private ArrayList<Apontamento> apontamentos;
	
	public Funcionario(int id_Funcionario, String nome_Funcionario, int num_Registro, Cargo Cargo) {
		setId_Funcionario(id_Funcionario);
		setNome_Funcionario(nome_Funcionario);
		setNum_Registro(num_Registro);
		setCargo(cargo);
		//apontamentos = new Apontamentos();
	}
	
	public Funcionario(int id_Funcionario, String nome_Funcionario, int num_Registro, Cargo Cargo, Setor setor) {
		setId_Funcionario(id_Funcionario);
		setNome_Funcionario(nome_Funcionario);
		setNum_Registro(num_Registro);
		setCargo(cargo);
		setSetor(setor);
		//apontamentos = new Apontamentos();
	}


	public boolean persistir() {
		
/*		Implementar aqui um c�digo para comunicar 
		com a camada Dao solicitando para persistir
		os as informa��es deste(this) funcion�rio
		no banco de dados.*/
		return false;
	}
	
	public static boolean isExist(int id) {
		//Código para verificar se existe esse id no banco de dados
		return true;
	}
	public static ArrayList<Funcionario> getFuncionarios(){
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		//desenvolver aki codigo para buscar no banco todos os Funcionários
		return funcionarios;
	}

	public String getNome_Funcionario() {
		return nome_Funcionario;
	}


	public void setNome_Funcionario(String nome_Funcionario) {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.nome_Funcionario = nome_Funcionario;
	}


	public int getNum_Registro() {
		return num_Registro;
	}


	public void setNum_Registro(int num_Registro) throws NumberFormatException {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.num_Registro =num_Registro;
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) throws NumberFormatException {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.cargo = cargo;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.setor = setor;
	}


	/*public Apontamentos getApontamentos() {
		return apontamentos;
	}
*/

	/*public void setApontamentos(Apontamentos apontamentos) {
		Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio
		this.apontamentos = apontamentos;
	}*/


	public int getId_Funcionario() {
		return id_Funcionario;
	}


	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}


	/*public String getLogin() {
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
	*/
	
	

}

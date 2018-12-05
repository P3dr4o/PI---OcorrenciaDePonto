package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Controller.LoginController;
import Controller.SetorController;
import DAO.SetorDao;

public class Setor implements Serializable{
	
	private String nome;
	private int id_Setor;
	private Setor setorPai;
	private Funcionario funcionario;//Gestor aprovador da área
	private static SetorDao setorDAO = new SetorDao();
	
	public Setor(String nome, int id_Setor,Funcionario funcionario) {
		//Encaminhar uma exce��o caso alguns dos dados sej� inv�lido
		if(nome != null && id_Setor > 0) {
			this.nome = nome;
			this.id_Setor = id_Setor;
			this.funcionario = funcionario;
		}else {
			//reportar exce��o aqui sinalizando que existe dados erados!!
		}
		
	}
	
	public Setor(String nome, int id_Setor,Funcionario funcionario,Setor setorPai) {
		//Encaminhar uma exce��o caso alguns dos dados sej� inv�lido
		if(nome != null && id_Setor > 0) {
			this.nome = nome;
			this.id_Setor = id_Setor;
			this.setorPai = setorPai;
			this.funcionario = funcionario;
		}else {
			//reportar exce��o aqui sinalizando que existe dados erados!!
		}
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_Setor() {
		return id_Setor;
	}
	public void setId_Setor(int id_Setor) {
		this.id_Setor = id_Setor;
	}
	public Setor getSetorPai() {
		return setorPai;
	}
	public void setSetorPai(Setor setorPai) {
		this.setorPai = setorPai;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public boolean presistir() {
		if(SetorController.isExist(this.id_Setor)) {
			//chamar o update
			return setorDAO.atualizarSetor(this);
		}else {
			//insert into
			return setorDAO.createSetor(this);
		}
			
	}

}

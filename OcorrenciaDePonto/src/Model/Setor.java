package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Setor implements Serializable{
	
	private String nome;
	private int id_Setor;
	private int setorPai;
	private int id_Funcionario;//Gestor aprovador da área
	
	public Setor(String nome, int id_Setor, int id_Funcionario,int setorPai) {
		//Encaminhar uma exce��o caso alguns dos dados sej� inv�lido
		if(nome != null && id_Setor > 0) {
			this.nome = nome;
			this.id_Setor = id_Setor;
			setSetorPai(setorPai);
			setId_Funcionario(id_Funcionario);
		}else {
			//reportar exce��o aqui sinalizando que existe dados erados!!
		}
		
	}
	
	public static boolean isExist(int id) {
		//codigo para verificar se esse id existe
		return true;
	}
	public static ArrayList<Setor> getSetores(){
		ArrayList<Setor> setores = new ArrayList<Setor>();
		//Deselvolver codigo para buscar todos os setores ordenados pelo nome
		return setores;
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
	public int getSetorPai() {
		return setorPai;
	}
	public void setSetorPai(int setorPai) {
		this.setorPai = setorPai;
	}
	public int getId_Funcionario() {
		return id_Funcionario;
	}
	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}
	
	public boolean presistir() {
		//escrever codigo para salvar no banco de dados as informações
		return true;
	}

}

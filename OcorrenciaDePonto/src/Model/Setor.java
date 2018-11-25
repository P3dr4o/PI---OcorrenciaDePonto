package Model;

import java.io.Serializable;

public class Setor implements Serializable{
	
	private String nome;
	private int id_Setor;
	private Setor setorPai;
	
	public Setor(String nome, int id_Setor, Setor setorPai) {
		//Encaminhar uma exceção caso alguns dos dados sejá inválido
		if(nome != null && id_Setor > 0) {
			this.nome = nome;
			this.id_Setor = id_Setor;
			setSetorPai(setorPai);
		}else {
			//reportar exceção aqui sinalizando que existe dados erados!!
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
	
	

}

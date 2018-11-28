package Model;

import java.io.Serializable;

public class Cargo implements Serializable{
	
	private int idCargo;
	private String nomeCargo;
	
	public Cargo() {}
	
	public Cargo(int idCargo, String nomeCargo) {
		if (nomeCargo != null && idCargo > 0) {
			setNomeCargo(nomeCargo);
			setIdCargo(idCargo);
		}else {
			//reportar exce��o informando a exist�ncia de inconsist�ncia nos dados repassados
		}
		
	}
	
	public int getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(int idCargo) {
		/*Criar um c�digo que chame uma consulta no banco de dados,
		para verificar qual o nome do cargo referente ao codigo passado
		por parametro e logo depois modificar a vari�vel nomeCargo
		com o valor retornado*/
		this.idCargo = idCargo;
	}
	
	public String getNomeCargo() {
		return nomeCargo;
	}
	
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
	

}

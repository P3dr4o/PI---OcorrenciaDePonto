package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cargo implements Serializable{
	
	private int idCargo;
	private String nomeCargo;
	
	public Cargo() {}
	
	public Cargo(int idCargo, String nomeCargo) {
		//if (nomeCargo != null && idCargo > 0) {
			setNomeCargo(nomeCargo);
			this.idCargo = idCargo;
		//}else {
			//reportar exce��o informando a exist�ncia de inconsist�ncia nos dados repassados
		//}
		
	}
	
	

	@Override
	public String toString() {
		return nomeCargo;
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
	
	public static ArrayList<Cargo> getCargos(){
		ArrayList<Cargo> cargos = new ArrayList<Cargo>();
		//desenvolver aki um codigo para buscar todos os cargos
		return cargos;
	}
	
	public boolean persistir() {
		//implementar codigo para salvar o cargo no banco de dados;
		
		return true;
	}

}

package Model;

public class Cargo {
	
	private int idCargo;
	private String nomeCargo;
	
	
	public Cargo(int idCargo, String nomeCargo) {
		setNomeCargo(nomeCargo);
		setIdCargo(idCargo);
		
	}
	
	public int getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(int idCargo) {
		/*Criar um código que chame uma consulta no banco de dados,
		para verificar qual o nome do cargo referente ao coigo passado
		por parametro e logo depois modificar a variável nomeCargo
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

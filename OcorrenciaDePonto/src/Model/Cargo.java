package Model;

public class Cargo {
	
	private int idCargo;
	private String nomeCargo;
	
	
	public Cargo(int idCargo, String nomeCargo) {
		if (nomeCargo != null && idCargo > 0) {
			setNomeCargo(nomeCargo);
			setIdCargo(idCargo);
		}else {
			//reportar exceção informando a existência de inconsistência nos dados repassados
		}
		
	}
	
	public int getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(int idCargo) {
		/*Criar um código que chame uma consulta no banco de dados,
		para verificar qual o nome do cargo referente ao codigo passado
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

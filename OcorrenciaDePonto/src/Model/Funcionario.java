package Model;

public class Funcionario {
	private int id_Funcionario;
	private String nome_Funcionario;
	private int num_Registro;
	
	private Cargo cargo;
	private Setor setor;
	
	private Apontamentos apontamentos;
	
	
	
	public Funcionario(int id_Funcionario, String nome_Funcionario, String num_Registro, String idCargo, String setor) {
		setId_Funcionario(id_Funcionario);
		setNome_Funcionario(nome_Funcionario);
		setNum_Registro(num_Registro);
		this.cargo = new Cargo(Integer.parseInt(idCargo), "Chamar um c�digo aqui!");/*Chamar um c�digo para buscar o nome do cargo no banco referente a este idCargo*/
		/*
		Fazer o mesmo conceito de cargo para Setor logo abaixo
		*/
		//setSetor(setor);
		apontamentos = new Apontamentos();
	}


	public boolean persistir() {
		
/*		Implementar aqui um c�digo para comunicar 
		com a camada Dao solicitando para persistir
		os as informa��es deste(this) funcion�rio
		no banco de dados.*/
		return false;
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


	public void setNum_Registro(String num_Registro) throws NumberFormatException {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.num_Registro = Integer.parseInt(num_Registro);
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) throws NumberFormatException {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.cargo.setIdCargo(Integer.parseInt(cargo));
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


	public Apontamentos getApontamentos() {
		return apontamentos;
	}


	public void setApontamentos(Apontamentos apontamentos) {
		/*Aqui deve ser implementado um c�digo,
		caso necess�rio, para relizar as devidas
		valida��es dos dados vindos do usu�rio*/
		this.apontamentos = apontamentos;
	}


	public int getId_Funcionario() {
		return id_Funcionario;
	}


	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}

}

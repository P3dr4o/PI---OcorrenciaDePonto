package Model;

import java.util.Date;

public class OcorrenciaTrocaDePlantao extends Ocorrencia{
	
	private Funcionario FuncionarioTrocaTurno;
	private Date dataTrocaOrigem;
	private Date dataTrocaDestino;
	
	public OcorrenciaTrocaDePlantao() {
		super.tipo = 4;//define o tipo como TROCA DE PLANT�O
	}
	
	public Funcionario getFuncionarioTrocaTurno() {
		return FuncionarioTrocaTurno;
	}

	public void setFuncionarioTrocaTurno(Funcionario funcionarioTrocaTurno) {
		FuncionarioTrocaTurno = funcionarioTrocaTurno;
	}

	public Date getDataTrocaOrigem() {
		return dataTrocaOrigem;
	}

	public void setDataTrocaOrigem(Date dataTrocaOrigem) {
		this.dataTrocaOrigem = dataTrocaOrigem;
	}

	public Date getDataTrocaDestino() {
		return dataTrocaDestino;
	}

	public void setDataTrocaDestino(Date dataTrocaDestino) {
		this.dataTrocaDestino = dataTrocaDestino;
	}

	@Override
	public boolean persistir() {
		//Implementar codigo para gravar no banco
		return false;
	}

	
	
	
}

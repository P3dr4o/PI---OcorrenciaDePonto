package Model;

import java.io.Serializable;
import java.util.Date;

public class Ocorrencia implements Serializable{
	
	private int id;
	private Funcionario FuncionarioAprovador;
	private Funcionario FuncionarioSolicitante;
	
	private Date dataHora;
	private String motivo;
	//private int tipo;
	
	private Apontamento apontamento;
	private char status;
	private String observacaoGestor;
	protected int tipo;
	
	//private boolean abonado;

	
	public int getId() {
		return id;
	}
	
	public int getTipo() {
		return tipo;
	}
	public Funcionario getFuncionarioAprovador() {
		return FuncionarioAprovador;
	}
	public void setFuncionarioAprovador(Funcionario funcionarioAprovador) {
		FuncionarioAprovador = funcionarioAprovador;
	}
	public Funcionario getFuncionarioSolicitante() {
		return FuncionarioSolicitante;
	}
	public void setFuncionarioSolicitante(Funcionario funcionarioSolicitante) {
		FuncionarioSolicitante = funcionarioSolicitante;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Apontamento getApontamento() {
		return apontamento;
	}
	public void setApontamento(Apontamento apontamento) {
		this.apontamento = apontamento;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getObservacaoGestor() {
		return observacaoGestor;
	}
	public void setObservacaoGestor(String observacaoGestor) {
		this.observacaoGestor = observacaoGestor;
	}
	
	public Ocorrencia getClone() throws CloneNotSupportedException {
		return (Ocorrencia) this.clone();
	}
	

}
	

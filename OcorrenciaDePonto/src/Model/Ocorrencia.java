package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


public abstract class Ocorrencia implements Serializable{
	
	private int id;
	private Funcionario FuncionarioAprovador;
	private Funcionario FuncionarioSolicitante;
	
	private Calendar dataHora;
	private String motivo;
	//private int tipo;
	
	private Apontamento apontamento;
	private char status;
	private String observacaoGestor;
	protected int tipo;
	
	//private boolean abonado;
	
	public abstract boolean persistir(); //obriga a escrita deste metodo em todas as classe que a extendem

	public static ArrayList<Ocorrencia> getOcorrencias(int id_FuncioSolicitante){
		ArrayList<Ocorrencia> oc = new ArrayList<>();
		//implementar codigo para buscar todas as ocorrências vinculadas a um funcionario
		
		return oc;
	}
	
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
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
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
	
	

}
	

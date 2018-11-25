package Model;


import java.io.Serializable;
import java.util.Date;


public class Apontamento implements Serializable{
	
	private Date dataDoApontamento;
	private char diaSemana;
	private int id_Funcionario;
	private boolean feriado;
	
	private Date[] horaios = new Date[4];// esse vetor vai conter a informação dos horários de trabalho do funcionário. Hora de chegada, saída para almoço e retorno, e sáida
	private Date[] apontamentos = new Date[16];//esse vetor vai conter todos os registros de pontos que foram marcados pelo funcionário.
	private String observacoes;
	
	public void insereOrdenadoApontamentos() {
		//implementar codigo para inserir o apontamento de forma ordenada dentro do vetor;
	}
	
	public void insereOrdenadoHorarios() {
		//implementar codigo para inserir o horário de forma ordenada dentro do vetor;
	}
	
	
	public Date getDataDoApontamento() {
		return dataDoApontamento;
	}
	public void setDataDoApontamento(Date dataDoApontamento) {
		this.dataDoApontamento = dataDoApontamento;
	}
	public int getId_Funcionario() {
		return id_Funcionario;
	}
	public void setId_Funcionario(int id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
	}
	public boolean isFeriado() {
		return feriado;
	}
	public void setFeriado(boolean feriado) {
		this.feriado = feriado;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public char getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(char diaSemana) {
		this.diaSemana = diaSemana;
	}
}

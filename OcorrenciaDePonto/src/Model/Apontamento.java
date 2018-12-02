package Model;


import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;


public class Apontamento implements Serializable{
	
	private int idApontamento;
	private Date dataDoApontamento;
	private String diaSemana;
	private Funcionario funcionario;
	private boolean feriado;
	
	private Date[] horaios = new Date[4];// esse vetor vai conter a informa��o dos hor�rios de trabalho do funcion�rio. Hora de chegada, sa�da para almo�o e retorno, e s�ida
	private Date[] pontos = new Date[16];//esse vetor vai conter todos os registros de pontos que foram marcados pelo funcion�rio.
	private String observacoes;
	
	public void insereOrdenadoApontamentos() {
		//implementar codigo para inserir o apontamento de forma ordenada dentro do vetor;
	}
	
	public void insereOrdenadoHorarios() {
		//implementar codigo para inserir o hor�rio de forma ordenada dentro do vetor;
	}
	
	public static ArrayList<Apontamento> getApontamentos(int id_Funcionario, int mes){
		ArrayList<Apontamento> a = new ArrayList<Apontamento>();
		//implementar codigo para buscar no banco todos os apontamentos deste usuário dentro de um mês
		return a;
		
	}
	
	public Apontamento() {}
	
	public int getIdApontamento() {
		return idApontamento;
	}
	
	public void setIdApontamento(int idApontamento) {
		this.idApontamento = idApontamento;
	}
	
	public Date getDataDoApontamento() {
		return dataDoApontamento;
	}
	
	public void setDataDoApontamento(Date dataDoApontamento) {
		this.dataDoApontamento = dataDoApontamento;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public boolean isFeriado() {
		return feriado;
	}
	
	public void setFeriado(boolean feriado) {
		this.feriado = feriado;
	}
	
	public Date[] getHoraios() {
		return horaios;
	}
	
	public void setHoraios(Date[] horaios) {
		this.horaios = horaios;
	}
	
	public Date[] getPontos() {
		return pontos;
	}
	
	public void setPontos(Date[] pontos) {
		this.pontos = pontos;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getDiaSemana() {
		return diaSemana;
	}
	
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
}

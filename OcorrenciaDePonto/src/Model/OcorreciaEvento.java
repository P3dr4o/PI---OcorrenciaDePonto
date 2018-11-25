package Model;

import java.util.Date;

public class OcorreciaEvento extends Ocorrencia{
	
	private Date chegadaAntecipada;
	private Date chegadaAtrasada;
	private Date ausenteMarcacao;
	private Date saidaAntecipada;
	private boolean naoComparecimento;
	
	public OcorreciaEvento() {
		super.tipo = 1;//define o tipo com EVENTO
	}
	
	
	
	public boolean isNaoComparecimento() {
		return naoComparecimento;
	}
	public void setNaoComparecimento(boolean naoComparecimento) {
		this.naoComparecimento = naoComparecimento;
	}
	public Date getChegadaAntecipada() {
		return chegadaAntecipada;
	}
	public void setChegadaAntecipada(Date chegadaAntecipada) {
		this.chegadaAntecipada = chegadaAntecipada;
	}
	public Date getChegadaAtrasada() {
		return chegadaAtrasada;
	}
	public void setChegadaAtrasada(Date chegadaAtrasada) {
		this.chegadaAtrasada = chegadaAtrasada;
	}
	public Date getAusenteMarcacao() {
		return ausenteMarcacao;
	}
	public void setAusenteMarcacao(Date ausenteMarcacao) {
		this.ausenteMarcacao = ausenteMarcacao;
	}
	public Date getSaidaAntecipada() {
		return saidaAntecipada;
	}
	public void setSaidaAntecipada(Date saidaAntecipada) {
		this.saidaAntecipada = saidaAntecipada;
	}
	
	
	
}

package Model;

import java.util.Date;

public class Ocorrencia {
	private int id_FuncionarioAprovador;
	private int id_FuncionarioSolicitante;
	private int id_FuncionarioTrocaTurno;
	private Date dataHora;
	private String motivo;
	private int tipo;
	
	private Apontamento apontamento;
	private char status;
	private String observacaoGestor;
	private boolean abonado;
	private int tipoSolicitacao;// 1-Folga extra, 2-Hora extra, 3-troca de plant�o
	
	private Date chegadaAntecipada;
	private Date chegadaAtrasada;
	private Date ausenteMarcacao;
	private Date saidaAntecipada;
	private 
	
	//Criar ocorr�ncias com eran�a, criando uma ocorr�ncia m�e com caracteristicas comuns a todas as ocorr�ncias, 
	//e outras para cada tipo de ocorr�ncia, tendo cada uma as suas caracteristicas adicionais e seus contrutores

}
	

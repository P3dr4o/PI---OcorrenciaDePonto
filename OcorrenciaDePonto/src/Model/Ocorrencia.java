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
	private int tipoSolicitacao;// 1-Folga extra, 2-Hora extra, 3-troca de plantão
	
	private Date chegadaAntecipada;
	private Date chegadaAtrasada;
	private Date ausenteMarcacao;
	private Date saidaAntecipada;
	private 
	
	//Criar ocorrências com erança, criando uma ocorrência mãe com caracteristicas comuns a todas as ocorrências, 
	//e outras para cada tipo de ocorrência, tendo cada uma as suas caracteristicas adicionais e seus contrutores

}
	

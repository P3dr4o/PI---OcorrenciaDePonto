package Model;

import java.util.Date;

public class Ocorrencia {
	private int id_FuncionarioAprovador;
	private int id_FuncionarioSolicitante;
	private Date dataHora;
	private String motivo;
	private int tipo;
	
	private Apontamento apontamento;
	private char status;
	private String observacaoGestor;
	private boolean abonado;
	

}
	

package Controller;

import java.util.ArrayList;

import Model.Ocorrencia;

public class OcorrenciaControler {
	
	public static void salvarOcorrencia(Ocorrencia o) { //mudar esse codigo, quem deve chamar codigo para persistência no banco é o Model

		/*Ocorrencia ocorrencia = (Ocorrencia) Objetos.cloneSerializable(o);
		 * 
		 * 
		String query = ocorrencia.getId() + " ," + ocorrencia.getTipo() + " ," + ocorrencia.getStatus() + " ,"
				+ ocorrencia.getDataHora() + " ," + ocorrencia.getApontamento().getDataDoApontamento() + " ,"
				+ ocorrencia.getFuncionarioSolicitante().getId_Funcionario() + " ,"
				+ ocorrencia.getFuncionarioAprovador().getId_Funcionario() + " ," + ocorrencia.getMotivo() + " ,"
				+ ocorrencia.getObservacaoGestor();

		switch (ocorrencia.getTipo()) {
		case 1:
			OcorreciaEvento ocE = (OcorreciaEvento) ocorrencia;
			query = query + " ," + ocE.getChegadaAntecipada() + " ," + ocE.getChegadaAtrasada() + " ,"
					+ ocE.getAusenteMarcacao() + " ," + ocE.getSaidaAntecipada() + " ," + ocE.isNaoComparecimento();
			break;
		case 2:
			OcorrenciaFolgaExtra ocF = (OcorrenciaFolgaExtra) ocorrencia;
			query = query+" ,"+ocF.get
			break;
		case 3:
			OcorrenciaHoraExtra ocH = (OcorrenciaHoraExtra) ocorrencia;
			break;
		case 4:
			OcorrenciaTrocaDePlantao ocT = (OcorrenciaTrocaDePlantao) ocorrencia;

			break;

		default:
			break;
		}*/
	}
	
	
	public static ArrayList<String[]> getOcorrencias(){
		//analisar se devemos realmente realizar e buscar a persistencia dos objetos de ocorrência de modo genérico, e dpois separar
	}
}

package Controller;

import java.util.zip.DataFormatException;

import Model.Funcionario;
import Model.OcorreciaEvento;
import Model.Ocorrencia;
import Model.OcorrenciaFolgaExtra;
import Model.OcorrenciaHoraExtra;
import Model.OcorrenciaTrocaDePlantao;
import Model.Setor;

public class FuncionarioController {

	public static void salvarFuncionário(Funcionario f) throws DataFormatException {
		Funcionario funcionario = (Funcionario) Objetos.cloneSerializable(f);
		// chamar uma função das classes em DAO para realizar a persitencia de dados no
		// banco
	}

	public static void salvarSetor(Setor s) {
		Setor setor = (Setor) Objetos.cloneSerializable(s);
		// chamar uma função para realizar a persistencia
	}

	public static void slavarOcorrencia(Ocorrencia o) {
		Ocorrencia ocorrencia = (Ocorrencia) Objetos.cloneSerializable(o);
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
		}
	}

}

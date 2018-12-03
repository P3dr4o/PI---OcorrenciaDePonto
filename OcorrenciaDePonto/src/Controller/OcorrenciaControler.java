package Controller;

import java.util.ArrayList;

import Model.OcorrenciaEvento;
import Model.Ocorrencia;
import Model.OcorrenciaFolgaExtra;
import Model.OcorrenciaHoraExtra;
import Model.OcorrenciaTrocaDePlantao;

public class OcorrenciaControler {
	
	public static void salvarOcorrencia(Ocorrencia o) { 
		//Nesse codigo copiamos o objeto ocorrência para evitar referencia com outros objetos
		//logo após buscamos qual é o tipo de ocorrência pra logo em seguida chamar o seu metodo de persistencia
		Ocorrencia ocorrencia = (Ocorrencia) Objetos.cloneSerializable(o);
		switch (ocorrencia.getTipo()) {
		case 1:
			OcorrenciaEvento ocE = (OcorrenciaEvento) ocorrencia;
			ocE.persistir();
			break;
		case 2:
			OcorrenciaFolgaExtra ocF = (OcorrenciaFolgaExtra) ocorrencia;
			ocF.persistir();
			break;
		case 3:
			OcorrenciaHoraExtra ocH = (OcorrenciaHoraExtra) ocorrencia;
			ocH.persistir();
			break;
		case 4:
			OcorrenciaTrocaDePlantao ocT = (OcorrenciaTrocaDePlantao) ocorrencia;
			ocT.persistir();
			break;

		default:
			break;
		}
	}
	
	
	public static ArrayList<Ocorrencia> getOcorrencias(int id_FuncioSolicitante){
		//neste codigo realizamos uma cópia do objeto passado por parametro para evitar modificação de informação por outra camada
		ArrayList<Ocorrencia> oc = Ocorrencia.getOcorrencias(id_FuncioSolicitante);
		ArrayList<Ocorrencia> ocorrencias = (ArrayList<Ocorrencia>)Objetos.cloneSerializable(oc);
		return ocorrencias;
	}
}

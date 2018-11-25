package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Controller.Objetos;

public class Backlog implements Serializable{
	//est� classe vai receber as ocorr�ncias de ponto que devem ser validadas pelos aprovadores(todos)
	//cada aprovador deve montar sua tabela de ordens a serem aprovadas buscando apenas as ocorr�ncias relacionadas a ele
	
	private ArrayList<Ocorrencia> ocorrencias;
	
	public Backlog() {
		ocorrencias = new ArrayList<>();
	}
	
	public void addOcorrencia(Ocorrencia oc) {
		//retornar uma exce��o caso n�oconsiga adicionar
		ocorrencias.add(oc);
		//implementar algoritimo para adicionar de forma ordenada
	}
	
	public Ocorrencia getOcorrencia(int idOcorrencia) {
		for (int i = 0; i < ocorrencias.size(); i++) {
			Ocorrencia o = ocorrencias.get(i);
			if (o.getId()==idOcorrencia)
				return o;	
		}
		return null;
	}
	
	public ArrayList<Ocorrencia> getOcorrencias(){
			ArrayList<Ocorrencia> clone = (ArrayList<Ocorrencia>) Objetos.cloneSerializable(ocorrencias);
			return clone;
	}
}

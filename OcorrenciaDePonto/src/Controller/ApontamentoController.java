package Controller;

import java.util.ArrayList;
import java.util.zip.DataFormatException;

import javax.activity.InvalidActivityException;

import Model.Apontamento;

public class ApontamentoController {
	
	public static boolean salvarApontamento(Apontamento a) throws DataFormatException {
		//implementar código somente se necessário para salvar o apontamento
		//não vejo necessidade, já que o apontamento vai ser sempre atualizado com o banco MULTBANCO (registros de pontos do hospital)
		throw new DataFormatException("Favor implementar o codigo na Classe Apontamento, função 'salvarApontamento()' linha 12");
		//return true;
	}
	
	public static ArrayList<Apontamento> getApontamentos(int id_Funcionario, int mes){
		ArrayList<Apontamento> a = Apontamento.getApontamentos(id_Funcionario, mes);
		ArrayList<Apontamento> apontamentos = (ArrayList<Apontamento>) Objetos.cloneSerializable(a);
		//*Está linha realiza uma cópia do objeto para ser repassado a camada acima, para não comprometer os dados nessa camada
		return apontamentos;
	}

}

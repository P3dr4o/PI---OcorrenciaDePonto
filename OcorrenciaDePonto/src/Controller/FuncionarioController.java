package Controller;

import org.omg.CORBA.IdentifierHelper;

import Model.Cargo;
import Model.Funcionario;

public class FuncionarioController {
	
	public static void salvarFuncion�rio(int idFuncionario,String nome, String registro, String idcargo, String idsetor) {
		Funcionario f = new Funcionario(idFuncionario, nome, registro, idcargo, idsetor);


		
	}

}

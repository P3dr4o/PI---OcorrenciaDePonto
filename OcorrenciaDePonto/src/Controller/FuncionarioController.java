package Controller;

import java.util.ArrayList;
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

	
	public static ArrayList<Funcionario> getFuncionarios() {
		ArrayList<Funcionario> fs = Funcionario.getFuncionarios();
		ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) Objetos.cloneSerializable(fs);
		return funcionarios;
	}

	/*public static boolean verificaLogin(String usu, String senha) {
		ArrayList<String[]> funcionarios = getFuncionarios();
		for (int i = 0; i < funcionarios.size(); i++) {
			String[] a = funcionarios.get(i);
			if(a[5].equalsIgnoreCase(usu) && a[6].equals(senha))
				return true;
		}
		return false;
	}*/
}

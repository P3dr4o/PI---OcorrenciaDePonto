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

	
	public static ArrayList<String[]> getFuncionarios() {
		ArrayList<Funcionario> fs = Funcionario.getFuncionarios();
		ArrayList<String[]> funcionarios = new ArrayList<String[]>();
		
		for (int i = 0; i < fs.size(); i++) {
			String[] a = new String[7];
			Funcionario f = fs.get(i);
			a[0] = Integer.toString(f.getId_Funcionario());
			a[1] = f.getNome_Funcionario();
			a[2] = Integer.toString(f.getCargo().getIdCargo());
			a[3] = Integer.toString(f.getSetor().getId_Setor());
			a[4] = Integer.toString(f.getNum_Registro());
			a[5] = f.getLogin();
			a[6] = f.getSenha();
			funcionarios.add(a);
		}
		return funcionarios;
	}

	public static boolean verificaLogin(String usu, String senha) {
		ArrayList<String[]> funcionarios = getFuncionarios();
		for (int i = 0; i < funcionarios.size(); i++) {
			String[] a = funcionarios.get(i);
			if(a[5].equalsIgnoreCase(usu) && a[6].equals(senha))
				return true;
		}
		return false;
	}
}

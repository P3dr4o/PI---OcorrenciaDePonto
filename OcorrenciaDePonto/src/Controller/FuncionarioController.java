package Controller;

import java.util.ArrayList;
import java.util.zip.DataFormatException;

import DAO.FuncionarioDao;
import DAO.LoginDao;
import Model.Funcionario;
import Model.OcorrenciaEvento;
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
		ArrayList<Funcionario> fs = new FuncionarioDao().selectAllFuncionarios();
		//ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) Objetos.cloneSerializable(fs);
		return fs;
	}

	public static Funcionario getFuncionario(int idFuncionario) {
		ArrayList<Funcionario> funcionarios = getFuncionarios();
		for (int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getId_Funcionario() == idFuncionario)
				return funcionarios.get(i);
		}
		return null;
	}
	
	public static boolean removeFuncionario(int numRegistro) {
		for(Funcionario f : getFuncionarios()) {
			if(f.getNum_Registro() == numRegistro) {
				return LoginDao.deleteLogin(f.getLogin().getIdLogin()) && FuncionarioDao.deleteFuncionario(f.getId_Funcionario());
			}
		}
		return false;
	}
}

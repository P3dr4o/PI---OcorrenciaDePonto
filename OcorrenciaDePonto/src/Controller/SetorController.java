package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import DAO.SetorDao;
import Model.Funcionario;
import Model.Setor;

public class SetorController {
	public static boolean salvarSetor(String nome, Integer id_Setor, Funcionario funcionarioAprovador, Setor setorPai) {
		Setor s = new Setor(nome, id_Setor, funcionarioAprovador, setorPai);
		//if(funcionarioAprovador.getId_Funcionario()  > 0 && setorPai.getId_Setor() > 0) {
				return s.presistir();
		//}else {
		//		return false;
		//}
	}
	
	public static boolean isExist(int id) {
		//codigo para verificar se esse id existe
		ArrayList<Setor> setores = getSetores();
		for (int i = 0; i < setores.size(); i++) {
			if(setores.get(i).getId_Setor() == id)
				return true;
		}
		return false;
	}
	
	public static ArrayList<Setor> getSetores(){
		
		ArrayList<Setor> S = new SetorDao().selectAllSetores();
		ArrayList<Setor> setores = (ArrayList<Setor>) Objetos.cloneSerializable(S); 
		
		return S;//setores;
	}
	
	public static boolean excluirSetor(int id) {
		return new SetorDao().deleteSetor(id);
	}

}

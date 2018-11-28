package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Funcionario;
import Model.Setor;

public class SetorController {
	public static boolean salvarSetor(String nome,int id_Setor, Funcionario funcionarioAprovador, Setor setorPai) {
		Setor s = new Setor(nome, id_Setor, funcionarioAprovador, setorPai);
		if(funcionarioAprovador.getId_Funcionario()  > 0 && setorPai.getId_Setor() > 0) {
				return s.presistir();
		}else {
				return false;
		}
	}
	
	public static ArrayList<Setor> getSetores(){
		
		ArrayList<Setor> S = Setor.getSetores();
		ArrayList<Setor> setores = (ArrayList<Setor>) Objetos.cloneSerializable(S); 
		
		return setores;
	}

}

package Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Funcionario;
import Model.Setor;

public class SetorController {
	public static boolean salvarSetor(String nome,int id_Setor, int id_Funcioanrio, int setorPai) {
		Setor s = new Setor(nome, id_Setor, id_Funcioanrio, setorPai);
		if(id_Funcioanrio  > 0 && setorPai > 0) {
			if (Funcionario.isExist(id_Funcioanrio) && Setor.isExist(setorPai))
				return s.presistir();
			else
				return false;
		}else {
			if(Funcionario.isExist(id_Funcioanrio))
					return s.presistir();
			else
				return false;
		}
	}
	
	public static ArrayList<String[]> getSetores(){
		ArrayList<String[]> setores = new ArrayList<String[]>();
		ArrayList<Setor> S = Setor.getSetores();
		
		for (int i = 0; i < S.size(); i++) {
			String[] a = new String[4];
			a[0] = Integer.toString(S.get(i).getId_Setor());
			a[1] = S.get(i).getNome();
			a[2] = Integer.toString(S.get(i).getId_Funcionario());
			a[3] = Integer.toString(S.get(i).getSetorPai());
			setores.add(a);
		}
		return setores;
	}

}

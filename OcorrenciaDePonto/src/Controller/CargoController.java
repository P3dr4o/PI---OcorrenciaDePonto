package Controller;

import java.util.ArrayList;

import DAO.CargoDao;
import Model.Cargo;

public class CargoController {
	
	public static boolean salvarCargo(String nome_Cargo){
		//int id_Cargo = Integer.parseInt(id);//tratar o erro que eventualmente pode acontecer nessa conversão
		int id_Cargo = CargoDao.gerarMaxID();
		Cargo c = new Cargo(id_Cargo, nome_Cargo);
		//return c.persistir();
		return new CargoDao().createCargo(c);
	}
	
	public static boolean excluirCargo(int id) {
		return new CargoDao().deleteCargo(id);
	}
	
	public static boolean alterarCargo(int id, String nome) {
		Cargo cargo = new Cargo(id, nome);
		return new CargoDao().updateCargo(cargo);
	}
	
	public ArrayList<String[]> getCargos(){
		ArrayList<Cargo> c = Cargo.getCargos();
		ArrayList<String[]> cargos = new ArrayList<String[]>();
		for (int i = 0; i < c.size(); i++) {
			String[] t = new String[2];
			t[0] = Integer.toString(c.get(i).getIdCargo());
			t[1] = c.get(i).getNomeCargo();
			cargos.add(t);
		}
		return cargos;
	}
	
}

package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import DAO.CargoDao;
import Model.Cargo;
import Model.Funcionario;
import Model.Login;
import Model.OcorrenciaEvento;
import Model.Ocorrencia;
import Model.OcorrenciaHoraExtra;
import Model.Setor;

public class teste {
	public static void main(String[] args) {
		//System.out.println("teste");
		
		/*OcorreciaEvento o1 = new OcorreciaEvento();
		o1.setMotivo("Original1");
		o1.setFuncionarioAprovador(new Funcionario(1, "Pedro", 1911, new Cargo(1, "Coordenador"), new Setor("TI", 2, null)));
		OcorrenciaHoraExtra o2 = new OcorrenciaHoraExtra();
		o2.setFuncionarioAprovador(new Funcionario(2, "Juliano", 1916, new Cargo(2, "Tecnico"), new Setor("TI", 2, null)));
		o2.setMotivo("Original2");
		
		ArrayList<Ocorrencia> ocs = new ArrayList<Ocorrencia>();
		ocs.add(o1);
		ocs.add(o2);
		
		ArrayList<Ocorrencia>ocsTemp = (ArrayList<Ocorrencia>) Objetos.cloneSerializable(ocs);
		ocsTemp.get(0).setMotivo("Copia1");
		ocsTemp.get(1).setMotivo("Copia2");
		ocsTemp.get(0).getFuncionarioAprovador().setNome_Funcionario("Keith");
		
		System.out.println(ocs.get(0).getMotivo()+"  "+ocs.get(1).getMotivo());
		System.out.println(ocsTemp.get(0).getMotivo()+"  "+ocsTemp.get(1).getMotivo());
		System.out.println(ocs.get(0).getFuncionarioAprovador().getNome_Funcionario());
		System.out.println(ocsTemp.get(0).getFuncionarioAprovador().getNome_Funcionario());*/
		
		
		//GregorianCalendar gc = new GregorianCalendar();
		//SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println(gc);
		//JOptionPane.showMessageDialog(null, "Teste", "teste", JOptionPane.INFORMATION_MESSAGE);
		//System.out.println(gc);
		
		//String senha = "admin";
		//System.out.println(LoginController.getMD5(senha));
		//Login login = new Login("admin", LoginController.getMD5(senha), new Funcionario(0, "Administrador", 0, null, null));
		//login.persistir();
		
		//teste
		CargoDao cd = new CargoDao();
		Cargo c = new Cargo();
		c.setIdCargo(2);
		c.setNomeCargo("teste2");
		cd.createCargo(c);
	}
}

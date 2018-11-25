package Controller;

import java.util.ArrayList;

import Model.Cargo;
import Model.Funcionario;
import Model.OcorreciaEvento;
import Model.Ocorrencia;
import Model.OcorrenciaHoraExtra;
import Model.Setor;

public class teste {
	public static void main(String[] args) {
		//System.out.println("teste");
		
		OcorreciaEvento o1 = new OcorreciaEvento();
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
		System.out.println(ocsTemp.get(0).getFuncionarioAprovador().getNome_Funcionario());
	}
}

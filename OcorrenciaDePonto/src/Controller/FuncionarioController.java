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

	public static void salvarSetor(Setor s) {
		Setor setor = (Setor) Objetos.cloneSerializable(s);
		// chamar uma função para realizar a persistencia
	}

	public static void salvarOcorrencia(Ocorrencia o) { //mudar esse codigo, quem deve chamar codigo para persistência no banco é o Model
		/*Ocorrencia ocorrencia = (Ocorrencia) Objetos.cloneSerializable(o);
		String query = ocorrencia.getId() + " ," + ocorrencia.getTipo() + " ," + ocorrencia.getStatus() + " ,"
				+ ocorrencia.getDataHora() + " ," + ocorrencia.getApontamento().getDataDoApontamento() + " ,"
				+ ocorrencia.getFuncionarioSolicitante().getId_Funcionario() + " ,"
				+ ocorrencia.getFuncionarioAprovador().getId_Funcionario() + " ," + ocorrencia.getMotivo() + " ,"
				+ ocorrencia.getObservacaoGestor();

		switch (ocorrencia.getTipo()) {
		case 1:
			OcorreciaEvento ocE = (OcorreciaEvento) ocorrencia;
			query = query + " ," + ocE.getChegadaAntecipada() + " ," + ocE.getChegadaAtrasada() + " ,"
					+ ocE.getAusenteMarcacao() + " ," + ocE.getSaidaAntecipada() + " ," + ocE.isNaoComparecimento();
			break;
		case 2:
			OcorrenciaFolgaExtra ocF = (OcorrenciaFolgaExtra) ocorrencia;
			query = query+" ,"+ocF.get
			break;
		case 3:
			OcorrenciaHoraExtra ocH = (OcorrenciaHoraExtra) ocorrencia;
			break;
		case 4:
			OcorrenciaTrocaDePlantao ocT = (OcorrenciaTrocaDePlantao) ocorrencia;

			break;

		default:
			break;
		}*/
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


}

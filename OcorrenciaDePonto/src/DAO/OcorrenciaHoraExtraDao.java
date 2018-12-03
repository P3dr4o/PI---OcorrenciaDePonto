package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Conexao.ConexaoBD;
import Model.OcorrenciaHoraExtra;

public class OcorrenciaHoraExtraDao {
	
	private static Connection con = ConexaoBD.getConnection();;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//metodo para selecionar todas as OcorrenciasHoraExtra
	public ArrayList<OcorrenciaHoraExtra> selectAllOcorrenciaHoraExtra() {
		String sql = "SELECT * FROM ocorrencia";
		ArrayList<OcorrenciaHoraExtra> listOcorrenciaHoraExtra = new ArrayList<>();
		OcorrenciaHoraExtra ohe = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ohe = new OcorrenciaHoraExtra();
				ohe.setId(rs.getInt("idOcorrencia"));
				ohe.setDataHora(rs.getTimestamp("dataHora"));
				ohe.setMotivo(rs.getString("motivo"));
				ohe.setStatus(rs.getString("status").charAt(0));
				ohe.setObservacaoGestor(rs.getString("observacoesGerente"));
				ohe.setTipo(rs.getInt("tipo"));
				ohe.setApontamento(ApontamentoDao.selectApontamento(rs.getInt("idApontamento")));
				ohe.setFuncionarioSolicitante(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioSolicitante")));
				ohe.setFuncionarioAprovador(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioAprovador")));
				ohe.setHorasExtras(rs.getTime("horasExtra"));

				listOcorrenciaHoraExtra.add(ohe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listOcorrenciaHoraExtra;
	}
	
	//metodo para selecionar ocorrencia especifica pesquisando pelo id
	public static OcorrenciaHoraExtra selectOcorrenciaHoraExtra(int idOcorrenciaHoraExtra) {
		String sql = "SELECT * FROM ocorrencia WHERE idOcorrencia = ?";
		OcorrenciaHoraExtra ohe = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idOcorrenciaHoraExtra);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				ohe = new OcorrenciaHoraExtra();
				ohe.setId(rs.getInt("idOcorrencia"));
				ohe.setDataHora(rs.getTimestamp("dataHora"));
				ohe.setMotivo(rs.getString("motivo"));
				ohe.setStatus(rs.getString("status").charAt(0));
				ohe.setObservacaoGestor(rs.getString("observacoesGerente"));
				ohe.setTipo(rs.getInt("tipo"));
				ohe.setApontamento(ApontamentoDao.selectApontamento(rs.getInt("idApontamento")));
				ohe.setFuncionarioSolicitante(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioSolicitante")));
				ohe.setFuncionarioAprovador(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioAprovador")));
				ohe.setHorasExtras(rs.getTime("horasExtra"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ohe;
	}
	
	//metodo para criar nova OcorrenciaHoraExtra
	public boolean createOcorrenciaHoraExtra(OcorrenciaHoraExtra ocorrenciaHoraExtra) {
		String sql = "INSERT INTO ocorrencia(idOcorrencia, dataHora, motivo, status, observacoesGerente, tipo, idApontamento, "
				+ "idFuncionarioSolicitante, idFuncionarioAprovador, horasExtra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ocorrenciaHoraExtra.getId());
			stmt.setTimestamp(2, new Timestamp(ocorrenciaHoraExtra.getDataHora().getTime()));
			stmt.setString(3, ocorrenciaHoraExtra.getMotivo());
			stmt.setString(4, String.valueOf(ocorrenciaHoraExtra.getStatus()));
			stmt.setString(5, ocorrenciaHoraExtra.getObservacaoGestor());
			stmt.setInt(6, ocorrenciaHoraExtra.getTipo());
			stmt.setInt(7, ocorrenciaHoraExtra.getApontamento().getIdApontamento());
			stmt.setInt(8, ocorrenciaHoraExtra.getFuncionarioSolicitante().getId_Funcionario());
			stmt.setInt(9, ocorrenciaHoraExtra.getFuncionarioAprovador().getId_Funcionario());
			stmt.setDate(10, new Date(ocorrenciaHoraExtra.getHorasExtras().getTime()));
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para atualizar uma OcorrenciaHoraExtra
	public boolean updateOcorrenciaHoraExtra(OcorrenciaHoraExtra ocorrenciaHoraExtra) {
		String sql = "UPDATE ocorrencia SET motivo = ?, observacoesGerente = ?, tipo = ?, dataFolga = ? WHERE idOcorrencia = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ocorrenciaHoraExtra.getMotivo());
			stmt.setString(2, ocorrenciaHoraExtra.getObservacaoGestor());
			stmt.setInt(3, ocorrenciaHoraExtra.getTipo());
			stmt.setDate(4, new Date(ocorrenciaHoraExtra.getHorasExtras().getTime()));
			stmt.setInt(5, ocorrenciaHoraExtra.getId());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para excluir uma OcorrenciaHoraExtra
	public boolean deleteOcorrenciaHoraExtra(OcorrenciaHoraExtra ocorrenciaHoraExtra) {
		String sql = "DELETE FROM ocorrencia WHERE idOcorrencia = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ocorrenciaHoraExtra.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para retornar o maior ID possivel para ser inserido na tabela
	public int gerarMaxID() {
		String sql = "SELECT max(idOcorrencia) AS maior FROM ocorrencia";
		int max = 0;
		try {
			stmt = con.prepareStatement(sql);
		    rs = stmt.executeQuery();
		    if (rs.next()) {
		    	max = rs.getInt("maior") + 1;
		    }
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar ID", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return max;
	}


}

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
import Model.OcorrenciaEvento;

public class OcorrenciaEventoDao {
	
	private static Connection con = ConexaoBD.getConnection();;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//metodo para selecionar todos os cargos
	public ArrayList<OcorrenciaEvento> selectAllOcorrenciaEvento() {
		String sql = "SELECT * FROM ocorrencia";
		ArrayList<OcorrenciaEvento> listOcorrenciaEvento = new ArrayList<>();
		OcorrenciaEvento oe = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				oe = new OcorrenciaEvento();
				oe.setId(rs.getInt("idOcorrencia"));
				oe.setDataHora(rs.getTimestamp("dataHora"));
				oe.setMotivo(rs.getString("motivo"));
				oe.setStatus(rs.getString("status").charAt(0));
				oe.setObservacaoGestor(rs.getString("observacoesGerente"));
				oe.setTipo(rs.getInt("tipo"));
				oe.setApontamento(ApontamentoDao.selectApontamento(rs.getInt("idApontamento")));
				oe.setFuncionarioSolicitante(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioSolicitante")));
				oe.setFuncionarioAprovador(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioAprovador")));
				oe.setChegadaAntecipada(rs.getTimestamp("chegadaAntecipada"));
				oe.setChegadaAtrasada(rs.getTimestamp("chegadaAtrasada"));
				oe.setAusenteMarcacao(rs.getTimestamp("ausenteMarcacao"));
				oe.setSaidaAntecipada(rs.getTimestamp("saidaAntecipada"));
				oe.setNaoComparecimento(rs.getDate("naoComparecimento"));
				listOcorrenciaEvento.add(oe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listOcorrenciaEvento;
	}
	
	//metodo para selecionar ocorrencia especific pesquisando pelo id
	public static OcorrenciaEvento selectOcorrenciaEvento(int idOcorrenciaEvento) {
		String sql = "SELECT * FROM ocorrencia WHERE idOcorrencia = ?";
		OcorrenciaEvento oe = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idOcorrenciaEvento);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				oe = new OcorrenciaEvento();
				oe.setId(rs.getInt("idOcorrencia"));
				oe.setDataHora(rs.getTimestamp("dataHora"));
				oe.setMotivo(rs.getString("motivo"));
				oe.setStatus(rs.getString("status").charAt(0));
				oe.setObservacaoGestor(rs.getString("observacoesGerente"));
				oe.setTipo(rs.getInt("tipo"));
				oe.setApontamento(ApontamentoDao.selectApontamento(rs.getInt("idApontamento")));
				oe.setFuncionarioSolicitante(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioSolicitante")));
				oe.setFuncionarioAprovador(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioAprovador")));
				oe.setChegadaAntecipada(rs.getTimestamp("chegadaAntecipada"));
				oe.setChegadaAtrasada(rs.getTimestamp("chegadaAtrasada"));
				oe.setAusenteMarcacao(rs.getTimestamp("ausenteMarcacao"));
				oe.setSaidaAntecipada(rs.getTimestamp("saidaAntecipada"));
				oe.setNaoComparecimento(rs.getDate("naoComparecimento"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return oe;
	}
	
	//metodo para criar nova OcorrenciaEvento
	public boolean createOcorrenciaEvento(OcorrenciaEvento ocorrenciaEvento) {
		String sql = "INSERT INTO ocorrencia(idOcorrencia, dataHora, motivo, status, observacoesGerente, tipo, idApontamento, idFuncionarioSolicitante, "
				+ "idFuncionarioAprovador, chegadaAntecipada, chegadaAtrasada, ausenteMarcacao, saidaAntecipada, naoComparecimento) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ocorrenciaEvento.getId());
			stmt.setTimestamp(2, new Timestamp(ocorrenciaEvento.getDataHora().getTime()));
			stmt.setString(3, ocorrenciaEvento.getMotivo());
			stmt.setString(4, String.valueOf(ocorrenciaEvento.getStatus()));
			stmt.setString(5, ocorrenciaEvento.getObservacaoGestor());
			stmt.setInt(6, ocorrenciaEvento.getTipo());
			stmt.setInt(7, ocorrenciaEvento.getApontamento().getIdApontamento());
			stmt.setInt(8, ocorrenciaEvento.getFuncionarioSolicitante().getId_Funcionario());
			stmt.setInt(9, ocorrenciaEvento.getFuncionarioAprovador().getId_Funcionario());
			stmt.setTimestamp(10, new Timestamp(ocorrenciaEvento.getChegadaAntecipada().getTime()));
			stmt.setTimestamp(11, new Timestamp(ocorrenciaEvento.getChegadaAtrasada().getTime()));
			stmt.setTimestamp(12, new Timestamp(ocorrenciaEvento.getAusenteMarcacao().getTime()));
			stmt.setTimestamp(13, new Timestamp(ocorrenciaEvento.getSaidaAntecipada().getTime()));
			stmt.setDate(14, new Date(ocorrenciaEvento.getNaoComparecimento().getTime()));
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para atualizar uma ocorrenciaEvento
	public boolean updateCargo(OcorrenciaEvento ocorrenciaEvento) {
		String sql = "UPDATE ocorrencia SET motivo = ?, observacoesGerente = ?, tipo = ?, chegadaAntecipada = ?, chegadaAtrasada = ?, "
				+ "ausenteMarcacao = ?, saidaAntecipada = ?, naoComparecimento = ? WHERE idOcorrencia = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ocorrenciaEvento.getMotivo());
			stmt.setString(2, ocorrenciaEvento.getObservacaoGestor());
			stmt.setInt(3, ocorrenciaEvento.getTipo());
			stmt.setTimestamp(4, new Timestamp(ocorrenciaEvento.getChegadaAntecipada().getTime()));
			stmt.setTimestamp(5, new Timestamp(ocorrenciaEvento.getChegadaAtrasada().getTime()));
			stmt.setTimestamp(6, new Timestamp(ocorrenciaEvento.getAusenteMarcacao().getTime()));
			stmt.setTimestamp(7, new Timestamp(ocorrenciaEvento.getSaidaAntecipada().getTime()));
			stmt.setDate(8, new Date(ocorrenciaEvento.getNaoComparecimento().getTime()));
			stmt.setInt(9, ocorrenciaEvento.getId());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para excluir uma ocorrenciaEvento
	public boolean deleteOcorrenciaEvento(OcorrenciaEvento ocorrenciaEvento) {
		String sql = "DELETE FROM ocorrencia WHERE idOcorrencia = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ocorrenciaEvento.getId());
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

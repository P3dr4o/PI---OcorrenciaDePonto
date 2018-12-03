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
import Model.OcorrenciaFolgaExtra;

public class OcorrenciaFolgaExtraDao {

	
	private static Connection con = ConexaoBD.getConnection();;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//metodo para selecionar todos os cargos
	public ArrayList<OcorrenciaFolgaExtra> selectAllOcorrenciaFolgaExtra() {
		String sql = "SELECT * FROM ocorrencia";
		ArrayList<OcorrenciaFolgaExtra> listOcorrenciaFolgaExtra = new ArrayList<>();
		OcorrenciaFolgaExtra ofe = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ofe = new OcorrenciaFolgaExtra();
				ofe.setId(rs.getInt("idOcorrencia"));
				ofe.setDataHora(rs.getTimestamp("dataHora"));
				ofe.setMotivo(rs.getString("motivo"));
				ofe.setStatus(rs.getString("status").charAt(0));
				ofe.setObservacaoGestor(rs.getString("observacoesGerente"));
				ofe.setTipo(rs.getInt("tipo"));
				ofe.setApontamento(ApontamentoDao.selectApontamento(rs.getInt("idApontamento")));
				ofe.setFuncionarioSolicitante(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioSolicitante")));
				ofe.setFuncionarioAprovador(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioAprovador")));
				ofe.setDataFolga(rs.getDate("dataFolga"));

				listOcorrenciaFolgaExtra.add(ofe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listOcorrenciaFolgaExtra;
	}
	
	//metodo para selecionar ocorrencia especific pesquisando pelo id
	public static OcorrenciaFolgaExtra selectOcorrenciaFolgaExtra(int idOcorrenciaFolgaExtra) {
		String sql = "SELECT * FROM ocorrencia WHERE idOcorrencia = ?";
		OcorrenciaFolgaExtra ofe = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idOcorrenciaFolgaExtra);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				ofe = new OcorrenciaFolgaExtra();
				ofe.setId(rs.getInt("idOcorrencia"));
				ofe.setDataHora(rs.getTimestamp("dataHora"));
				ofe.setMotivo(rs.getString("motivo"));
				ofe.setStatus(rs.getString("status").charAt(0));
				ofe.setObservacaoGestor(rs.getString("observacoesGerente"));
				ofe.setTipo(rs.getInt("tipo"));
				ofe.setApontamento(ApontamentoDao.selectApontamento(rs.getInt("idApontamento")));
				ofe.setFuncionarioSolicitante(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioSolicitante")));
				ofe.setFuncionarioAprovador(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionarioAprovador")));
				ofe.setDataFolga(rs.getDate("dataFolga"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ofe;
	}
	
	//metodo para criar nova OcorrenciaEvento
	public boolean createOcorrenciaFolgaExtra(OcorrenciaFolgaExtra ocorrenciaFolgaExtra) {
		String sql = "INSERT INTO ocorrencia(idOcorrencia, dataHora, motivo, status, observacoesGerente, tipo, idApontamento, "
				+ "idFuncionarioSolicitante, idFuncionarioAprovador, dataFolga) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ocorrenciaFolgaExtra.getId());
			stmt.setTimestamp(2, new Timestamp(ocorrenciaFolgaExtra.getDataHora().getTime()));
			stmt.setString(3, ocorrenciaFolgaExtra.getMotivo());
			stmt.setString(4, String.valueOf(ocorrenciaFolgaExtra.getStatus()));
			stmt.setString(5, ocorrenciaFolgaExtra.getObservacaoGestor());
			stmt.setInt(6, ocorrenciaFolgaExtra.getTipo());
			stmt.setInt(7, ocorrenciaFolgaExtra.getApontamento().getIdApontamento());
			stmt.setInt(8, ocorrenciaFolgaExtra.getFuncionarioSolicitante().getId_Funcionario());
			stmt.setInt(9, ocorrenciaFolgaExtra.getFuncionarioAprovador().getId_Funcionario());
			stmt.setDate(10, new Date(ocorrenciaFolgaExtra.getDataFolga().getTime()));
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para atualizar uma ocorrenciaEvento
	public boolean updateOcorrenciaFolgaExtra(OcorrenciaFolgaExtra ocorrenciaFolgaExtra) {
		String sql = "UPDATE ocorrencia SET motivo = ?, observacoesGerente = ?, tipo = ?, dataFolga = ? WHERE idOcorrencia = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ocorrenciaFolgaExtra.getMotivo());
			stmt.setString(2, ocorrenciaFolgaExtra.getObservacaoGestor());
			stmt.setInt(3, ocorrenciaFolgaExtra.getTipo());
			stmt.setDate(4, new Date(ocorrenciaFolgaExtra.getDataFolga().getTime()));
			stmt.setInt(5, ocorrenciaFolgaExtra.getId());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para excluir uma ocorrenciaEvento
	public boolean deleteOcorrenciaFolgaExtra(OcorrenciaFolgaExtra ocorrenciaFolgaExtra) {
		String sql = "DELETE FROM ocorrencia WHERE idOcorrencia = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ocorrenciaFolgaExtra.getId());
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

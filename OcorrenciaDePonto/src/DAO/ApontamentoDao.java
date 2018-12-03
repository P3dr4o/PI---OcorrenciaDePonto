package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Conexao.ConexaoBD;
import Model.Apontamento;
import Model.Cargo;

public class ApontamentoDao {

	private static Connection con = ConexaoBD.getConnection();
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Date[] horarios;
	private static Date[] pontos;

	// metodo para selecionar todos os apontamentos
	public ArrayList<Apontamento> selectAllApontamentos() {
		String sql = "SELECT * FROM apontamento";
		ArrayList<Apontamento> listApontamentos = new ArrayList<>();
		Apontamento apontamento = null;

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				apontamento = new Apontamento();
				apontamento.setIdApontamento(rs.getInt("idApontamento"));
				apontamento.setDataDoApontamento(rs.getDate("dataDoApontamento"));
				apontamento.setDiaSemana(rs.getString("diaSemana"));
				apontamento.setFeriado(rs.getBoolean("feriado"));
				for(int i = 0; i < 3; i++) 
					horarios[i] = rs.getDate("hora" + ++i);
				apontamento.setHoraios(horarios);
				for(int i = 0; i < 15; i++) 
					pontos[i] = rs.getDate("apont" + ++i);
				apontamento.setPontos(pontos);
				apontamento.setObservacoes(rs.getString("observacoes"));
				apontamento.setFuncionario(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")));
				
				listApontamentos.add(apontamento);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listApontamentos;
	}

	// metodo para selecionar apontamento especifico pesquisando pelo id
	public static Apontamento selectApontamento(int idApontamento) {
		String sql = "SELECT * FROM apontamento WHERE idApontamento = ?";
		Apontamento apontamento = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idApontamento);
			rs = stmt.executeQuery();

			if (rs.next()) {
				apontamento = new Apontamento();
				apontamento.setIdApontamento(rs.getInt("idApontamento"));
				apontamento.setDataDoApontamento(rs.getDate("dataDoApontamento"));
				apontamento.setDiaSemana(rs.getString("diaSemana"));
				apontamento.setFeriado(rs.getBoolean("feriado"));
				for(int i = 0; i < 3; i++) 
					horarios[i] = rs.getDate("hora" + ++i);
				apontamento.setHoraios(horarios);
				for(int i = 0; i < 15; i++) 
					pontos[i] = rs.getDate("apont" + ++i);
				apontamento.setPontos(pontos);
				apontamento.setObservacoes(rs.getString("observacoes"));
				apontamento.setFuncionario(FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return apontamento;
	}

	// metodo para criar novo apontamento
	public boolean createApontamento(Apontamento apontamento) {
		String sql = "INSERT INTO cargo VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, apontamento.getIdApontamento());
			stmt.setDate(2, new java.sql.Date(apontamento.getDataDoApontamento().getTime()));
			stmt.setString(3, apontamento.getDiaSemana());
			stmt.setBoolean(4, apontamento.isFeriado());
			for(int i = 0; i < 3; i++) 
				stmt.setDate(i + 5, new java.sql.Date(apontamento.getHoraios()[i].getTime()));
			for(int i = 0; i < 15; i++)
				stmt.setDate(i + 9, new java.sql.Date(apontamento.getPontos()[i].getTime()));
			stmt.setString(25, apontamento.getObservacoes());
			stmt.setInt(26, apontamento.getFuncionario().getId_Funcionario());
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/* metodo para atualizar um apontamento
	public boolean updateCargo(Cargo cargo) {
		String sql = "UPDATE cargo SET nome = ? WHERE idCargo = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cargo.getIdCargo());
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/

	// metodo para excluir um apontamento
	public boolean deleteApontamento(Apontamento apontamento) {
		String sql = "DELETE FROM apontamento WHERE idApontamento = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, apontamento.getIdApontamento());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// metodo para retornar o maior ID possivel para ser inserido na tabela
	public int gerarMaxID() {
		String sql = "SELECT max(idApontamento) AS maior FROM apontamento";
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

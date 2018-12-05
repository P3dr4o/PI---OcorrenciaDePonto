package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Conexao.ConexaoBD;
import Model.Setor;

public class SetorDao {

	private static Connection con = ConexaoBD.getConnection();
	private static PreparedStatement stmt;
	private static ResultSet rs;

	// metodo para selecionar todos os setores
	public static ArrayList<Setor> selectAllSetores() {
		String sql = "SELECT * FROM setor";
		ArrayList<Setor> listSetor = new ArrayList<>();
		Setor setor = null;

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			ArrayList<String[]> r = new ArrayList<String[]>();

			while (rs.next())
				r.add(new String[] { rs.getString("nome"), rs.getString("idSetor"), rs.getString("idFuncionarioGestor"),
						rs.getString("idSetorPai") });
			for (int i = 0; i < r.size(); i++) {
				int idFun = 0;
				int idSet = 0;
				int idSetP = 0;
				if (r.get(i)[1] != null)
					idSet = Integer.parseInt(r.get(i)[1]);
				if (r.get(i)[2] != null)
					idFun = Integer.parseInt(r.get(i)[2]);
				if (r.get(i)[3] != null)
					idSetP = Integer.parseInt(r.get(i)[3]);
				setor = new Setor(r.get(i)[0], idSet, FuncionarioDao.selectFuncionarioGestor(idFun),
						selectSetorPai(idSetP));
				listSetor.add(setor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listSetor;
	}

	// metodo para selecionar setor especifico pesquisando pelo id
	public static Setor selectSetor(int idSetor) {
		String sql = "SELECT * FROM setor WHERE idSetor = ?";
		Setor setor = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idSetor);
			rs = stmt.executeQuery();

			if (rs.next()) {
				setor = new Setor(rs.getString("nome"), rs.getInt("idSetor"),
						FuncionarioDao.selectFuncionarioGestor(rs.getInt("idFuncionarioGestor")),
						selectSetorPai(rs.getInt("idSetorPai")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return setor;
	}

	// metodo para selecionar setorPai especifico pesquisando pelo id
	public static Setor selectSetorPai(int idSetor) {
		String sql = "SELECT * FROM setor WHERE idSetor = ?";
		Setor setor = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idSetor);
			rs = stmt.executeQuery();

			if (rs.next()) {
				setor = new Setor(rs.getString("nome"), rs.getInt("idSetor"),
						FuncionarioDao.selectFuncionarioGestor(rs.getInt("idFuncionarioGestor")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return setor;
	}

	// metodo para criar novo setor
	public boolean createSetor(Setor setor) {
		String sql;

		try {
			if (setor.getSetorPai() != null && setor.getFuncionario() != null) {
				sql = "INSERT INTO setor (nome, idSetorPai,idFuncionarioGestor) VALUES(?, ?, ?)";
				stmt = con.prepareStatement(sql);
				stmt.setInt(2, setor.getSetorPai().getId_Setor());
				stmt.setInt(3, setor.getFuncionario().getId_Funcionario());
			} else {
				if (setor.getSetorPai() == null && setor.getFuncionario() == null) {
					sql = "INSERT INTO setor (nome) VALUES(?)";
					stmt = con.prepareStatement(sql);
				} else {
					if (setor.getSetorPai() != null) {
						sql = "INSERT INTO setor (nome, idSetorPai) VALUES(?, ?)";
						stmt = con.prepareStatement(sql);
						stmt.setInt(2, setor.getSetorPai().getId_Setor());
					} else {
						sql = "INSERT INTO setor (nome, idFuncionarioGestor) VALUES(?, ?)";
						stmt = con.prepareStatement(sql);
						stmt.setInt(2, setor.getFuncionario().getId_Funcionario());
					}
				}
			}
			// stmt.setInt(1, setor.getId_Setor());// tem que receber o proximo codigo a ser
			// cadastrado no banco
			stmt.setString(1, setor.getNome());
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// metodo para atualizar setor
	public boolean atualizarSetor(Setor setor) {
		String sql = "UPDATE setor SET nome = ?, idSetorPai = ?, idFuncionarioGestor = ?  WHERE idSetor = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, setor.getNome());
			stmt.setInt(2, setor.getSetorPai().getId_Setor());
			stmt.setInt(3, setor.getFuncionario().getId_Funcionario());
			stmt.setInt(4, setor.getId_Setor());

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// metodo para excluir um setor
	public boolean deleteSetor(int id) {
		String sql = "DELETE FROM setor WHERE idSetor = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
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
		String sql = "SELECT max(idSetor) AS maior FROM setor";
		int max = 1;
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

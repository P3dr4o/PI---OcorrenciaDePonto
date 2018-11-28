package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.ConexaoBD;
import Model.Funcionario;
import Model.Setor;

public class SetorDao {
	
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	
	public SetorDao() {
		con = ConexaoBD.getConnection();
	}
	
	//metodo para selecionar todos os setores
	public ArrayList<Setor> selectAllSetores() {
		String sql = "SELECT * FROM setor";
		ArrayList<Setor> listSetor = new ArrayList<>();
		Setor setor = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				setor = new Setor(rs.getString("nome_setor"), rs.getInt("id_setor"), 
						FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")), selectSetor(rs.getInt("idSetorPai")) );
				listSetor.add(setor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listSetor;
	}
	
	//metodo para selecionar setor especifico pesquisando pelo nome
	public static Setor selectSetor(int idSetor) {
		String sql = "SELECT * FROM setor WHERE idSetor = ?";
		Setor setor = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, idSetor);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				setor = new Setor(rs.getString("nome_setor"), rs.getInt("id_setor"), 
						FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")), selectSetor(rs.getInt("idSetorPai")) );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return setor;
	}
	
	//metodo para criar novo setor
	public boolean createSetor(Setor setor) {
		String sql = "INSERT INTO setor VALUES(?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, gerarMaxID());
			stmt.setString(1, setor.getNome());
			stmt.setInt(2, setor.getSetorPai().getId_Setor());
			stmt.setInt(3, setor.getFuncionario().getId_Funcionario());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizarSetor(Setor setor) {
		String sql = "UPDATE FROM setor WHERE id_setor = ?";
		//terminar de implementar o codigo
		return false;
	}
	
	//metodo para excluir um setor
	public boolean deleteSetor(Setor setor) {
		String sql = "DELETE FROM setor WHERE id_setor = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, setor.getId_Setor());
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
		String sql = "SELECT max(id) AS maior FROM setor";
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

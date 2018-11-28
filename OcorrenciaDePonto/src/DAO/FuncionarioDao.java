package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Conexao.ConexaoBD;
import Model.Funcionario;
import Model.Setor;

public class FuncionarioDao {
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public FuncionarioDao() {
		con = ConexaoBD.getConnection();
	}
	
	//metodo para selecionar todos os funcionarios
	public ArrayList<Funcionario> selectAllFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		ArrayList<Funcionario> listFuncionario = new ArrayList<>();
		Funcionario funcionario = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				funcionario = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), 
						rs.getInt("registro"), CargoDao.selectCargo(rs.getInt("idCargo")), SetorDao.selectSetor(rs.getInt("idSetor")));
				listFuncionario.add(funcionario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listFuncionario;
	}
	
	//metodo para selecionar funcionario especifico pesquisando pelo nome
	public Funcionario selectFuncionario(int idFuncionario) {
		String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
		Funcionario funcionario = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, idFuncionario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				funcionario = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), 
						rs.getInt("registro"), CargoDao.selectCargo(rs.getInt("idCargo")), SetorDao.selectSetor(rs.getInt("idSetor")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	//metodo para criar novo funcionario
	public boolean createFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, gerarMaxID());
			stmt.setString(1, funcionario.getNome_Funcionario());
			stmt.setInt(2, funcionario.getNum_Registro());
			stmt.setString(3, funcionario.getLogin());
			stmt.setString(4, funcionario.getSenha());
			stmt.setInt(5, funcionario.getSetor().getId_Setor());
			stmt.setInt(6, funcionario.getCargo().getIdCargo());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizarFuncionario(Funcionario funcionario) {
		String sql = "UPDATE funcionario SET  WHERE id_setor = ?";
		//terminar de implementar o codigo
		return false;
	}
	
	//metodo para excluir um setor
	public boolean deleteFuncionario(Funcionario funcionario) {
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

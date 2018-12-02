package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Conexao.ConexaoBD;
import Controller.FuncionarioController;
import Model.Cargo;
import Model.Funcionario;
import Model.Login;

public class LoginDao {
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	
	public LoginDao() {
		con = ConexaoBD.getConnection();
	}
	
	//metodo para selecionar todos os logins
	public ArrayList<Login> selectAllLogins() {
		String sql = "SELECT * FROM Logins";
		ArrayList<Login> listLogins = new ArrayList<>();
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				login = new Login(rs.getString("usuario"), rs.getString("senha"), FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")));
				login.setIdLogin(rs.getInt("idLogin"));
				listLogins.add(login);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listLogins;
	}
	
	//metodo para selecionar Login especifico pesquisando pelo idFuncionario
	public static Login selectLogin(int idFuncionario) {
		String sql = "SELECT * FROM Login WHERE idFuncionario = ?";
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idFuncionario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				login = new Login(rs.getString("nome"), rs.getString("senha"), FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return login;
	}
	
	//*metodo para criar novo login
	public boolean createLogin(Login login) {
		String sql = "INSERT INTO Login VALUES(?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			//stmt.setInt(1, login.getId());
			//stmt.setString(2, cargo.getNomeCargo());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para atualizar um cargo
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
	}
	
	//metodo para excluir um cargo
	public boolean deleteCargo(Cargo cargo) {
		String sql = "DELETE FROM cargo WHERE idCargo = ?";
		
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
	}
	
	//metodo para retornar o maior ID possivel para ser inserido na tabela
	public int gerarMaxID() {
		String sql = "SELECT max(idCargo) AS maior FROM cargo";
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

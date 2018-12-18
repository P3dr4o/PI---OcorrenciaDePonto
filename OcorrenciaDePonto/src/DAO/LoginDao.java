package DAO;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Conexao.ConexaoBD;
import Model.Login;


public class LoginDao {
	private static Connection con = ConexaoBD.getConnection();
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//metodo para selecionar todos os logins
	public static ArrayList<Login> selectAllLogins() {
		String sql = "SELECT * FROM login";
		ArrayList<Login> listLogin = new ArrayList<>();
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				login = new Login(rs.getString("usuario"), rs.getString("senha"));
				login.setIdLogin(rs.getInt("idLogin"));
				login.setUltimoLogin(rs.getDate("ultimoLogin"));
				listLogin.add(login);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listLogin;
	}
	
	//metodo para selecionar Login especifico pesquisando pelo id do funcionário
	public static Login selectLogin(int idFuncionario) {
		String sql = "SELECT * FROM login WHERE idFuncionario = ?";
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idFuncionario);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				login = new Login(rs.getString("usuario"), rs.getString("senha"));
				login.setIdLogin(rs.getInt("idLogin"));
				login.setUltimoLogin(rs.getDate("ultimoLogin"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return login;
	}
	
	//*metodo para criar novo login
	public boolean createLogin(Login login) {
		String sql = "INSERT INTO login (usuario, senha, idFuncionario) VALUES(?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			stmt.setInt(3, login.getFuncionario().getId_Funcionario());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para atualizar um login
	public boolean updateLogin(Login login) {
		String sql = "UPDATE login SET usuario = ?, senha = ?, ultimoLogin = ? WHERE idLogin = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			stmt.setTimestamp(3, new Timestamp(login.getUltimoLogin().getTime()));
			stmt.setInt(4, login.getIdLogin());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para excluir um login
	public boolean deleteLogin(Login login) {
		String sql = "DELETE FROM login WHERE idLogin = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, login.getIdLogin());
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
		String sql = "SELECT max(idLogin) AS maior FROM login";
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

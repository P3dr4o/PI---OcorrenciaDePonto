package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Conexao.ConexaoBD;
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
		String sql = "SELECT * FROM Login";
		ArrayList<Login> listLogins = new ArrayList<>();
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				login = new Login(rs.getString("usuario"), rs.getString("senha"), FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")));
				login.setIdLogin(rs.getInt("idLogin"));
				login.setUltimoLogin(rs.getDate("ultimoLogin"));
				listLogins.add(login);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listLogins;
	}
	
	//metodo para selecionar Login especifico pesquisando pelo idFuncionario
	public static Login selectLogin(int idLogin) {
		String sql = "SELECT * FROM Login WHERE idLogin = ?";
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idLogin);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				login = new Login(rs.getString("nome"), rs.getString("senha"), FuncionarioDao.selectFuncionario(rs.getInt("idFuncionario")));
				login.setIdLogin(idLogin);
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
		String sql = "INSERT INTO login VALUES(?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			//stmt.setInt(1, login.getIdLogin());
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			stmt.setDate(3, (Date) login.getUltimoLogin());
			stmt.setInt(4, login.getFuncionario().getId_Funcionario());
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
		String sql = "UPDATE login SET usuario = ?, senha = ? WHERE idLogin = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			stmt.setInt(3, login.getIdLogin());
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

package DAO;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import Conexao.ConexaoBD;
import Model.Login;


public class LoginDao {
	private static Connection con = ConexaoBD.getConnection();
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//metodo para selecionar todos os logins
	@SuppressWarnings("deprecation")
	public static ArrayList<Login> selectAllLogins() {
		String sql = "SELECT * FROM login";
		ArrayList<Login> listLogin = new ArrayList<>();
		Login login = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			ArrayList<String[]> r = new ArrayList<String[]>();
			while(rs.next()) {
				r.add(new String[] {
						rs.getString("idLogin"),
						rs.getString("usuario"),
						rs.getString("senha"),
						rs.getString("ultimoLogin"),
						rs.getString("idFuncionario")
						
				});
			}
			for(int i = 0; i < r.size(); i++) {
				int idLogin = 0;
				int idFuncionario = 0;
				Date ultimoLogin = null;
				if (r.get(i)[0] != null)
					idLogin = Integer.parseInt(r.get(i)[0]);
				if (r.get(i)[4] != null)
					idFuncionario = Integer.parseInt(r.get(i)[4]);
				/*if(r.get(i)[3] != null)
					ultimoLogin = new Date(r.get(i)[3]);*/
				login = new Login(r.get(i)[1], r.get(i)[2]);
				login.setIdLogin(idLogin);
				//login.setUltimoLogin(ultimoLogin);
				login.setFuncionario(FuncionarioDao.selectFuncionario(idFuncionario));
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
	public static boolean updateLogin(Login login) {
		
		if(login.getUsuario() != null) {
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
		} else {
			String sql = "UPDATE login SET senha = ? WHERE idLogin = ?";
			
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, login.getSenha());
				stmt.setInt(2, login.getIdLogin());
				stmt.executeUpdate();
				
				return true;
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
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

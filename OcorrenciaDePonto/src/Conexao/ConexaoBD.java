package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexaoBD {
	
	private static Connection con = null;
	
	private ConexaoBD() {}
		
	//Metodo para iniciar/pegar conexão com banco de dados
	public static Connection getConnection() { 
		
		try {
			
			if(con == null) {
				//Driver do mysql
				Class.forName("com.mysql.jdbc.Driver");
				//Caminho/usuario/senha do banco de dados
				con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
		                
		        //JOptionPane.showMessageDialog(null, "Conectado ao banco de dados");
		    }
			
		}
		catch(SQLException e) {
	            
	            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco", "Erro", JOptionPane.ERROR_MESSAGE);
	            System.exit(1);
		}
		catch(ClassNotFoundException e) {
	            System.err.println("Erro: Drive do Banco n�o encontrado");
	            System.exit(1);
		}
		
		return con;
		
	}
	
	//Metodos para desconectar connection/statement/resultset
	public static void desconectar(Connection con) {
		
		try {
			con.close();
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro: "+ex);
		}
	}
	
	public static void desconectar(Connection con, Statement stmt) {
		
		try {
			
			stmt.close();	
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro: "+ex);
		}
		desconectar(con);
	}
	
	public static void desconectar(Connection con, Statement stmt, ResultSet rs) {
		
		try {
			
			rs.close();	
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro: "+ex);
		}
		desconectar(con, stmt);
	}
}



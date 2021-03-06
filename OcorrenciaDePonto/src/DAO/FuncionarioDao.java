package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Conexao.ConexaoBD;
import Model.Funcionario;
import Model.Setor;

public class FuncionarioDao {
	
	private static Connection con = ConexaoBD.getConnection();
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//metodo para selecionar todos os funcionarios
	public static ArrayList<Funcionario> selectAllFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		ArrayList<Funcionario> listFuncionario = new ArrayList<>();
		Funcionario funcionario = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
	
			ArrayList<String[]> r = new ArrayList<String[]>();

			while (rs.next())
				r.add(new String[] { rs.getString("idFuncionario"), rs.getString("nome"), rs.getString("registro"),
						rs.getString("idCargo") , rs.getString("idSetor")});
			for (int i = 0; i < r.size(); i++) {
				int idCargo = 0;
				int idSet = 0;
				if (r.get(i)[3] != null)
					idCargo = Integer.parseInt(r.get(i)[3]);
				if (r.get(i)[4] != null)
					idSet = Integer.parseInt(r.get(i)[4]);
				funcionario = new Funcionario(Integer.parseInt(r.get(i)[0]), r.get(i)[1], 
						Integer.parseInt(r.get(i)[2]), CargoDao.selectCargo(idCargo), SetorDao.selectSetor(idSet));
				funcionario.setLogin(LoginDao.selectLogin(Integer.parseInt(r.get(i)[0])));
				listFuncionario.add(funcionario);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listFuncionario;
	}
	
	//metodo para selecionar funcionario especifico pesquisando pelo id
	public static Funcionario selectFuncionario(int idFuncionario) {
		String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
		Funcionario funcionario = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idFuncionario);
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
	
	//metodo para selecionar funcionarioGestor especifico pesquisando pelo id
		public static Funcionario selectFuncionarioGestor(int idFuncionario) {
			String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
			Funcionario funcionario = null;
			
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, idFuncionario);
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					funcionario = new Funcionario(rs.getInt("idFuncionario"), rs.getString("nome"), 
							rs.getInt("registro"), CargoDao.selectCargo(rs.getInt("idCargo")));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return funcionario;
		}
	
	//metodo para criar novo funcionario
	public static boolean createFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO Funcionario(nome, registro, idSetor, idCargo) VALUES(?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			//stmt.setInt(1, funcionario.getId_Funcionario());
			stmt.setString(1, funcionario.getNome_Funcionario());
			stmt.setInt(2, funcionario.getNum_Registro());
			stmt.setInt(3, funcionario.getSetor().getId_Setor());
			stmt.setInt(4, funcionario.getCargo().getIdCargo());
			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para atualizar funcionario
	public static boolean atualizarFuncionario(Funcionario funcionario) {
		String sql = "UPDATE funcionario SET nome = ?, registro = ?, idCargo = ?, idSetor = ? WHERE idFuncionario = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome_Funcionario());
			stmt.setInt(2, funcionario.getNum_Registro());
			stmt.setInt(3, funcionario.getCargo().getIdCargo());
			stmt.setInt(4, funcionario.getSetor().getId_Setor());
			stmt.setInt(5, funcionario.getId_Funcionario());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para excluir um funcionario
	public static boolean deleteFuncionario(int idFuncionario) {
		String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idFuncionario);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para retornar o maior ID possivel para ser inserido na tabela
	public static int gerarMaxID() {
		String sql = "SELECT max(idFuncionario) AS maior FROM Funcionario";
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

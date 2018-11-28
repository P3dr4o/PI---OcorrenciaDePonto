package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.ConexaoBD;
import Model.Cargo;

public class CargoDao {
	
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	
	public CargoDao() {
		con = ConexaoBD.getConnection();
	}
	
	//metodo para selecionar todos os cargos
	public ArrayList<Cargo> selectAllCargos() {
		String sql = "SELECT * FROM cargo";
		ArrayList<Cargo> listCargos = new ArrayList<>();
		Cargo cargo = null;
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				cargo = new Cargo(rs.getInt("idCargo"), rs.getString("nome"));
				listCargos.add(cargo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listCargos;
	}
	
	//metodo para selecionar cargo especifico pesquisando pelo nome
	public static Cargo selectCargo(int idCargo) {
		String sql = "SELECT * FROM cargo WHERE idCargo = ?";
		Cargo cargo = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, idCargo);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				cargo = new Cargo(rs.getInt("idCargo"), rs.getString("nome"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cargo;
	}
	
	//metodo para criar novo cargo
	public boolean createCargo(Cargo cargo) {
		String sql = "INSERT INTO cargo VALUES(?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(0, gerarMaxID());
			stmt.setString(1, cargo.getNomeCargo());
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
			stmt.setInt(0, cargo.getIdCargo());
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

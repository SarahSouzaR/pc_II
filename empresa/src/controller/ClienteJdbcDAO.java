package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clientes;

public class ClienteJdbcDAO {
	
private Connection conn;
	
	
	public ClienteJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Clientes> listar() {
		String sql = "select * from cliente";
        System.out.println(sql);		
        List<Clientes> clientes = new ArrayList<Clientes>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
				Clientes cliente = new Clientes();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setUf(rs.getString("uf"));
				cliente.setTelefone(rs.getString("telefone"));
				
				clientes.add(cliente);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

}

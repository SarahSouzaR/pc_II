package controller;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Pessoas;

public class PessoasJdbcDAO {

	private Connection conn;
	
	public PessoasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Pessoas p) throws SQLException {
		String sql = "insert into tb_pessoas (nome, email, sexo) values ('"+p.getNome()+"', '"+p.getEmail()+"', '"+p.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(Pessoas p) throws SQLException {
		String sql = "update tb_pessoas set nome='"+p.getNome()+"', email='"+p.getEmail()+"', sexo='"+p.getSexo()+"' where email='"+p.getEmail()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete(Pessoas p) throws SQLException {
		String sql = "delete from tb_pessoas where email='"+p.getEmail()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Pessoas> listar(){
		String sql = "select * from tb_pessoas";
		System.out.println(sql);
		List<Pessoas> pessoas = new ArrayList<Pessoas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String sexo = rs.getString("sexo");
			System.out.println(nome + " " + email + " " + sexo);
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoas;
	}
}

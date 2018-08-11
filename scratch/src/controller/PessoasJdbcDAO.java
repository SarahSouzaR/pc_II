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
		String sql = "insert into tb_pessoas (id_pessoa, nome, email, sexo) values ('"+p.getId_pessoa()+"','"+p.getNome()+"', '"+p.getEmail()+"', '"+p.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(Pessoas p, Integer id) throws SQLException {
		String sql = "update tb_pessoas set nome='"+p.getNome()+"', email='"+p.getEmail()+"', sexo='"+p.getSexo()+"' where id='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from tb_pessoas where pessoas.id='"+id+"';";
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

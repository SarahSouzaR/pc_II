package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Alunos;

public class AlunosJdbcDAO {
	
	private Connection conn;
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into alunos (nome, endereco, bairro) values ('"+c.getNome()+"','"+c.getEndereco()+"', '"+c.getBairro()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar(int a) throws SQLException {
		String sql = "delete from alunos where alunos.id="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(String c, int a) throws SQLException {
		String sql = "update alunos set 'nome'="+c+" where alunos.id="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

}

package controller;

import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Tarefa;
import model.Pessoas;

public class TarefaJdbcDAO {
	
	private Connection conn;
	
	public TarefaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Tarefa t) throws SQLException {
		String sql = "insert into tb_tarefa (titulo, prazo_estimado, descricao, dt_inicio, dt_termino) values ('"+t.getTitulo()+"', '"+t.getPrazo_estimado()+"', '"+t.getDescricao()+"', '"+t.getDt_inicio()+"', '"+t.getDt_termino()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(Tarefa t, Integer id) throws SQLException {
		String sql = "update tb_tarefa set titulo='"+t.getTitulo()+"', prazo_estimado='"+t.getPrazo_estimado()+"', descricao='"+t.getDescricao()+"', dt_inicio='"+t.getDt_inicio()+"', dt_termino='"+t.getDt_termino()+"' where id_tarefa='"+t.getId_tarefa()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete(Integer id) throws SQLException {
		String sql = "delete from tb_tarefa where id_tarefa='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Tarefa> listar(){
		String sql = "select * from tb_tarefa";
		System.out.println(sql);
		List<Tarefa> tarefa = new ArrayList<Tarefa>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
			String titulo = rs.getString("titulo");
			String prazo_estimado = rs.getString("prazo_estimado");
			String descricao = rs.getString("descricao");
			String dt_inicio = rs.getString("dt_inicio ");
			String dt_termino = rs.getString("dt_termino");
			System.out.println(titulo + " " + prazo_estimado + " " + descricao + " " + dt_inicio + " " + dt_termino);
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return tarefa;
	}

}

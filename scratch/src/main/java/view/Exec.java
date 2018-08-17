package view;

import java.sql.Connection;
import controller.PessoasJdbcDAO;
import controller.JdbUtil;
import model.Pessoas;

public class Exec {
	
	public static void main(String[] args) {
		Pessoas pessoas = new Pessoas();
		
		try {
			pessoas.setNome("Sarah de Souza");
			pessoas.setEmail("sarinha_desouza@outlook.com");
			pessoas.setSexo("Feminino");
			
			//setar os parametros das outras classes
			
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
			
			//puxar os metodos salvar, update, delete e lista
			pessoasJdbcDAO.salvar(pessoas);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

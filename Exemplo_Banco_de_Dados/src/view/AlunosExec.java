package view;

import java.sql.Connection;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class AlunosExec {

	public static void main(String[] args) {
		
		Alunos alunos = new Alunos();
		try {
			alunos.setNome("Sarah de Souza");
			alunos.setEndereco("Rua Fernão Alves, 30");
			alunos.setBairro("Vila Buenos Aires");
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			//alunosJdbcDao.salvar(alunos);
			alunosJdbcDao.update(alunos, 1);
			//alunosJdbcDao.deletar(2); //colocar número do ID
			//alunosJdbcDao.listar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

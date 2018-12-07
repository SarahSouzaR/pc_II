package testes;

import relatorio.ClienteRel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controller.ClienteJdbcDAO;
import controller.JdbcUtil;
import model.Clientes;

public class RelatorioCliente {

	public static void main(String[] args) {
		try {
			
			List<Clientes> clientes = new ArrayList<Clientes>();
			
			Clientes cliente1 = new Clientes();
			cliente1.setNome("Sarah de Souza");
			cliente1.setEndereco("Rua ABC, 123");
			cliente1.setComplemento("Sala 01");
			cliente1.setTelefone("96548-6523");
			cliente1.setUf("SP");
			
			Clientes cliente2 = new Clientes();
			cliente2.setNome("Ana do Nascimento");
			cliente2.setEndereco("Av do ABC, 1052");
			cliente2.setComplemento("3º Andar");
			cliente2.setUf("SP");
			
			Clientes cliente3 = new Clientes();
			cliente3.setNome("FLC Tecnologia");
			cliente3.setEndereco("Rua Aricanduva, São Paulo");
			cliente3.setComplemento("Sala 23");
			cliente3.setTelefone("98523-1234");
			cliente3.setUf("SP");
			
			
			clientes.add(cliente1);
			clientes.add(cliente2);
			clientes.add(cliente3);
		
			
			ClienteRel relatorio = new ClienteRel();
			relatorio.imprimir(clientes);
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

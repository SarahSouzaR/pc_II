package view;

import javax.swing.JFrame;

import controller.ClienteJpaDAO;
import model.Cliente;

public class App 
{
    public static void main( String[] args )
    {
    	Cliente cliente = new Cliente();
    	cliente.setCpf("123.456.789-10");
    	cliente.setId(1);
    	cliente.setNome("Sarah de Souza Ribeiro Lucas");
    	cliente.setRg("12.345.678-9");
    	ClienteJpaDAO.getInstance().merge(cliente);
    	System.out.println("Objeto salvo com sucesso!!!");       
    }
}

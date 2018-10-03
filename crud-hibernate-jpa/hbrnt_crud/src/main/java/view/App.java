package view;

import controller.ClienteJpaDAO;
import controller.VendaJpaDAO;
import model.Cliente;
import model.Venda;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Cliente cliente = new Cliente();
       cliente.setCpf("456.123.789-10");
       cliente.setId(2);
       cliente.setNome("Teste Teste");
       cliente.setRg("56.123.987-9");
       ClienteJpaDAO.getInstance().persist(cliente);
       System.out.println("Cliente Salvo!");
       
     
       Venda venda = new Venda();
       venda.setCliente(cliente);
       venda.setData("02/10/2018");
       venda.setDesconto(0.10);
       venda.setId_venda(2);
       venda.setVlr_pago(90.00);
       venda.setVlr_total(100.00);
       VendaJpaDAO.getInstance().persist(venda);
       System.out.println("Venda concluída!");
       
    }
}

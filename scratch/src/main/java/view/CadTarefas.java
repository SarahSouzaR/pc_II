package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.TarefaJdbcDAO;
import controller.JdbUtil;
import model.Tarefa;

public class CadTarefas extends JFrame {

	JLabel lblTitulo = new JLabel("Título: ");
	JTextField txtTitulo = new JTextField();
	
	JLabel lblPrazoEstimado = new JLabel("Prazo Estimado: ");
	JTextField txtPrazoEstimado = new JTextField();
	
	JLabel lblDescricao = new JLabel("Descrição: ");
	JTextArea txtDescricao = new JTextArea();
	JScrollPane Scrollpane = new JScrollPane(txtDescricao);
	
	JLabel lblDtInicio = new JLabel("Data de Início: ");
	JTextField txtDtInicio = new JTextField();
	
	JLabel lblDtTermino = new JLabel("Data de Término: ");
	JTextField txtDtTermino = new JTextField();
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");	
	
	public CadTarefas() {
		super("Cadastro de Tarefas");
		
		Container paine = this.getContentPane();
		
	}
	
	
	public static void main(String[] args) {
		
		

	}

}

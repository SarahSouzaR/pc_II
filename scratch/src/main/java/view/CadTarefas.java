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
	JButton btnMetodologia = new JButton("Inserir Metodologia");
	
	public CadTarefas() {
		super("Cadastro de Tarefas");
		
		Container paine = this.getContentPane();
		
		paine.add(lblTitulo);
		paine.add(txtTitulo);
		lblTitulo.setBounds(20, 25, 140, 30);
		txtTitulo.setBounds(150, 25, 310, 30);
		
		paine.add(lblPrazoEstimado);
		paine.add(txtPrazoEstimado);
		lblPrazoEstimado.setBounds(20, 60, 140, 30);
		txtPrazoEstimado.setBounds(150, 60, 310, 30);
		
		paine.add(lblDescricao);
		paine.add(Scrollpane);	
		lblDescricao.setBounds(20, 155, 140, 30);
		Scrollpane.setBounds(150, 95, 310, 150);
		
		paine.add(lblDtInicio);
		paine.add(txtDtInicio);
		lblDtInicio.setBounds(20, 250, 140, 30);
		txtDtInicio.setBounds(150, 250, 310, 30);
		
		paine.add(lblDtTermino);
		paine.add(txtDtTermino);
		lblDtTermino.setBounds(20, 285, 140, 30);
		txtDtTermino.setBounds(150, 285, 310, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(20, 350, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa tarefa = new Tarefa();
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					
					tarefaJdbcDAO.salvar(tarefa);
					
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnEditar);
		btnEditar.setBounds(130, 350, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa tarefa = new Tarefa();
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					
					tarefaJdbcDAO.update(tarefa);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnApagar);
		btnApagar.setBounds(240, 350, 100, 30);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa tarefa = new Tarefa();
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					
					tarefaJdbcDAO.delete(tarefa);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnMetodologia);
		btnMetodologia.setBounds(350, 350, 160, 30);
		btnMetodologia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadMetodologia cadMetodologia = new CadMetodologia();
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(550, 480);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	
	public static void main(String[] args) {
		CadTarefas cadTarefas = new CadTarefas();
	}

}

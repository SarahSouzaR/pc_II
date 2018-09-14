package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefaJdbcDAO;
import model.Tarefa;

public class EditTarefa extends JFrame{
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID da Tarefa: ");
	
	JTextField txtIDUser = new JTextField();
	JLabel lblIDUser = new JLabel("ID do Usuário: ");
	
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
	
	JButton btnEditar = new JButton("Editar");
	
	public EditTarefa() {
		super("Editar - Tarefa");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblID);
		paine.add(txtID);	
		lblID.setBounds(20, 25, 140, 30);
		txtID.setBounds(150, 25, 160, 30);
		
		paine.add(lblTitulo);
		paine.add(txtTitulo);
		lblTitulo.setBounds(20, 60, 140, 30);
		txtTitulo.setBounds(150, 60, 310, 30);
		
		paine.add(lblPrazoEstimado);
		paine.add(txtPrazoEstimado);
		lblPrazoEstimado.setBounds(20, 95, 140, 30);
		txtPrazoEstimado.setBounds(150, 95, 310, 30);
		
		paine.add(lblDescricao);
		paine.add(Scrollpane);	
		lblDescricao.setBounds(20, 165, 140, 30);
		Scrollpane.setBounds(150, 130, 310, 115);
		
		paine.add(lblDtInicio);
		paine.add(txtDtInicio);
		lblDtInicio.setBounds(20, 250, 140, 30);
		txtDtInicio.setBounds(150, 250, 310, 30);
		
		paine.add(lblDtTermino);
		paine.add(txtDtTermino);
		lblDtTermino.setBounds(20, 285, 140, 30);
		txtDtTermino.setBounds(150, 285, 310, 30);
		
		paine.add(lblIDUser);
		paine.add(txtIDUser);
		lblIDUser.setBounds(20, 320, 140, 30);
		txtIDUser.setBounds(150, 320, 160, 30);
		
		paine.add(btnEditar);
		btnEditar.setBounds(220, 380, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa tarefa = new Tarefa();
					tarefa.setId_tarefa(Integer.parseInt(txtID.getText()));
					tarefa.setId_pessoa(Integer.parseInt(txtIDUser.getText()));
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					
					tarefaJdbcDAO.update(tarefa, Integer.parseInt(txtID.getText()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
		this.setVisible(true);
		this.setSize(550, 480);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EditTarefa editar = new EditTarefa();
	}

}

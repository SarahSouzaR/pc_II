package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.TarefaJdbcDAO;
import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;
import model.Tarefa;

public class CadTarefas extends JFrame {

	JLabel lblComboBox = new JLabel("Selecione o usuário: ");
	JComboBox cboUsuario = new JComboBox();
		
	JLabel lblObs = new JLabel("* somente para tarefas cadastradas");
	
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
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton("Editar");
	
	public CadTarefas() {
		super("Cadastro de Tarefas");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		/*paine.add(lblComboBox);
		paine.add(cboUsuario);
		lblComboBox.setBounds(20, 20, 150, 20);
		cboUsuario.setBounds(150, 20, 150, 20);
		
		cboUsuario.addItem("");*/
		
		/*
		ArrayList<String> pessoas = new ArrayList<String>();
		
		public static void GerandoCB() {
			try {
				pessoas.clear();
				
				cboUsuario.removeAllItems();
				
				Statement statement;
				ResultSet rs = statement.executeQuery("select * from tb_pessoas");
				
				while (rs.next()) {
					ResultSet resultSet;
					pessoas.add(resultSet.getString("pessoas"));
				}
				
				for (String p : pessoas) {
					cboUsuario.addItem(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ResultSet rs;
			if (rs.next()) {
				String titulo = rs.getString("titulo");
				String prazo_estimado = rs.getString("prazo_estimado");
				String descricao = rs.getString("descricao");
				String dt_inicio = rs.getString("dt_inicio ");
				String dt_termino = rs.getString("dt_termino");
				System.out.println(titulo + " " + prazo_estimado + " " + descricao + " " + dt_inicio + " " + dt_termino);
			}
		}
		*/
		
		/*
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO pessoaJdbcDAO = new PessoasJdbcDAO(connection);
		
			List<Pessoa> p = PessoasJdbcDAO.listar();
			
			for(int i = 0; i < p.size(); i++) {
				cboUsuario.addItem(p.get(i).getNome());
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
		*/
		
		paine.add(lblObs);
		lblObs.setFont(new Font ("Arial", Font.PLAIN, 10));
		lblObs.setBounds(315, 20, 200, 30);
		
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
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(100, 380, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					Tarefa tarefa = new Tarefa();
					tarefa.setId_pessoa(Integer.parseInt(txtIDUser.getText()));
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
									
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					tarefaJdbcDAO.salvar(tarefa);
					
					//verificando existência de usuário
					PessoasJdbcDAO pVerificar = new PessoasJdbcDAO(connection);
					pVerificar.select(Integer.parseInt(txtIDUser.getText()));
					
					
					//if (pVerificar.select(rs == (Integer.parseInt(txtIDUser.getText())))) {
					
						//-------------------- colocar o insert aqui -----------------------------------------
							/*
							String sql = "insert into tarefa_participantes (id_pessoa, id_tarefa) values ('"+txtIDUser.getText()+"', '"+txtID.getText()+"')";
							System.out.println(sql);
							PreparedStatement prepareStatement = connection.prepareStatement(sql);
							prepareStatement.executeUpdate();
							prepareStatement.close();
							*/
				//	}
					
					//pessoasJdbcDAO.select(Integer.parseInt(txtID.getText()));
					
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnEditar);
		btnEditar.setBounds(220, 380, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa tarefa = new Tarefa();
					tarefa.setId_tarefa(Integer.parseInt(txtID.getText()));
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
		
	}
	
	private void GerandoCB() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		CadTarefas cadTarefas = new CadTarefas();
	}
}

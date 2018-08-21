package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

import controller.PessoasJdbcDAO;
import controller.JdbUtil;
import model.Pessoas;

public class CadPessoas extends JFrame{
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JTextField txtEmail = new JTextField();
	JLabel lblEmail = new JLabel("E-mail: ");
	
	JTextField txtSexo = new JTextField();
	JLabel lblSexo = new JLabel("Sexo: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");
	
	public CadPessoas() {
		super("Cadastro de Usuários");
		
		Container paine = this.getContentPane();
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(70, 25, 45, 30);
		txtNome.setBounds(150, 25, 310, 30);
		
		paine.add(lblEmail);
		paine.add(txtEmail);	
		lblEmail.setBounds(70, 60, 70, 30);
		txtEmail.setBounds(150, 60, 310, 30);	
		
		paine.add(lblSexo);
		paine.add(txtSexo);	
		lblSexo.setBounds(70, 95, 70, 30);
		txtSexo.setBounds(150, 95, 310, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(100, 160, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setNome(txtNome.getText());
					pessoas.setEmail(txtEmail.getText());
					pessoas.setSexo(txtSexo.getText());
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					pessoasJdbcDAO.salvar(pessoas);
					
					//Fecha a janela depois da ação
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnEditar);
		btnEditar.setBounds(220, 160, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setNome(txtNome.getText());
					pessoas.setEmail(txtEmail.getText());
					pessoas.setSexo(txtSexo.getText());
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					pessoasJdbcDAO.update(pessoas);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnApagar);
		btnApagar.setBounds(340, 160, 100, 30);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setNome(txtNome.getText());
					pessoas.setEmail(txtEmail.getText());
					pessoas.setSexo(txtSexo.getText());
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);					
					
					pessoasJdbcDAO.delete(pessoas);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(560, 280);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE); //para não fechar toda a aplicação
	}		
	
	public static void main(String[] args) {
		CadPessoas cadPessoas = new CadPessoas();
	}
}

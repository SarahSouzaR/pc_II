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

public class Exec extends JFrame{
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEmail = new JTextField();
	JLabel email = new JLabel("E-MAIL: ");
	
	JTextField txtSexo = new JTextField();
	JLabel sexo = new JLabel("SEXO: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	public Exec() {
		super("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(email);
		paine.add(txtEmail);	
		email.setBounds(10, 50, 70, 30);
		txtEmail.setBounds(90, 50, 225, 30);	
		
		paine.add(sexo);
		paine.add(txtSexo);	
		sexo.setBounds(10, 85, 70, 30);
		txtSexo.setBounds(90, 85, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 150, 130, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setNome(txtNome.getText());
					pessoas.setEmail(txtEmail.getText());
					pessoas.setSexo(txtSexo.getText());
					
					//setar os parametros das outras classes
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					//puxar os metodos salvar, update, delete e lista
					pessoasJdbcDAO.salvar(pessoas);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(600, 300);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}		
	
	public static void main(String[] args) {
		Exec exec = new Exec();
	}
}

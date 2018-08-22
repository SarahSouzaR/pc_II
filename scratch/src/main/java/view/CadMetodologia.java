package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

import controller.MetodologiaJdbcDAO;
import controller.PessoasJdbcDAO;
import controller.JdbUtil;
import model.Metodologia;
import model.Pessoas;

public class CadMetodologia extends JFrame{
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Metodologia: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");
	
	public CadMetodologia() {
		super("Cadastro de Usuários");
		
		Container paine = this.getContentPane();
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(50, 35, 100, 30);
		txtNome.setBounds(150, 35, 310, 30);
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(100, 100, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologia metodologia = new Metodologia();
					metodologia.setMetodo_nome(txtNome.getText());
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.salvar(metodologia);
					
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnEditar);
		btnEditar.setBounds(220, 100, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologia metodologia = new Metodologia();
					metodologia.setMetodo_nome(txtNome.getText());
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.update(metodologia);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnApagar);
		btnApagar.setBounds(340, 100, 100, 30);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologia metodologia = new Metodologia();
					metodologia.setMetodo_nome(txtNome.getText());
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.delete(metodologia);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(560, 200);
	this.setResizable(false);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		CadMetodologia cadMetodologia = new CadMetodologia();
	}

}

package view;

import java.awt.Container;
import java.awt.Font;
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
	
	JLabel lblObs = new JLabel("* somente para metodologias cadastradas");
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Metodologia: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");
	
	public CadMetodologia() {
		super("Cadastro de Metodologias");
		
		Container paine = this.getContentPane();
		
		paine.add(lblObs);
		lblObs.setFont(new Font ("Arial", Font.PLAIN, 10));
		lblObs.setBounds(315, 20, 200, 30);
		
		paine.add(lblID);
		paine.add(txtID);
		lblID.setBounds(50, 25, 100, 30);
		txtID.setBounds(150, 25, 160, 30);
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(50, 60, 100, 30);
		txtNome.setBounds(150, 60, 310, 30);
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(100, 115, 100, 30);
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
		btnEditar.setBounds(220, 115, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologia metodologia = new Metodologia();
					metodologia.setId_metodologia(Integer.parseInt(txtID.getText()));;
					metodologia.setMetodo_nome(txtNome.getText());
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.update(metodologia, Integer.parseInt(txtID.getText()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnApagar);
		btnApagar.setBounds(340, 115, 100, 30);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologia metodologia = new Metodologia();
					metodologia.setId_metodologia(Integer.parseInt(txtID.getText()));
					metodologia.setMetodo_nome(txtNome.getText());
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.delete(Integer.parseInt(txtID.getText()));
					
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

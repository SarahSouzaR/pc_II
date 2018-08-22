package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.TimeJdbcDAO;
import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;
import model.Time;

public class CadTime extends JFrame{
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome do Time: ");
	
	JTextField txtIdPessoa = new JTextField();
	JLabel lblIdPesooa = new JLabel("ID do Usuário: ");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");
	
	public CadTime() {
		super("Cadastro de Times");
		
		Container paine = this.getContentPane();
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(35, 25, 140, 30);
		txtNome.setBounds(150, 25, 310, 30);
		
		paine.add(lblIdPesooa);
		paine.add(txtIdPessoa);	
		lblIdPesooa.setBounds(35, 60, 140, 30);
		txtIdPessoa.setBounds(150, 60, 310, 30);	
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(100, 120, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setNm_time(txtNome.getText());
					time.setId_pessoa(txtIdPessoa.getText());
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.salvar(time);
					
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnEditar);
		btnEditar.setBounds(220, 120, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setNm_time(txtNome.getText());
					time.setId_pessoa(txtIdPessoa.getText());
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.update(time);
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		paine.add(btnApagar);
		btnApagar.setBounds(340, 120, 100, 30);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setNm_time(txtNome.getText());
					time.setId_pessoa(txtIdPessoa.getText());
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.delete(time);
					
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
		CadTime cadTime = new CadTime();
	}

}

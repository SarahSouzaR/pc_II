package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.MetodologiaJdbcDAO;
import model.Metodologia;

public class EditMetodologia extends JFrame{
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Metodologia: ");
	
	JButton btnEditar = new JButton("Editar");	
	
	public EditMetodologia() {
		super("Editar - Metodologia");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblID);
		paine.add(txtID);
		lblID.setBounds(50, 25, 100, 30);
		txtID.setBounds(150, 25, 160, 30);
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(50, 60, 100, 30);
		txtNome.setBounds(150, 60, 310, 30);
		
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
	
	this.setVisible(true);
	this.setSize(560, 200);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	public static void main(String[] args) {
		EditMetodologia editar = new EditMetodologia();
	}

}

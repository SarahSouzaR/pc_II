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
import controller.TimeJdbcDAO;
import model.Time;

public class EditTime extends JFrame{
	
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID do Time: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome do Time: ");
	
	JTextField txtIdPessoa = new JTextField();
	JLabel lblIdPesooa = new JLabel("ID do Usuário: ");
	
	JButton btnEditar = new JButton("Editar");	
	
	public EditTime() {
		super("Editar - Time");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblID);
		paine.add(txtID);	
		lblID.setBounds(35, 25, 70, 30);
		txtID.setBounds(150, 25, 160, 30);
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(35, 60, 140, 30);
		txtNome.setBounds(150, 60, 310, 30);
		
		paine.add(lblIdPesooa);
		paine.add(txtIdPessoa);	
		lblIdPesooa.setBounds(35, 95, 140, 30);
		txtIdPessoa.setBounds(150, 95, 310, 30);	
		
		paine.add(btnEditar);
		btnEditar.setBounds(220, 150, 100, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setId_time(Integer.parseInt(txtID.getText()));;
					time.setNm_time(txtNome.getText());
					time.setId_pessoa(Integer.parseInt(txtIdPessoa.getText()));
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.update(time, Integer.parseInt(txtID.getText()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
			
		this.setVisible(true);
		this.setSize(560, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		EditTime editar = new EditTime();

	}

}

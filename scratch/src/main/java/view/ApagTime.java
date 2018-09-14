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

public class ApagTime extends JFrame{
	
JLabel lblTitulo = new JLabel("Informe o ID do Time que você deseja apagar: ");
	
	JLabel lblID = new JLabel("ID: ");
	JTextField txtID = new JTextField();
	
	JButton btnApagar = new JButton("Apagar");
	
	public ApagTime() {
		super("Apagar - Time");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
	
		lblTitulo.setBounds(20, 10, 300, 30);
		paine.add(lblTitulo);
		
		lblID.setBounds(20, 50, 30, 30);
		paine.add(lblID);
		txtID.setBounds(60, 50, 120, 30);
		paine.add(txtID);
		
		btnApagar.setBounds(40, 100, 260, 30);
		paine.add(btnApagar);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setId_time(Integer.parseInt(txtID.getText()));;
										
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.delete(Integer.parseInt(txtID.getText()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(350,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		ApagTime apagar = new ApagTime();
	}
}

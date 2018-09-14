package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;

public class EditPessoa extends JFrame{
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID da Pessoa: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JTextField txtEmail = new JTextField();
	JLabel lblEmail = new JLabel("E-mail: ");

	JTextField txtSexo = new JTextField();
	JLabel lblSexo = new JLabel("Sexo: ");
	
	JRadioButton rbMasc = new JRadioButton("Masculino");
	JRadioButton rbFem = new JRadioButton("Feminino");
	ButtonGroup gpSexo = new ButtonGroup();
		
	JButton btnEditar = new JButton("Editar");
	
	public EditPessoa() {
		super("Editar - Pessoa");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblID);
		paine.add(txtID);	
		lblID.setBounds(30, 10, 100, 30);
		txtID.setBounds(30, 40, 130, 30);
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(30, 70, 70, 30);
		txtNome.setBounds(30, 100, 270, 30);	
		
		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(30, 130, 70, 30);
		txtEmail.setBounds(30, 160, 270, 30);
		
		paine.add(lblSexo);
		lblSexo.setBounds(30, 200, 70, 30);
		
		gpSexo.add(rbMasc);
		gpSexo.add(rbFem);
		paine.add(rbMasc);
		paine.add(rbFem);
		rbMasc.setBounds(30, 220, 100, 30);
		rbFem.setBounds(130, 220, 100, 30);
					
		paine.add(btnEditar);
		btnEditar.setBounds(30, 270, 300, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setId_pessoa(Integer.parseInt(txtID.getText()));
					pessoas.setNome(txtNome.getText());
					pessoas.setEmail(txtEmail.getText());
					if (gpSexo.getSelection() != null) {
						String sexo = "";
						if(rbMasc.isSelected()) {
							pessoas.setSexo("Masculino");
						}
						else {
							pessoas.setSexo("Feminino");
						}
					}
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					pessoasJdbcDAO.update(pessoas, Integer.parseInt(txtID.getText()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(360, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		EditPessoa edP = new EditPessoa();
	}
}
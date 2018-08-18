package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {
	
	JMenuBar barra = new JMenuBar();
	
	JMenu cadastro = new JMenu("Cadastro");
	
	JMenuItem novo = new JMenuItem("Novo");
	JMenuItem editar = new JMenuItem("Editar");
	
	JDesktopPane jdPane = new JDesktopPane();
	//Tela telaCadUsuarios, telaCadTarefas, telaCadTime;
	
	public JanelaPrincipal() {
		getContentPane().add(jdPane);
		
		barra.add(cadastro);
		
		cadastro.add(novo);
		cadastro.add(editar);
		
		setJMenuBar(barra);
		
		novo.addActionListener((ActionListener) this); //tirar o action listener do parenteses
		editar.addActionListener((ActionListener) this);
		
		setSize(800, 600);
		setVisible(true);		
	}
	
	/*
	 public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == novo) {
			if(telaCadUsuarios == null) {
				
			}
		}
	}
	*/

	public static void main(String[] args) {
		JanelaPrincipal jp = new JanelaPrincipal();		
	}

}

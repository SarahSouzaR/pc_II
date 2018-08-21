package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {
	
	//Janela que recebe a barra de menu e abre as outras janelas dentro
	JDesktopPane jdPane = new JDesktopPane();
	//Tela telaCadUsuarios, telaCadTarefas, telaCadTime;
	
	//Barra do menu
	JMenuBar barra = new JMenuBar();
	
	//Componentes da barra
	JMenu menuPessoas = new JMenu("Pessoas");//exibe a lista de pessoas
	JMenu menuTarefas = new JMenu("Tarefas");//exibe a lista de tarefas
	JMenu menuMetodologia = new JMenu("Metodologias");//exibe a lista de metodologias
	JMenu menuTime = new JMenu("Times");//exibe a lista de times
	
	//Itens dos componentes	
	JMenuItem cadPessoa = new JMenuItem("Cadastrar Usuário");//cadastra pessoa
	
	JMenuItem cadTarefa = new JMenuItem("Inserir Tarefa");
	
	JMenuItem cadMetodologia = new JMenuItem("Inserir Metodologia");
	
	JMenuItem cadTime = new JMenuItem("Entrar em um Time");
		
	public JanelaPrincipal() {	
		super ("Scratch Out - Gerenciador de Tarefas");
		
		getContentPane().add(jdPane);
		
		Container paine = this.getContentPane();
		this.setJMenuBar(barra);
		
		barra.add(menuPessoas);
		barra.add(menuTarefas);
		barra.add(menuMetodologia);
		barra.add(menuTime);
				
		menuPessoas.add(cadPessoa);
		cadPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela que abre o cadastro das pessoas;
				CadPessoas cadPessoas = new CadPessoas();
			}
		});
		
		menuTarefas.add(cadTarefa);
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de tarefas
			}
		});
		
		menuMetodologia.add(cadMetodologia);
		cadMetodologia.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de metodologias
			}
		});
		
		menuTime.add(cadTime);
		cadTime.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de Times
			}
		});
		
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setResizable(true);
	}
	
	public static void main(String[] args) {
		JanelaPrincipal jp = new JanelaPrincipal();		
	}
}

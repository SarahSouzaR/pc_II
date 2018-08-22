package view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {
	
	//Janela que recebe a barra de menu e abre as outras janelas dentro
	JDesktopPane jdPane = new JDesktopPane() {
		public void paintComponent(Graphics g) {
			try {
				super.paintComponents(g);
				
				Image img = ImageIO.read(new java.net.URL(
						this.getClass().getResource("imagens/desktop.gif"), "desktop.gif"));
				if(img!=null) {
					g.drawImage(img, 0, 0, 800, 600, this);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	};
	//Tela telaCadUsuarios, telaCadTarefas, telaCadTime;
	
	//Barra do menu
	JMenuBar barra = new JMenuBar();
	
	//Componentes da barra
	JMenu menuPessoas = new JMenu("Pessoas");
	JMenu menuTarefas = new JMenu("Tarefas");//exibe a lista de tarefas
	JMenu menuMetodologia = new JMenu("Metodologias");//exibe a lista de metodologias
	JMenu menuTime = new JMenu("Times");//exibe a lista de times
	
	//Itens dos componentes	
	JMenuItem cadPessoa = new JMenuItem("Cadastrar Usuário");//cadastra pessoa
	JMenuItem listPessoas = new JMenuItem("Lista de Usuários");//exibe a lista de pessoas
	
	JMenuItem cadTarefa = new JMenuItem("Inserir Tarefa");
	JMenuItem listTarefas = new JMenuItem("Lista de Tarefas");
	
	JMenuItem cadMetodologia = new JMenuItem("Inserir Metodologia");
	JMenuItem listMetodologias = new JMenuItem("Lista de Metodologias");
	
	JMenuItem cadTime = new JMenuItem("Entrar em um Time");
	JMenuItem listTimes = new JMenuItem("Lista de Times");
	
	public JanelaPrincipal() {	
		super ("Scratch Out - Gerenciador de Tarefas");
		
		getContentPane().add(jdPane);
		
		Container paine = this.getContentPane();
		this.setJMenuBar(barra);
		
		barra.add(menuPessoas);
		barra.add(menuTarefas);
		barra.add(menuMetodologia);
		barra.add(menuTime);
				
		menuPessoas.add(listPessoas);
		listPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de usuários
			}
		});
		
		menuPessoas.add(cadPessoa);
		cadPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instância da janela que abre o cadastro das pessoas;
				CadPessoas cadPessoas = new CadPessoas();
			}
		});
		
		menuTarefas.add(listTarefas);
		listTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de tarefas
			}
		});
		
		menuTarefas.add(cadTarefa);
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de tarefas
				CadTarefas cadTarefas = new CadTarefas();
			}
		});
				
		menuMetodologia.add(listMetodologias);
		listMetodologias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de metodologias
			}
		});
		
		menuMetodologia.add(cadMetodologia);
		cadMetodologia.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de metodologias
				CadMetodologia cadMetodologia = new CadMetodologia();
			}
		});
		
		menuTime.add(listTimes);
		listTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de times
			}
		});
		
		menuTime.add(cadTime);
		cadTime.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de Times
				CadTime cadTime = new CadTime();
			}
		});
		
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		JanelaPrincipal jp = new JanelaPrincipal();		
	}
}

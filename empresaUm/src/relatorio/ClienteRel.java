package relatorio;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

import model.Clientes;

public class ClienteRel {
	private String path; // Caminho base
	
	private String pathToReportPackage; //Caminho para o package onde estão armazenados os relatorios Jasper

	// Recupera os caminhos para que a classe possa encontrar os relatórios
	
	public ClienteRel() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "relatorio/";
		//System.out.println(path);
	}

	
	// Imprime/gera uma lista de Clientes
		public void imprimir(List<Clientes> clientes) throws Exception {
			System.out.println(this.getPathToReportPackage());
			JasperReport relatorio = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Client.jrxml");
			
			JasperPrint print = JasperFillManager.fillReport(relatorio, null, new JRBeanCollectionDataSource(clientes));

			JasperExportManager.exportReportToPdfFile(print, "d:/Relatorio_de_Clientes.pdf");
		}

		public String getPathToReportPackage() {
			return this.pathToReportPackage;
		}
		
		public String getPath() {
			return this.path;
		}	
}

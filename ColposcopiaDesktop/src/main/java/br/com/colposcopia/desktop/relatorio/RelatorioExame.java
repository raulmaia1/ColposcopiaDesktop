package br.com.colposcopia.desktop.relatorio;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.colposcopia.desktop.bean.ExameColposcopico;
import br.com.colposcopia.desktop.bean.Imagem;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioExame {

	public void gera(ExameColposcopico exame,List<Imagem> imagens) {
		try {
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("logo", "relatorios/logo.png");
			param.put("listaImagens", imagens);
			param.put("descricaoMacro",exame.getDescricaoMacro());
			param.put("dataNascimento",exame.getDataNascimento());
			param.put("dataExame",exame.getDataExame());
			param.put("dataHora", exame.getDataHora()) ;
			param.put("avaliacao",exame.getAvaliacao());
			param.put("nomePaciente",exame.getNomePaciente());
			param.put("achadosColpoNormais",exame.getAchadosColpoNormais());
			param.put("achadosColpoANormais", exame.getAchadosColpoANormais());
			param.put("outroAnormais", exame.getOutroAnormais());
			param.put("conclusao",exame.getConclusao());
			
			JasperReport report = (JasperReport) JRLoader.loadObject(new File("relatorios/exame.jasper"));

			 JasperPrint print = JasperFillManager.fillReport(report, param,
					new JRBeanCollectionDataSource(imagens));
			JasperViewer jv = new JasperViewer(print, false);
			
			jv.setTitle("Relatorios");
			jv.setVisible(true);

		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ExameColposcopico exameColposcopico = new ExameColposcopico();
		exameColposcopico.setAchadosColpoANormais("AA");
		exameColposcopico.setAchadosColpoNormais("AAA");
		exameColposcopico.setAvaliacao("AAAAA");
		exameColposcopico.setConclusao("AAAAAA");
		exameColposcopico.setDataNascimento("10/10/2010");
		exameColposcopico.setNomePaciente("AAAA");
		exameColposcopico.setDescricaoMacro("AAAAA");
		exameColposcopico.setOutroAnormais("AAAAAAA");
		exameColposcopico.setDataExame("10/10/2021");
		
		
		Imagem imagem1 = new Imagem();
		imagem1.setExame(exameColposcopico);
		imagem1.setLocalImagem("/home/edu/Imagens/large_thumbnail.jpg");
		
		Imagem imagem2 = new Imagem();
		imagem2.setExame(exameColposcopico);
		imagem2.setLocalImagem("/home/edu/Imagens/Captura de tela de 2021-11-15 14-26-57.png");
		
		
		new RelatorioExame().gera(exameColposcopico, Arrays.asList(imagem1,imagem2));
		
	}
}

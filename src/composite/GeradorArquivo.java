package composite;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public  abstract class GeradorArquivo {
	
	private Processador processador;
	public GeradorArquivo(Processador processador) {
		this.processador = processador;
	}

	public final void gerarArquivo(String nome, Map<String, Object> propriedades)throws IOException{
		/*
		 * byte[] bytes = null; if (tipo.equals("PROPRIEDADES_CRIPTOGRAFADO")) {
		 * ProcessaPropriedadesCriptografado propCript = new
		 * ProcessaPropriedadesCriptografado(); bytes =
		 * propCript.processaPropriedadeCriptografado(propriedades); }else if
		 * (tipo.equals("XML_COMPACTADO")) { ProcessaXmlCompactado xml = new
		 * ProcessaXmlCompactado(); bytes = xml.processaXmlCompactado(propriedades); }
		 * else { System.out.println("Desconhe�o essa op��o"); }
		 */
		String conteudo = gerarConteudo(propriedades);
		byte[] bytes = processador.processaConteudo(conteudo.getBytes());
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();
	}
	//obrigo o m�todo a exisistir nos filhos
	protected  abstract String gerarConteudo(Map<String, Object> propriedades);
	
	
	//template method
	//classe mae que tem um comportamento geral, quando precisa de algo, os filhos injetam o comportamento necess�rio;
	

	
}

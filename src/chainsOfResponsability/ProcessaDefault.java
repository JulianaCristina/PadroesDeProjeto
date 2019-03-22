package chainsOfResponsability;

import java.io.IOException;

public class ProcessaDefault extends Processador{
	
	public ProcessaDefault(Processador proximo) {
		super(proximo); 
	}
	
	public ProcessaDefault() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected byte[] processaConteudo(byte[] conteudo) throws IOException {
		return conteudo;
	}
	
}

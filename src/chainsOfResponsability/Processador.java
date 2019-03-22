package chainsOfResponsability;

import java.io.IOException;

public abstract class Processador {
	
	private Processador proximoProcessador;
	
	public Processador(Processador proximoProcessador) {
		this.proximoProcessador = proximoProcessador;
	}
	public Processador() {
		this.proximoProcessador =  new ProcessaDefault(null);
	} 
	
	public byte[] processarCadeia(byte[] bytes)throws IOException {
		bytes = processaConteudo(bytes);
		if (proximoProcessador != null) {
			bytes = proximoProcessador.processarCadeia(bytes);
		}
		return bytes;
	}
	protected abstract byte[] processaConteudo(byte[] bytes)  throws IOException;


}

//No composite precisava q uma das classes fosse composta e processa a lista
// já aqui, ele tá embutido dentro do pai.
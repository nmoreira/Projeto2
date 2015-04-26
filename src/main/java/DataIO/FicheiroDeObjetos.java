package DataIO;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheiroDeObjetos {
	
	private	ObjectInputStream iS;
	private ObjectOutputStream oS;
	
	public FicheiroDeObjetos(){
		
	}
	
	/*Método que abre um ficheiro para leitura.	
	 * @param nomeDoFicheiro Nome do ficheiro que se pretende ler.
	 * @throws IOException
	 */
	public void abreLeitura(String nomeDoFicheiro) throws IOException{	
		iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
	}	
	
	
	
	/* Método que abre um ficheiro para escrita.	
	 * @param nomeDoFicheiro Nome do ficheiro onde se pretende escrever.
	 * @throws IOException
	 */
	public void abreEscrita(String nomeDoFicheiro) throws IOException{	
		oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
	}
	
	
	
	/* Método para ler um objeto do ficheiro.	
	 * @return Devolve um objecto lido no ficheiro.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object leObjeto() throws IOException, ClassNotFoundException{	
		return	iS.readObject();
	}
	
	

	/* Método para escrever um objeto no ficheiro.
	 * @param o Objecto que se pretende escrever.
	 * @throws IOException
	 */
	public void escreveObjeto(Object o) throws IOException{	
		oS.writeObject(o);	
	}
	

	/* Método para fechar um ficheiro aberto em modo leitura.
	 * @throws IOException
	 */
	public void fechaLeitura() throws IOException{	
		iS.close();		
	}
	
	
	/* Método para fechar um ficheiro aberto em modo escrita.
	 * @throws IOException
	 */
	public void fechaEscrita() throws IOException{	
		oS.close();	
	}	
	
}

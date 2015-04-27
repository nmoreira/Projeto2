package calculadora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Named;

@Named
public class Estatistica implements Serializable{
	
	
	private static final long serialVersionUID = -8382190444479383697L;
		
	private HashMap <String, Operador> operation = new HashMap<>();
	private List<Entry<String, Operador>> entrada;
	
	public Estatistica() {
		operation.put("+", new Operador("+"));
		operation.put("-", new Operador("-"));
		operation.put("/", new Operador("/"));
		operation.put("*", new Operador("*"));
			
	}
	
	public void recolheEstatistica(String exp){
			
		String [] op = exp.split("\\ ");
		
		for (String string : op) {
			if (string.contains("+"))
				operation.get("+").add();
			else if (string.contains("-"))
				operation.get("-").add();
			else if (string.contains("/"))
				operation.get("/").add();
			else if (string.contains("*"))
				operation.get("*").add();
		}
		
	}

	public List<Entry<String, Operador>> getEntrada() {
		entrada = new ArrayList<Entry<String, Operador>>(operation.entrySet());
		return entrada;
	}
}

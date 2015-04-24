package calculadora;

import java.io.Serializable;


import java.util.ArrayList;

import net.objecthunter.exp4j.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


@Named
@SessionScoped
public class Calc implements Serializable{


	private static final long serialVersionUID = 1L;

	private String exp="";
	private String type="";
	private ArrayList<Entrada> hist;
	
	
	private boolean virgulaValida; // indica se é válido usar a vírgula na expressão
	private boolean operadorValido;
	private boolean existeVirgula; 
	
	public Calc(){
		init();
		hist = new ArrayList<Entrada>();
	}
	
	public ArrayList<Entrada> getHist() {
		return hist;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void read(ActionEvent evento){
		String digit="";
		
		switch(evento.getComponent().getId()){
		case "num0": {			
			digit=novoDigito("0");	
		}break;
		case "num1": {
			digit=novoDigito("1");
		}break;
		case "num2": {
			digit=novoDigito("2");
		}break;
		case "num3": {
			digit=novoDigito("3");
		}break;
		case "num4": {
			digit=novoDigito("4");
		}break;
		case "num5": {
			digit=novoDigito("5");
		}break;
		case "num6": {
			digit=novoDigito("6");
		}break;
		case "num7": {
			digit=novoDigito("7");
		}break;
		case "num8": {
			digit=novoDigito("8");
		}break;
		case "num9": {
			digit=novoDigito("9");			
		}break;
		case "soma": {
			digit=novoOperador("+");		
		}break;
		case "sub": {
			digit=novoOperador("-");
		}break;
		case "mult": {
			digit=novoOperador("*");
		}break;
		case "div": {
			digit=novoOperador("/");
		}break;
		case "virg": {
			if(virgulaValida && existeVirgula == false){
				digit=".";
				virgulaValida = false;
				operadorValido = false;
				existeVirgula = true;
			}
		} break;
		case "igual": {
			if(operadorValido == true){
				String res = opera(exp);
				hist.add(new Entrada(exp,res));
				exp=res;
				init();
				operadorValido = true;
			}
			
		} break;
		
		}
		exp+=digit;

	}
	
	private String novoDigito(String d){
		operadorValido = true;
		if(existeVirgula == false){
			virgulaValida = true;
		}
		return d;
	}
	
	private String novoOperador(String op){
		if(operadorValido){
			operadorValido = false;
			virgulaValida = false;
			existeVirgula = false;
			return op;
		} else return "";
	}
	
	private String opera(String exp){
		double res;
		String out;
		
		Expression e = new ExpressionBuilder(exp).build();
		
		try {
			res = e.evaluate();
			
			if(res%1 != 0)		
				out = Double.toString(res);
			else {
				out = Integer.toString((int) res);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			out=e1.getMessage();
			
		}
				
		return out;
	}
	
	private void init(){
		virgulaValida = false;
		operadorValido = false;
		existeVirgula = false;
	}
	
	public void clearAll(){
		this.exp="";
		init();
	}
	
	public void clearLast(){
		exp=exp.substring(0, exp.length()-1);
	}

	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}



}

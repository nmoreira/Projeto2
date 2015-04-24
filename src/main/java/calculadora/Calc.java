package calculadora;

import java.io.Serializable;


import net.objecthunter.exp4j.*;
//import de.congrace.exp4j.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


@Named
@SessionScoped
public class Calc implements Serializable{


	private static final long serialVersionUID = 1L;

	private String exp="";
	private String type="";
	
	private boolean virgulaValida; // indica se é válido usar a vírgula na expressão
	private boolean operadorValido;
	private boolean existeVirgula; 
	
	public Calc(){
		init();
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
				digit="0";				
				operadorValido = true;
				if(existeVirgula == false){
					virgulaValida = true;
				}
						
		}break;
		case "num1": {
			digit="1";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num2": {
			digit="2";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num3": {
			digit="3";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num4": {
			digit="4";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num5": {
			digit="5";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num6": {
			digit="6";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num7": {
			digit="7";		
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num8": {
			digit="8";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "num9": {
			digit="9";			
			operadorValido = true;
			if(existeVirgula == false){
				virgulaValida = true;
			}
		}break;
		case "soma": {
			if(operadorValido){
				digit="+"; 
				operadorValido = false;
				virgulaValida = false;
				existeVirgula = false;
			}			
		}break;
		case "sub": {
			if(operadorValido){
				digit="-"; 
				operadorValido = false;
				virgulaValida = false;
				existeVirgula = false;
			}
		}break;
		case "mult": {
			if(operadorValido){
				digit="*"; 
				operadorValido = false;
				virgulaValida = false;
				existeVirgula = false;
			}
		}break;
		case "div": {
			if(operadorValido){
				digit="/"; 
				operadorValido = false;
				virgulaValida = false;
				existeVirgula = false;
			}
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
			exp = opera(exp);
			init();
		} break;
		
		}
		exp+=digit;

	}
	
	private String opera(String exp){
		double res;
		String out;
		Expression e = new ExpressionBuilder(exp).build();
		
		res = e.evaluate();
		if(res%1 != 0)		
			out = Double.toString(res);
		else {
			out = Integer.toString((int) res);
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

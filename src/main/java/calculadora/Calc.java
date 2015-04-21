package calculadora;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;


@Named
@SessionScoped
public class Calc implements Serializable{


	private static final long serialVersionUID = 1L;

	private String exp="";
	private String type="simple";


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void read(ActionEvent evento){
		String digit="";

		switch(evento.getComponent().getId()){
		case "num0": digit="0"; break;
		case "num1": digit="1"; break;
		case "num2": digit="2"; break;
		case "num3": digit="3"; break;
		case "num4": digit="4"; break;
		case "num5": digit="5"; break;
		case "num6": digit="6"; break;
		case "num7": digit="7"; break;
		case "num8": digit="8"; break;
		case "num9": digit="9"; break;
		case "soma": digit="+"; break;
		case "sub": digit="-"; break;
		case "mult": digit="*"; break;
		case "div": digit="/"; break;
		case "virg": digit="."; break;
		case "igual": {
		
		}; break;
		
		}
		exp+=digit;

	}
	
	public void clearAll(){
		this.exp="";
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

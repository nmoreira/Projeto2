package calculadora;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class Calc implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String key="";
	private String exp="";
	private String type="";
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	
	
}

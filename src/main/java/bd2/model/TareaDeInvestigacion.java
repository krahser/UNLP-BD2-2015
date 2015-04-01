package bd2.model;

import java.util.Date;

public class TareaDeInvestigacion extends Tarea{
	

	
	private String hipotesis;
	private String resultado;
	
	
	public TareaDeInvestigacion(String desc,Date fecha) {  
		super(desc,fecha);
		hipotesis="";
		resultado="";
	}
	

	public TareaDeInvestigacion() {
		super("",new Date());
		hipotesis="";
		resultado="";
	}


	public String getHipotesis(){
		return hipotesis;
	}
	
	public void setHipotesis(String hip){
		hipotesis=hip;
	}
	
	public String getResultado(){
		return resultado;
	}
	
	public void setResultado(String res){
		resultado=res;
	}
	
}

package bd2.model;

import java.util.Date;

public class TareaDeDesarrollo extends Tarea{

	private String requerimientos;
	
	public TareaDeDesarrollo(String desc,Date fecha){  
		super(desc,fecha);
		requerimientos="";
	}
	

	public TareaDeDesarrollo() {
		super("",new Date());
		requerimientos="";
	}


	public String getRequerimientos(){
		return requerimientos;
	}
	
	public void setRequerimientos(String req){
		requerimientos=req;
	}
	
	

}

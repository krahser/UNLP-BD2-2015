package bd2.model;

import java.util.Date;

public class TareaDeInvestigacion extends Tarea{
	

	
	private String hipotesis;
	private String resultado;
	private Long idTareaDeInvestigacion;
	
	
	public TareaDeInvestigacion(String desc,Date fecha) {  
		super(desc,fecha);
		setHipotesis("");
		setResultado("");
	}
	

	public TareaDeInvestigacion() {
		super("",new Date());
		setHipotesis("");
		setResultado("");
	}


	public String getHipotesis(){
		return hipotesis;
	}
	
	public void setHipotesis(String hip){
		this.hipotesis=hip;
	}
	
	public String getResultado(){
		return resultado;
	}
	
	public void setResultado(String res){
		this.resultado=res;
	}


	public Long getIdTareaDeInvestigacion() {
		return idTareaDeInvestigacion;
	}


	public void setIdTareaDeInvestigacion(Long idTareaDeInvestigacion) {
		this.idTareaDeInvestigacion = idTareaDeInvestigacion;
	}
	
}

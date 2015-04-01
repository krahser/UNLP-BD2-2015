package bd2.model;

import java.util.Date;

public class Paso {
	
	private Date fechaDeIngreso;
	private Pizarra pizarra;
	
	public Paso(Pizarra piz){
		pizarra=piz;
		fechaDeIngreso= new Date();
	}

	public Pizarra getPizarra(){    
		return pizarra;
	}
	
	public void setPizarra(Pizarra piz){
		pizarra=piz;
	}
	
	public Date getFechaDeIngreso(){
		return fechaDeIngreso;
	}
	
	public void setFechaDeIngreso(Date fecha){
		fechaDeIngreso = fecha;
	}
	
	
	
}

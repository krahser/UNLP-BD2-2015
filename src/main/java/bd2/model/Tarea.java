package bd2.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;


public abstract class Tarea {
	
	private boolean completa=false;
	private Date fechaLimite;
	private String descripcion;
	private Collection<Paso> pasos;
	
	public Tarea(String desc,Date fecha){
		pasos = new ArrayList<Paso>();
		fechaLimite = fecha;
		descripcion = desc;
	}
	
	
	public boolean completa(){
		return completa;
	}
	
	public void completar(){
		completa=true;
	}
	
	public Date getFechaLimite(){
		return fechaLimite;
	}
	
	public void setFechaLimite(Date fecha){
		fechaLimite=fecha;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descr){
		descripcion=descr;
	}
	
	public Collection<Paso> getPasos(){
		return pasos;
	}
	
	public boolean vencida(){   
		Calendar fechaActual=new GregorianCalendar();  // Creo un objeto calendario con fecha actual
		Calendar fechaL=new GregorianCalendar();      // Creo un objeto calendario con fecha actual
		fechaL.setTime(fechaLimite);      			 // Le asigno al calendario fechaL el date fechaLimite
		if (fechaActual.after(fechaL)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public void agregarAPizarra(Pizarra pizarra){
		pizarra.agregarTarea(this);
	}
	
}

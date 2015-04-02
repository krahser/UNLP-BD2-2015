package bd2.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Tarea {

	
	/*
	Las tareas se pueden ir moviendo de una pizarra a la otra (por ejemplo “Hacer”
	a “Hecho”), y en ese caso la tarea se guarda un pequeño historial (Paso) que indica
	que se movió a una pizarra en una fecha dada.
	*/

	
	private boolean completa=false;
	private Date fechaLimite;
	private String descripcion;
	private Collection<Paso> pasos;
	
	public Tarea(String desc,Date fecha){
		
		/* En particular, en la clase Tarea instanciar la colección de pasos 
		 * con la clase ArrayList mientras que el resto de las clases hacerlo
		 * con la clase HashSet.
		 */
		
		
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
		
		/*
		 * Se agrega a la pizarra enviada como parámetro. 
		 * Debe registrar este movimiendo generando un nuevo Paso y 
		 * agregándolo a su colección de pasos, con la fecha actual y la pizarra en cuestión.
		 */
		
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
		
		/* 
		 * Se agrega a la pizarra enviada como
		 * 		parámetro. Debe registrar este 
		 *		movimiendo generando un nuevo
		 *	Paso y agregándolo a su colección de pasos, con la fecha actual y la
		 *		pizarra en cuestión.
		 */
		
		pizarra.agregarTarea(this);
	}
	
}

package bd2.model;

import java.util.Collection;
import java.util.HashSet;

public class Pizarra {
	
	private String nombre;
	private Collection<Tarea> tareas;
	
	public Pizarra(String nom){     
		nombre = nom;
		tareas = new HashSet<Tarea>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nom){
		nombre=nom;
	}
	
	public Collection<Tarea> getTareas(){
		return tareas;
	}
	
	
	public void agregarTarea(Tarea tarea){
		/*
		 * Agrega tarea a la pizarra receptora. 
		 * Notar además que la tarea tiene que registrar su incorporación a la pizarra.
		 */
		
		tareas.add(tarea);
		tarea.getPasos().add(new Paso(this));
	}
	
	
	public void eliminarTarea(Tarea tarea){
		if (tareas.contains(tarea)){          
			tareas.remove(tarea);
		}
	}

	
	public void moverTareaAPizarra(Tarea tarea, Pizarra destino){
		/*
		 * Mueve una tarea propia a la pizarra destino. 
		 * Luego de esto, naturalmente, la tarea no debe estar más en la pizarra receptora
		 * sino en destino. Notar además que la tarea tiene que registrar su paso a
		 * la pizarra destino
		 */
		
		
		this.eliminarTarea(tarea);
		destino.agregarTarea(tarea);
	}
}

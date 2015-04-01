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
		tareas.add(tarea);
		tarea.getPasos().add(new Paso(this));
	}
	
	
	public void eliminarTarea(Tarea tarea){
		if (tareas.contains(tarea)){          
			tareas.remove(tarea);
		}
	}

	
	public void moverTareaAPizarra(Tarea tarea, Pizarra destino){
		this.eliminarTarea(tarea);
		destino.agregarTarea(tarea);
	}
}

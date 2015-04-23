package bd2.model;

import java.util.Collection;
import java.util.HashSet;

public class Sitio { 

		/*
		 * El proyecto consiste en un administrador de tareas,
		 * en el mismo hay usuarios y proyectos.
		 */
	
	
		private Collection<Usuario> usuarios;
		private Collection<Proyecto> proyectos;
		private Long idSitio;
		
		public Sitio(){
			usuarios= new HashSet<Usuario>();
			proyectos= new HashSet<Proyecto>();
		}
		
		public Collection<Usuario> getUsuarios(){
			return usuarios;
		}
		
		public void setUsuarios(Usuario usuario){  
			registrarUsuario(usuario);
		}
		
		public void registrarUsuario(Usuario usuario){  
			usuarios.add(usuario);
		}
		
		public Collection<Proyecto> getProyectos(){
			return proyectos;
		}
		
		public void setProyectos(Proyecto proyecto){
			agregarProyecto(proyecto);
		}
		
		public void agregarProyecto(Proyecto proyecto){
			proyectos.add(proyecto);
		}

		public Long getIdSitio() {
			return idSitio;
		}

		public void setIdSitio(Long idSitio) {
			this.idSitio = idSitio;
		}
}

package bd2.model;

import java.util.Collection;
import java.util.HashSet;

public class Sitio {    // TIRA ERROR EL TEST

		
		private Collection<Usuario> usuarios;
		private Collection<Proyecto> proyectos;
		
		public Sitio(){
			usuarios= new HashSet<Usuario>();
			proyectos= new HashSet<Proyecto>();
		}
		
		public Collection<Usuario> getUsuarios(){
			return usuarios;
		}
		
		public void registrarUsuario(Usuario usuario){  
			usuarios.add(usuario);
		}
		
		public Collection<Proyecto> getProyectos(){
			return proyectos;
		}
		
		public void agregarProyecto(Proyecto proyecto){
			proyectos.add(proyecto);
		}
}
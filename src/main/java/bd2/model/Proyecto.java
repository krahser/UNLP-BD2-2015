package bd2.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Proyecto {
	
	
	/*
	 * 	Cada proyecto tiene tareas organizadas en pizarras. Las pizzaras
	 * 	se pueden archivar y no se pueden borrar.
	 * 
	 * 	Los proyectos tienen usuarios comunes y administradores. En particular un
	 * 	administrador es el creador del proyecto y no puede ser eliminado del mismo.
	 * 	Los demas usuarios pueden ser eliminados del proyecto.
	 */
	

	private Collection<Pizarra> pizarras;
	private Collection<Pizarra> pizarrasArchivadas;
	private Collection<PerfilDeUsuario> perfiles;
	
	
	public Proyecto(Usuario creador){  
		/*
		 * Constructor. El usuario enviado como parámetro tiene que 
		 * agregarse al proyecto con perfil de administrador, 
		 * y marcarse como creador.
		 */
		pizarras=new HashSet<Pizarra>();
		pizarrasArchivadas=new HashSet<Pizarra>();
		perfiles=new HashSet<PerfilDeUsuario>();
		Date fecha=new Date();
		perfiles.add(new PerfilDeAdministrador(fecha,creador,true));
	}
	
	public Collection<Pizarra> getPizarras(){
		return pizarras;
	}
	
	public Collection<Pizarra> getPizarrasArchivadas(){
		return pizarrasArchivadas;
	}
	
	public void agregarPizarra(Pizarra pizarra){
		pizarras.add(pizarra);
	}
	
	private void eliminarPizarra(Pizarra pizarra){
		if (pizarras.contains(pizarra)){          
			pizarras.remove(pizarra);
		}
	}
	
	public void archivarPizarra(Pizarra pizarra){
		
		/* 	
		 * Deja de estar en la colección de pizarras y pasa a
		 * la colección de pizarras archivadas.
		 * 
		 */
		
		
		eliminarPizarra(pizarra);
		pizarrasArchivadas.add(pizarra);
	}
	
	public Collection<PerfilDeUsuario> getPerfiles(){
		return perfiles;
	}
	
	
	
	
	public Collection<Usuario> getIntegrantes(){
		
		/*
		 * Genera un perfil de usuario administrador (PerfilDeAdministrador)
		 * con el usuario enviado como parámetro, y lo agrega a la colección
		 * de perfiles.
		 */

		
		HashSet<Usuario> u = new HashSet<Usuario>();
		for (PerfilDeUsuario p: perfiles){
			u.add(p.getUsuario());
		}
		return u;
	}

	
	/*
	 * En los dos metodos siguientes se genera un perfil de usuario 
	 * y lo agrega a la colección de perfiles.
	 */

	
	public void agregarAdministrador(Usuario usuario){
		Date fecha=new Date();
		perfiles.add(new PerfilDeAdministrador(fecha,usuario,false)); 
	}
	
	public void agregarColaborador(Usuario usuario){
		Date fecha=new Date();
		perfiles.add(new PerfilDeUsuario(fecha,usuario));
	}
	
	
	public void eliminarUsuario(Usuario candidato) throws Exception{  
		
		/*
		 * Elimina al usuario enviado como parámetro. Si el usuario que se
		 * desea eliminar es el creador, lanzar una excepción con el mensaje: 
		 * “No se puede eliminar al creador del proyecto”
		 */
		
		
		PerfilDeUsuario perfil= new PerfilDeUsuario(null, null);
		
		for (PerfilDeUsuario p: perfiles){
			if (p.getUsuario() == candidato){
				perfil=p;
				break;
			}
		}
		eliminarPerfil(perfil);
	}
	

	public void eliminarPerfil(PerfilDeUsuario perfil) throws Exception{
		
		if (perfil.esCreador()){
			throw new Exception("No se puede eliminar al creador del proyecto");
		}	
		else{
			perfiles.remove(perfil);
		}
	}
	
	public void setCreador(Usuario usuario){  
		for (PerfilDeUsuario p: perfiles){
			if (p.esCreador()){
				((PerfilDeAdministrador) p).setCreador(false);
			}
		}
		Date fecha=new Date();
		perfiles.add(new PerfilDeAdministrador(fecha,usuario,true)); 
	}
	
	public Usuario getCreador(){
		Usuario u = new Usuario();
		for (PerfilDeUsuario p: perfiles){
			if (p.esCreador()){
				u= p.getUsuario();
			}
		}
		return u;
	}
	
}

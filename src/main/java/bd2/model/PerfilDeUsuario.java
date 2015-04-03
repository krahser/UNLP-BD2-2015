package bd2.model;

import java.util.Date;

public class PerfilDeUsuario {
	
	/*
	 * Esta clase representa los usuarios del sistema
	 */
	
	private Date fechaDeCreacion;
	private Usuario usuario;
	
	
	public PerfilDeUsuario(Date fecha, Usuario usu){
		fechaDeCreacion=fecha;
		usuario=usu;
	}
	
	public Date getFechaDeCreacion(){
		return fechaDeCreacion;
	}
	
	public void setFechaDeCreacion(Date fecha){
		fechaDeCreacion=fecha;
	}
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario u){
		usuario=u;
	}
	
	public boolean esCreador(){
		return false;
	}
	
	public void eliminarDe(Proyecto proyecto) throws Exception{  
		proyecto.eliminarPerfil(this);
	}
	
}

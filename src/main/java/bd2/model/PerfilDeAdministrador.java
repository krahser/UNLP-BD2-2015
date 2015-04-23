package bd2.model;

import java.util.Date;

public class PerfilDeAdministrador extends PerfilDeUsuario {

	/*
	 * El administrador es un tipo de usuario especifico con mayores privilegios
	 */
	
	private boolean creador;
	private Long idPerfilDeAdministrador;
	
	public PerfilDeAdministrador(Date fecha, Usuario usua, boolean cond) {
		//crea un perfil de administrador con la fecha, el usuario y la condicion booleana 
		//pasados como parametros
		super(fecha, usua);
		setCreador(cond);
	}
	
	public PerfilDeAdministrador(){         //Constructor sin parámetros
		super(new Date(), null);
		setCreador(false);
	}
	
	public void setCreador(boolean cond){
		creador=cond;
	}
	
	public boolean esCreador(){
		return creador;
	}

	public Long getIdPerfilDeAdministrador() {
		return idPerfilDeAdministrador;
	}

	public void setIdPerfilDeAdministrador(Long idPerfilDeAdministrador) {
		this.idPerfilDeAdministrador = idPerfilDeAdministrador;
	}

}

package bd2.model;

import java.util.Date;

public class PerfilDeAdministrador extends PerfilDeUsuario {

	/*
	 * El administrador es un tipo de usuario especifico con mayores privilegios
	 */
	
	private boolean creador;
	
	
	public PerfilDeAdministrador(Date fecha, Usuario usua, boolean cond) {
		super(fecha, usua);
		creador=cond;
	}
	
	public void setCreador(boolean cond){
		creador=cond;
	}
	
	public boolean esCreador(){
		return creador;
	}

}

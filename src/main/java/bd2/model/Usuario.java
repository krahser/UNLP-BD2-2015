package bd2.model;

public class Usuario {
	
	private String email;
	private String nombre;
	
	public Usuario(String e, String n){
		email=e;
		nombre=n;
	}
	
	public Usuario(){
		email="";
		nombre="";
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String e){
		email=e;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nom){
		nombre=nom;
	}
	

	

}

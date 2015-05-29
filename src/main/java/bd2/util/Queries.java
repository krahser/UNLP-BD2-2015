package bd2.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.model.Pizarra;
import bd2.model.Tarea;

public class Queries {
	
	private static SessionFactory sessions;
	
	public static void main(String args[]){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		sessions = cfg.buildSessionFactory();
		//listarNombresPizarras();
		//listarDescrpicionTareasLike("read");
		//listarPizarraMaxTareas();
		listarEmailAdminPizArch();
	}
	
	public static void listarNombresPizarras(){
		List<Pizarra> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select nombre from Pizarra");
			lista = (List<Pizarra>) q.list();
			tx.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} 
		finally {
			session.close();
		}
		imprimirListarNombresPizarras(lista);
	}
	
	public static void imprimirListarNombresPizarras(List<Pizarra> lista){
		imprimirFormato("Listar los nombres de todas las pizarras. Imprimir en consola:'Pizarra:<nombre>'");
		for (int i=0; i<lista.size(); i++){
			System.out.println("Pizarra:"+lista.get(i));
		}
		System.out.println("------------------------------------------------------------------------");
	}
	
	public static void listarDescrpicionTareasLike(String desc){
		List<Tarea> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select descripcion from Tarea t where t.descripcion LIKE CONCAT('%', :desc, '%')").setString("desc", desc);
			lista = (List<Tarea>) q.list();
			tx.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} 
		finally {
			session.close();
		}
		imprimirListarDescrpicionTareasLike(lista);
	}
	
	public static void imprimirListarDescrpicionTareasLike(List<Tarea> lista){
		imprimirFormato("Listar las tareas cuya descripción contenga una secuencia específica de caracteres (enviada como parámetro), Imprimir en consola:Tarea:<descripcion>");
		for (int i=0; i<lista.size(); i++){
			System.out.println("Tarea:"+lista.get(i));
		}
		System.out.println("------------------------------------------------------------------------");
	}
	
	
	public static void listarPizarraMaxTareas(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select (count(p.idPizarra)), p.nombre as cant from Pizarra p join p.tareas t group by p order by cant desc");
			q.setMaxResults(1);
			lista = (List<Object[]>) q.list();
			//((List<Object[]>)q.list()).get(0)[0]
			tx.commit();	
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
		imprimirListarPizarraMaxTareas(lista);
	}
	
	public static void imprimirListarPizarraMaxTareas(List<Object[]> lista){
		imprimirFormato("Obtener la pizarra que tenga más tareas. Imprimir en consola:'Pizarra con más tareas:<nombre>(<cantidad de tareas> tareas)'");
		System.out.println("Pizarra con más tareas: "+lista.get(0)[1]+" ("+lista.get(0)[0]+" tareas)");
		System.out.println("------------------------------------------------------------------------");
	}
	
	@SuppressWarnings("unchecked")
	public static void listarEmailAdminPizArch(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select pda.usuario.email from Proyecto p,PerfilDeAdministrador pda  where p.pizarrasArchivadas is not empty");
			lista = (List<Object[]>) q.list();
			//((List<Object[]>)q.list()).get(0)[0]
			tx.commit();	
		} 
		catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
		imprimirListarEmailAdminPizArch(lista);
	}
	
	public static void imprimirListarEmailAdminPizArch(List<Object[]> lista){
		imprimirFormato("Obtener los emails de los administradores de los proyectos que tengan al menos una pizarra archivada. Imprimir 'Administrador:<email>'.");
		System.out.println(lista.get(0));
		System.out.println("------------------------------------------------------------------------");
	}
	
	public static void imprimirFormato(String consulta){
		System.out.println("------------------------------------------------------------------------");
		System.out.println(consulta);
		System.out.println("------------------------------------------------------------------------");
	}
	
}


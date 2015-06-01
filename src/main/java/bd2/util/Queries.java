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
	
	/*******Main y funciones auxiliares********/
	
	private static SessionFactory sessions;

	public static void main(String args[]){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		sessions = cfg.buildSessionFactory();
		listarNombresPizarras();
		listarDescrpicionTareasLike("read");
		listarPizarraMaxTareas();
		listarEmailAdminPizArch();
		listarTareasCambiadasDePizarra("backlogproyecto8149");
	}

	public static void imprimirFormato(String consulta){
		System.out.println("------------------------------------------------------------------------");
		System.out.println(consulta);
		System.out.println("------------------------------------------------------------------------");
	}

	
	public static void imprimirTuplas(String etiqueta, List<Object[]> lista){
	for (int i=0; i<lista.size(); i++){
		System.out.println(etiqueta+lista.get(i));
				//[0] + "" + lista.get(i)[1]);
		}
	System.out.println("------------------------------------------------------------------------");
	}
	
	/*********** Consulta A***********/
	public static void listarNombresPizarras(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select nombre from Pizarra");
			lista = (List<Object[]>) q.list();
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
	
	public static void imprimirListarNombresPizarras(List<Object[]> lista){
		imprimirFormato("Listar los nombres de todas las pizarras. Imprimir en consola:'Pizarra:<nombre>'");
		imprimirTuplas("Pizarra:", lista);
	}
	
	/*********** Consulta B***********/
	public static void listarDescrpicionTareasLike(String desc){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select descripcion from Tarea t where t.descripcion LIKE CONCAT('%', :desc, '%')").setString("desc", desc);
			lista = (List<Object[]>) q.list();
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
	
	public static void imprimirListarDescrpicionTareasLike(List<Object[]> lista){
		imprimirFormato("Listar las tareas cuya descripción contenga una secuencia específica de caracteres (enviada como parámetro), Imprimir en consola:Tarea:<descripcion>");
		imprimirTuplas("Tarea: ", lista);
	}
	
	
	/*********** Consulta C***********/
	public static void listarPizarraMaxTareas(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select p.tareas.size as cantidad, p.nombre as nombre from Pizarra p inner join p.tareas group by p order by cantidad desc, nombre desc");
			q.setMaxResults(1);
			lista = (List<Object[]>) q.list();
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
	
	/*********** Consulta D***********/
	public static void listarEmailAdminPizArch(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select pda.usuario.email from Proyecto p,PerfilDeAdministrador pda  where p.pizarrasArchivadas is not empty");
			lista = (List<Object[]>) q.list();
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
		imprimirTuplas("Administrador:", lista);
	}
	/*********** Consulta E***********/
	public static void listarTareasCambiadasDePizarra(String desc){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select t.descripcion from Tarea t  inner join t.pasos as p inner join p.pizarra pi where pi.nombre LIKE CONCAT('%', :desc, '%')").setString("desc", desc);
			lista = (List<Object[]>) q.list();
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
		imprimirListarTareasCambiadasDePizarra(lista);

	}
	public static void imprimirListarTareasCambiadasDePizarra(List<Object[]> lista){
		imprimirFormato("Obtener las tareas que hayan pasado por la pizarra cuyo nombre contenga una secuencia de caracteres enviada como parámetro. Imprimir	“Tarea:<descripción>”");
		imprimirTuplas("Tarea: ", lista);
	}
	/*********** Consulta F***********/
	public void listarPizzarraDeInvestigacionYDesarrollo(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select pda.usuario.email from Proyecto p,PerfilDeAdministrador pda  where p.pizarrasArchivadas is not empty");
			lista = (List<Object[]>) q.list();
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
		imprimirListarPizarraDeInvestigacionYDesarrollo(lista);

	}
	
	public static void imprimirListarPizarraDeInvestigacionYDesarrollo(List<Object[]> lista){
		imprimirFormato("Obtener las tareas que hayan sido cambiadas de pizarra más de un número veces enviado" + 
				"como parámetro Imprimir “Tarea: <descripción> (<cantidad de pasos> pasos)”");
		System.out.println("Tarea: "+lista.get(0)[1]+" ("+lista.get(0)[0]+" tareas)");
		System.out.println("------------------------------------------------------------------------");
	}

	/*********** Consulta G***********/
	public void listarTareasVencidasEnMarzo(){
		List<Object[]> lista = null;
		Session session = sessions.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select pda.usuario.email from Proyecto p,PerfilDeAdministrador pda  where p.pizarrasArchivadas is not empty");
			lista = (List<Object[]>) q.list();
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
		imprimirListarTareasVencidasEnMarzo(lista);

	}
	public static void imprimirListarTareasVencidasEnMarzo(List<Object[]> lista){
		imprimirFormato("Obtener las pizarras que tengan tareas vencidas en marzo  es decir " +
					"que sus fechas límite estén dentro marzo de 2015 y no estén completas" +
				    "Imprimir “Pizarra  <nombre>");
		System.out.println("Pizarra con más tareas: "+lista.get(0)[1]+" ("+lista.get(0)[0]+" tareas)");
		System.out.println("------------------------------------------------------------------------");
	}
}


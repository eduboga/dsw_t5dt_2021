package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Usuario;

public class Demo_03 {

public static void main(String[] args) {
		
		//similar a Dao factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("msyql");
		// similar al objeto dao
		EntityManager em = fabrica.createEntityManager();
		
		//proceso-> registtrp nuevo
		
		Usuario u = em.find(Usuario.class, 100);
		
		
		if(u == null) {
			System.out.println("Usuario no Existe");
		}else {
			System.out.println(u);
			
			em.getTransaction().begin();
			em.remove(u);// eliminar
			em.getTransaction().commit();
			
		}
		
	}
	
	
	
	
	
	
	
	
}

package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Usuario;

public class Demo_01 {

	public static void main(String[] args) {
		
		//similar a Dao factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("msyql");
		// similar al objeto dao
		EntityManager em = fabrica.createEntityManager();
		
		//proceso-> registtrp nuevo
		
		Usuario u = new Usuario();
		
		u.setCodigo(100);
		u.setNombre("Eren");
		u.setApellido("Ackerman");
		u.setUsuario("ere2n@titan.pe");
		u.setClave("123");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		em.persist(u);// registrar
		em.getTransaction().commit();
		em.close();
		
	}
}

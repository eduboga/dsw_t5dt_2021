package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Producto;

public class Prod_01 {

public static void main(String[] args) {
		
		//similar a Dao factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("msyql");
		// similar al objeto dao
		EntityManager em = fabrica.createEntityManager();
		
		//proceso-> registtrp nuevo
		
		Producto p = new Producto();
		
		p.setIdprod("40");
		p.setDescripcion("Prod_40");
		p.setIdcategoria(1);
		p.setEstado(1);
		p.setStock(100);
		p.setPrecio(0.90);
		
		em.getTransaction().begin();
		em.persist(p);// registrar
		em.getTransaction().commit();
		em.close();
		
	}
}

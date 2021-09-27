package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Usuario;

public class Demo_08 {

public static void main(String[] args) {
		
		//similar a Dao factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("msyql");
		// similar al objeto dao
		EntityManager em = fabrica.createEntityManager();
		
		//proceso-> validar usando usuario y clave: login sin pro almacenado
		
		String sql = "SELECT u FROM Usuario u where u.usuario = :xusr and u.clave = :xcla";
		TypedQuery<Usuario>query = em.createQuery(sql, Usuario.class);
		query.setParameter("xusr", "U001@gmail.com");
		query.setParameter("xcla", "10001");
		
		
		//ejecuta la consulta y obten el resultado
		Usuario u = query.getSingleResult();
				
	
		
		em.close();
		
		if(u == null) {
			System.out.println("Usuario no Existe O clave incorrecta");
		}else {
			System.out.println("Bienvenido " + u.getNombre());
		}
		
	}
	
	
	
	
	
	
	
}

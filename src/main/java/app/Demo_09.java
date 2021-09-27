package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Model.Usuario;

public class Demo_09 {

public static void main(String[] args) {
		
		//similar a Dao factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("msyql");
		// similar al objeto dao
		EntityManager em = fabrica.createEntityManager();
		
		//proceso-> validar usando usuario y clave: login con pro almacenado
		
		//String sql = "{call usp_validaAcceso (?, ?)}";
		String sql = "{call usp_validaAcceso (:xusr, :xcla)}";
		
		Query query = em.createNativeQuery(sql, Usuario.class);
		query.setParameter("xusr", "U001@gmail.com");
		query.setParameter("xcla", "10001");
		
		
		//ejecuta la consulta y obten el resultado
		Usuario u = (Usuario) query.getSingleResult();
				
	
		
		em.close();
		
		if(u == null) {
			System.out.println("Usuario no Existe O clave incorrecta");
		}else {
			System.out.println("Bienvenido " + u.getNombre());
		}
	
}
}

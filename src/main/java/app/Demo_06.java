package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Usuario;

public class Demo_06 {


public static void main(String[] args) {
		
		//similar a Dao factory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("msyql");
		// similar al objeto dao
		EntityManager em = fabrica.createEntityManager();
		
		//proceso-> listar
		
		//em.createQuery("sentencia de consulta JPQL",claseDeResultado)
		
		List<Usuario> lstUsuario = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
		System.out.println("Cantidad de usuarios: " + lstUsuario.size());
		for (Usuario u : lstUsuario) {
			System.out.println(u);
		}
		
		System.out.println("........................");
		
		//define la cadena 
		String sql = "SELECT u FROM Usuario u where u.tipo = :xtipo";
		//prepara la consulta
		TypedQuery<Usuario>query = em.createQuery(sql, Usuario.class);
		//stear los parametros
		query.setParameter("xtipo", 2);
		//ejecuta la consulta y convierte en un list
		List<Usuario> lstUsuario2 = query.getResultList();
		System.out.println("Cantidad de usuarios: " + lstUsuario2.size());
		for (Usuario u : lstUsuario2) {
			System.out.println(u);
		}
		
		System.out.println("........................");
		
		
		
		
		//TypedQuery<Usuario> t =  em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		//List<Usuario> ltUsuarios = t.getResultList();
		
		
		em.close();
		
	
	}
	
	
	
	
	
	
}

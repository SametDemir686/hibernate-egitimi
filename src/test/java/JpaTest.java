import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {
    @Test
    public void testJpaSetup() {
        EntityManager entityManager = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // TODO
        transaction.commit();
        entityManager.close();
        JpaConfig.getEntityManagerFactory().close();
    }
}

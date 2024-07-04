package config;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateCofigTest {

    @Test
    public void testSetup() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB İşlemleri

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

package embedded;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestEmbedded {
    @Test
    public void testEmbedded() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        User_ user = new User_();
        user.setName("Samet Demir");
        user.setAddress(new Address("06", "Atatürk Caddesi", "Ankara"));

        session.persist(user);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

}

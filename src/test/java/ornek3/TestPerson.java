package ornek3;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import ornek2.Article;
import ornek2.Status;
import ornek2.Type;

import java.util.List;
import java.util.Set;

public class TestPerson {
    @Test
    public void testAddress() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Person person = new Person();
        person.setName("Samet");
        person.setSurname("Demir");
        person.setAddresses(List.of("Adres 1", "Adres 2", "Adres 3"));

        session.persist(person);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

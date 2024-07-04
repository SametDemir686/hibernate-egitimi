package onetomany;

import config.HibernateConfig;
import onetoone.User;
import onetoone.UserDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class OneToManyTest {

    @Test
    public void test() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Project project = new Project("Hibernate", "Eğitim");
        project.addTask(new Task(Date.from(Instant.now()), Date.from(Instant.now())));
        project.addTask(new Task(Date.from(Instant.now()), Date.from(Instant.now())));
        session.persist(project);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

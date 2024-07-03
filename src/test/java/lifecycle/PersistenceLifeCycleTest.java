package lifecycle;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistenceLifeCycleTest {
    @Test
    public void persistAndThenUpdate() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student("SAMET", "DEMİR", 10);
        session.save(student);

        student.setAge(20);

        assertEquals(10, session.get(Student.class, student.getId()).getAge());

        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void persistThenDetachAndThenUpdate() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student("SAMET", "DEMİR", 10);
        session.save(student);

        session.detach(student);

        student.setAge(20);

        assertEquals(20, session.get(Student.class, student.getId()).getAge());

        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updatingInTransientState() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student("SAMET", "DEMİR", 10);
        student.setAge(20);

        assertEquals(20, session.get(Student.class, 2L).getAge());

        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void persistUpdateAndCheckInDifferentTransactions() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Student student = new Student("SAMET", "DEMİR", 10);
        session.persist(student);
        tx.commit();

        Transaction tx2 = session.beginTransaction();
        Student persistentStudent = session.get(Student.class, student.getId());
        persistentStudent.setAge(20);
        tx2.commit();

        Transaction tx3 = session.beginTransaction();
        assertEquals(20, session.get(Student.class, student.getId()).getAge());
        tx3.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void updatingInTransientStat12e() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Student student = new Student("SAMET", "DEMİR", 10);
        session.persist(student);
        tx.commit();

        session.clear();

        Transaction tx2 = session.beginTransaction();
        Student persistentStudent = session.get(Student.class, student.getId());
        persistentStudent.setAge(20);
        tx2.commit();

        session.clear();

        Transaction tx3 = session.beginTransaction();
        assertEquals(20, session.get(Student.class, student.getId()).getAge());
        tx3.commit();

        session.close();
        sessionFactory.close();
    }
}

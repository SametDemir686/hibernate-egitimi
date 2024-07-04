package ornek1;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCar {

    @Test
    public void testPersist() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Car car = new Car("AUDI", "R8", "Sarı");
        session.persist(car);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

    @Test
    public void testFind() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Car car = session.get(Car.class, 1L);

        assertEquals("AUDI", car.getTip());

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

    @Test
    public void testUpdate() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Car car = session.get(Car.class, 1L);
        car.setTip("BMW");

        session.flush();
        session.clear();

        Car updatedCar = session.get(Car.class, 1L);
        assertEquals("BMW", updatedCar.getTip());

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

    @Test
    public void testUpdate2() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Car car = new Car("BMW", "i8", "Kırmızı");

        session.persist(car);
        car.setColor("Mavi");

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

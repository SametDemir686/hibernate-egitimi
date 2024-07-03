package sql;

import config.HibernateConfig;
import mapping.manytoone.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NativeSql {

    @Test
    public void testInsert() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "INSERT INTO course (title, credits) VALUES (:title, :credits)";
        Query query = session.createNativeQuery(sql);
        query.setParameter("title", "Native Insert");
        query.setParameter("credits", 10);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Test
    public void testDelete() {
        Session session = HibernateConfig.getSessionFactory().openSession();

        Transaction insertTx = session.beginTransaction();
        session.persist(new Course("Native Delete Example", 20, null));
        insertTx.commit();

        Transaction tx = session.beginTransaction();

        String sql = "DELETE FROM course where title=:title";
        NativeQuery nativeQuery = session.createNativeQuery(sql);
        nativeQuery.setParameter("title", "Native Delete Example");
        nativeQuery.executeUpdate();

        tx.commit();
        session.close();
    }

    @Test
    public void testUpdate() {
        Session session = HibernateConfig.getSessionFactory().openSession();

        Transaction insertTx = session.beginTransaction();
        session.persist(new Course("Native Update Example", 20, null));
        insertTx.commit();
        Transaction tx = session.beginTransaction();

        String sql = "UPDATE course set title='THIS IS THE NEW TITLE' where title=:title";
        NativeQuery nativeQuery = session.createNativeQuery(sql);
        nativeQuery.setParameter("title", "Native Update Example");
        nativeQuery.executeUpdate();

        tx.commit();
        session.close();
    }

    @Test
    public void testSelect() {
        Session session = HibernateConfig.getSessionFactory().openSession();

        Transaction insertTx = session.beginTransaction();
        session.persist(new Course("Native Select Example", 20, null));
        insertTx.commit();
        Transaction tx = session.beginTransaction();

        String sql = "select * from course where title=:title";
        NativeQuery<Course> nativeQuery = session.createNativeQuery(sql, Course.class);
        nativeQuery.setParameter("title", "Native Select Example");
        List<Course> resultList = nativeQuery.getResultList();

        assertEquals(1, resultList.size());
        assertEquals("Native Select Example", resultList.get(0).getTitle());

        tx.commit();
        session.close();
    }
}

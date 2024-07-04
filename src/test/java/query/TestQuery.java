package query;

import config.HibernateConfig;
import manytomany.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TestQuery {
    @Test
    public void sql() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // "'';drop table author"
        String SQL = "SELECT * FROM AUTHOR WHERE NAME=:name";
        NativeQuery<Author> nativeQuery = session.createNativeQuery(SQL, Author.class);
        nativeQuery.setParameter("name", "Author 1");
        List<Author> resultList = nativeQuery.getResultList();
        System.out.println(resultList);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

    @Test
    public void hql() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        String HQL = "FROM Author a WHERE a.name = :name";
        Query<Author> query = session.createQuery(HQL, Author.class);
        query.setParameter("name", "Author 1");
        List<Author> resultList = query.list();
        System.out.println(resultList);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

    @Test
    public void criteria() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        criteriaQuery.select(criteriaQuery.from(Author.class))
                .where();

        Query<Author> query = session.createQuery(criteriaQuery);
        // TODO
        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

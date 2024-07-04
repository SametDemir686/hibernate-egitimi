package ornek2;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import ornek1.Car;

import java.io.Serializable;

public class TestArticle {
    @Test
    public void testArticle() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Article article = new Article();
        article.setType(Type.INTERNAL);
        article.setStatus(Status.APPROVED);
        article.setTitle("My Title");
        article.setContent("SHOULD NOT BE IN DB");

        session.persist(article);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

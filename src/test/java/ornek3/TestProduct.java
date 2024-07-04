package ornek3;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestProduct {
    @Test
    public void testProduct() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Product product = new Product();
        product.setName("PRODUCT NAME");
        product.setProductCodes(Map.of(
                "ABC", "XXX",
                "BCD", "YYY"
        ));

        session.persist(product);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

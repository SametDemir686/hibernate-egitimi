package onetoone;

import config.HibernateConfig;
import embedded.Address;
import embedded.User_;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class OneToOneTest {

    @Test
    public void test() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        UserDetail userDetail = new UserDetail("samet_demir@tubitak.gov.tr", "Adres", "05555555555");
        User user = new User("Samet Demir", userDetail);
        userDetail.setUser(user);

        session.persist(user);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

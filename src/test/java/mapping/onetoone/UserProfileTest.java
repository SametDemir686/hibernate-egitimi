package mapping.onetoone;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserProfileTest {
    @Test
    public void testUserProfile() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        User user = new User();
        user.setUserName("TEST USERNAME");
        user.setPassword("TEST PASSWORD");

        UserProfile userProfile = new UserProfile();
        userProfile.setName("Samet");
        userProfile.setSurname("Demir");
        userProfile.setEmail("samet_demir@tubitak.gov.tr");
        userProfile.setUser(user);

        user.setUserProfile(userProfile);
        session.save(userProfile);
        session.save(user);
        transaction.commit();


        UserProfile userProfileDb = session.get(User.class, user.getId()).getUserProfile();
        assertEquals("Samet", userProfileDb.getName());
        assertEquals("Demir", userProfileDb.getSurname());
        assertEquals("samet_demir@tubitak.gov.tr", userProfileDb.getEmail());

        session.close();
        sessionFactory.close();
    }
}

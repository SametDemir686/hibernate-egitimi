package mapping.manytoone;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

public class AuthorCoursesTest {
    @Test
    public void testLecturerAndCourses() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Lecturer lecturer = new Lecturer();
        lecturer.setName("Lecturer 1");
        lecturer.setDepartment("CS");
        Course course1 = new Course("Course 1", 10, lecturer);
        Course course2 = new Course("Course 2", 20, lecturer);

        lecturer.setCourses(Set.of(course1, course2));

        session.persist(lecturer);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

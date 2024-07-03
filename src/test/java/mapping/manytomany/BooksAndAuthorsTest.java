package mapping.manytomany;

import config.HibernateConfig;
import mapping.manytoone.Course;
import mapping.manytoone.Lecturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

public class BooksAndAuthorsTest {
    @Test
    public void testBooksAndAuthors() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Author author1 = new Author();
        author1.setName("Author 1");

        Author author2 = new Author();
        author2.setName("Author 2");

        Book book1 = new Book("Book 1");
        Book book2 = new Book("Book 2");

        author1.addBook(book1);
        author1.addBook(book2);
        author2.addBook(book1);

        session.persist(author1);
        session.persist(author2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

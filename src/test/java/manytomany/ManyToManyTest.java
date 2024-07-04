package manytomany;

import config.HibernateConfig;
import onetomany.Project;
import onetomany.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class ManyToManyTest {

    @Test
    public void test() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // DB işlemleri
        Author author1 = new Author("Author 1");
        Book book1 = new Book("Book 1");
        Book book2 = new Book("Book 2");
        Book book3 = new Book("Book 3");
        Book book4 = new Book("Book 4");
        Book book5 = new Book("Book 5");

        author1.addBook(book1);
        author1.addBook(book2);
        author1.addBook(book3);

        Author author2 = new Author("Author 2");
        author2.addBook(book4);
        author2.addBook(book5);

        session.persist(author1);
        session.persist(author2);
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);
        session.persist(book5);

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }

    @Test
    public void testFetch() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Author author = session.find(Author.class, 1L);
        session.clear();
        System.out.println(author.getBooks());

        tx.commit();
        session.close();
        HibernateConfig.getSessionFactory().close();
    }
}

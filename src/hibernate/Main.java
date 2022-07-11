package hibernate;

import hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {

        // disable some logging
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // configuration for hibernate
                .addAnnotatedClass(Student.class) // adds the student class for hibernate to use
                .buildSessionFactory(); // builds the one sessionFactory for the application

        Session session = factory.getCurrentSession();
//        Session session = factory.openSession();

        try{
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            System.out.println(student);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}

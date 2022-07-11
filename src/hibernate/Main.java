package hibernate;

import hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;
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

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student first name: ");
            String firstName = scanner.next();
            System.out.print("Enter student last name: ");
            String lastName = scanner.next();
            String email = null;
            try{
                System.out.print("Enter student email: ");
                email = scanner.next("[\\w\\d]+@\\w+\\.com");
            } catch (Exception e){
                System.out.println("You must enter in a valid email, exiting...");
            }


            // save the new student in the db
            Student newStudent = new Student(firstName, lastName, email);
            session.save(newStudent);

            System.out.printf("New Student created with primary key of %d\n", newStudent.getId());
            System.out.println(newStudent);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}

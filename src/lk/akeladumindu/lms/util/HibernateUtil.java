package lk.akeladumindu.lms.util;

import lk.akeladumindu.lms.entity.Book;
import lk.akeladumindu.lms.entity.Laptop;
import lk.akeladumindu.lms.entity.Program;
import lk.akeladumindu.lms.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private final static SessionFactory sessionFactory = buidSessionFactory();
    private static HibernateUtil hibernateUtil;

    private HibernateUtil() {

    }

    public static HibernateUtil getInstance() {
        return (hibernateUtil == null?hibernateUtil=new HibernateUtil():hibernateUtil);
    }

    private static SessionFactory buidSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();


        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Book.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }


    public Session getSession() {
        return sessionFactory.openSession();
    }


}

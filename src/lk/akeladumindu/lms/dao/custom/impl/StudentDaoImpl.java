package lk.akeladumindu.lms.dao.custom.impl;

import lk.akeladumindu.lms.dao.custom.StudentDao;
import lk.akeladumindu.lms.entity.Student;
import lk.akeladumindu.lms.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void save(Student student) throws SQLException, ClassNotFoundException {
        try(Session session = HibernateUtil.getInstance().getSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Student find(Long aLong) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(Long aLong) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Student> findAll(Student student) throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }
}
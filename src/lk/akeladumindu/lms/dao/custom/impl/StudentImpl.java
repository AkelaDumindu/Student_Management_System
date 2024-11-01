package lk.akeladumindu.lms.dao.custom.impl;

import lk.akeladumindu.lms.dao.custom.StudentDao;
import lk.akeladumindu.lms.entity.Student;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class StudentImpl implements StudentDao {
    @Override
    public void save(Student student) throws SQLException, ClassNotFoundException {

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

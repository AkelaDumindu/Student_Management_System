package lk.akeladumindu.lms.dao.custom.impl;

import lk.akeladumindu.lms.dao.custom.ProgramDao;
import lk.akeladumindu.lms.entity.Program;
import lk.akeladumindu.lms.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProgramDaoImpl implements ProgramDao {

    @Override
    public void save(Program program) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            session.beginTransaction();
            session.save(program);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Program program) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Program find(Long aLong) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(Long aLong) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Program> findAll() throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }
}

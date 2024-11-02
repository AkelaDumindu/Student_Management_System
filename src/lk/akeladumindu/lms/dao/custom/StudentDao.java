package lk.akeladumindu.lms.dao.custom;

import lk.akeladumindu.lms.dao.CrudDao;
import lk.akeladumindu.lms.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao extends CrudDao<Student, Long> {


//    List<Student> findAll(Student student) throws SQLException, ClassNotFoundException;
}

package lk.akeladumindu.lms.bo.custom.impl;

import lk.akeladumindu.lms.dao.DaoFactory;
import lk.akeladumindu.lms.dao.custom.StudentDao;
import lk.akeladumindu.lms.dto.StudentDto;
import lk.akeladumindu.lms.entity.Student;

import java.sql.SQLException;

public class StudentBoImpl {

    private final StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.save(student);

    }


}

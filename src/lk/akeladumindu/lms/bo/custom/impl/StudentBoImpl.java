package lk.akeladumindu.lms.bo.custom.impl;

import lk.akeladumindu.lms.bo.custom.StudentBo;
import lk.akeladumindu.lms.dao.DaoFactory;
import lk.akeladumindu.lms.dao.custom.StudentDao;
import lk.akeladumindu.lms.dto.StudentDto;
import lk.akeladumindu.lms.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentBoImpl implements StudentBo {

    private final StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.save(student);

    }

    @Override
    public List<StudentDto> findAllStudent() throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public void deleteStudentById(long id) throws SQLException, ClassNotFoundException {

    }

    public List<StudentDto> findAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDto> dtos = new ArrayList<>();
        for (Student s:studentDao.findAll()){
            StudentDto dto = new StudentDto(
                    s.getId(),s.getName(),s.getContact()
            );
            dto.setBooks(s.getBooks());
            dto.setLaptop(s.getLaptop());
            dtos.add(dto);
        }
        return dtos;
    }

    public void deleteStudentId(long id) throws SQLException, ClassNotFoundException {
        studentDao.delete(id);
    }

    public void updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException {

            Student student = new Student();
            student.setId(dto.getId());
            student.setName(dto.getName());
            student.setContact(dto.getContact());
            studentDao.update(student);

    }

}

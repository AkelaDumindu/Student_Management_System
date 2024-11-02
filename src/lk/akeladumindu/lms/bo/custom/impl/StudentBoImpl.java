package lk.akeladumindu.lms.bo.custom.impl;

import lk.akeladumindu.lms.dao.DaoFactory;
import lk.akeladumindu.lms.dao.custom.StudentDao;
import lk.akeladumindu.lms.dto.StudentDto;
import lk.akeladumindu.lms.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl {

    private final StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.save(student);

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


}

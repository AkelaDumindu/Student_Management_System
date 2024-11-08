package lk.akeladumindu.lms.bo.custom;

import lk.akeladumindu.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentBo {

    //    public void saveStudent(StudentDto dto);
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;

    public List<StudentDto> findAllStudent() throws SQLException, ClassNotFoundException;

    public void deleteStudentById(long id) throws SQLException, ClassNotFoundException;

    public void updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException;


}
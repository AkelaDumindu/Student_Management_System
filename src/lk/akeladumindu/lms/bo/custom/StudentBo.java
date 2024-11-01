package lk.akeladumindu.lms.bo.custom;

import lk.akeladumindu.lms.dto.StudentDto;

import java.sql.SQLException;

public interface StudentBo {

//    public void saveStudent(StudentDto dto);
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;
}
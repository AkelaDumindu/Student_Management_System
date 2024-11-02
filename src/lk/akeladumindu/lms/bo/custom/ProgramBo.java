package lk.akeladumindu.lms.bo.custom;

import lk.akeladumindu.lms.dto.ProgramDto;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBo {
    public static void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException{

    }

    void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;

    static List<Long> findAllStudentIds();
}




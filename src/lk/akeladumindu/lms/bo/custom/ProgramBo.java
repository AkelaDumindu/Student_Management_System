package lk.akeladumindu.lms.bo.custom;

import lk.akeladumindu.lms.dto.ProgramDto;

import java.sql.SQLException;

public interface ProgramBo {
    public static void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;
}




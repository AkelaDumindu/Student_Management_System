package lk.akeladumindu.lms.bo.custom;

import lk.akeladumindu.lms.dto.ProgramDto;
import lk.akeladumindu.lms.entity.Program;
import lk.akeladumindu.lms.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBo {
    public static void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException{

    }


//    void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;

    static List<Long> findAllStudentIds(){
        return java.util.Collections.emptyList();
    }


//    List<Long> findAllStudentIds();

    static void register(Long studentId, Long programId){

    }

//    void register(long studentId, long programId);
}




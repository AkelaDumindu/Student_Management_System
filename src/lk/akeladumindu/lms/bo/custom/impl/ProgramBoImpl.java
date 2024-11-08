package lk.akeladumindu.lms.bo.custom.impl;

import lk.akeladumindu.lms.bo.custom.ProgramBo;
import lk.akeladumindu.lms.dao.DaoFactory;
import lk.akeladumindu.lms.dao.custom.ProgramDao;
import lk.akeladumindu.lms.dto.CustomRegistrationData;
import lk.akeladumindu.lms.dto.ProgramDto;
import lk.akeladumindu.lms.entity.Program;
import lk.akeladumindu.lms.entity.Registration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramBoImpl implements ProgramBo {

    private final ProgramDao programDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PROGRAM);
    @Override
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException {
        Program program = new Program();
        program.setTitle(dto.getTitle());
        program.setCredit(dto.getCredits());
        programDao.save(program);
    }

    @Override
    public List<Long> findAllStudentIds() {
        return programDao.findAllProgramIds();
    }

    @Override
    public void register(long studentId, long programId) {
        programDao.register(studentId,programId);
    }

    @Override
    public List<CustomRegistrationData> findAllRegistrations() {
        List<CustomRegistrationData> data = new ArrayList<>();
        for (Registration temp:programDao.findAllRegistrations()
        ) {
            data.add(
                    new CustomRegistrationData(
                            temp.getRegDate(),
                            temp.getStudent().getName(),
                            temp.getProgram().getTitle()
                    )
            );
        }
        return data;
    }
}

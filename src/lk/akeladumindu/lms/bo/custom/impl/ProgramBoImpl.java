package lk.akeladumindu.lms.bo.custom.impl;

import lk.akeladumindu.lms.bo.custom.ProgramBo;
import lk.akeladumindu.lms.dao.DaoFactory;
import lk.akeladumindu.lms.dao.custom.ProgramDao;
import lk.akeladumindu.lms.dto.ProgramDto;
import lk.akeladumindu.lms.entity.Program;

import java.sql.SQLException;

public class ProgramBoImpl implements ProgramBo {

    private final ProgramDao programDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.PROGRAM);
    @Override
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException {
        Program program = new Program();
        program.setTitle(dto.getTitle());
        program.setCredit(dto.getCredits());
        programDao.save(program);
    }
}

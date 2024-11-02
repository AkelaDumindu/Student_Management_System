package lk.akeladumindu.lms.dao.custom;

import lk.akeladumindu.lms.dao.CrudDao;
import lk.akeladumindu.lms.entity.Program;

import java.util.List;

public interface ProgramDao extends CrudDao<Program, Long> {
    public List<Long> findAllProgramIds();
}

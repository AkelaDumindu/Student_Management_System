package lk.akeladumindu.lms.dao.custom;

import lk.akeladumindu.lms.dao.CrudDao;
import lk.akeladumindu.lms.entity.Program;
import lk.akeladumindu.lms.entity.Registration;

import java.util.List;

public interface ProgramDao extends CrudDao<Program, Long> {
    public List<Long> findAllProgramIds();
    void register(long studentId, long programId);

    List<Registration> findAllRegistrations();
}

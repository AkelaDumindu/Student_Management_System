package lk.akeladumindu.lms.dao.custom;

import lk.akeladumindu.lms.dao.CrudDao;
import lk.akeladumindu.lms.entity.Laptop;

public interface LaptopDao extends CrudDao<Laptop, Long> {
    public void saveLaptopWithStudentId(long studentId, Laptop laptop);
}

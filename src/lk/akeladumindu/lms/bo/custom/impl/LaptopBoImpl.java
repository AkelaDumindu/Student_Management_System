package lk.akeladumindu.lms.bo.custom.impl;

import lk.akeladumindu.lms.bo.custom.LaptopBo;
import lk.akeladumindu.lms.dao.DaoFactory;
import lk.akeladumindu.lms.dao.custom.LaptopDao;
import lk.akeladumindu.lms.dto.CreateLaptopDto;
import lk.akeladumindu.lms.entity.Laptop;

import java.sql.SQLException;

public class LaptopBoImpl implements LaptopBo {
    LaptopDao laptopDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.LAPTOP);
    @Override
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException {
        Laptop laptop = new Laptop();
        laptop.setBrand(dto.getBrand());
        laptopDao.saveLaptopWithStudentId(dto.getStudentId(), laptop);
    }
}

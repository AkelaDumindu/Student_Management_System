package lk.akeladumindu.lms.bo.custom;

import lk.akeladumindu.lms.dto.CreateLaptopDto;

import java.sql.SQLException;

public interface LaptopBo {
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException;
}

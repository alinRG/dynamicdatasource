package dynamicDataSource.example.dao;

import dynamicDataSource.example.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SlaveOneDao {
    TbUser findUserById(long id);
}

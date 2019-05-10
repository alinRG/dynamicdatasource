package dynamicDataSource.example.dao;

import dynamicDataSource.example.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SlaveTwoDao {
    Customer findCustomerById(long id);
}

package dynamicDataSource.example.service;

import dynamicDataSource.annotation.HikariCPDataSource;
import dynamicDataSource.example.dao.SlaveTwoDao;
import dynamicDataSource.example.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SlaveTwoService {

    @Autowired
    private SlaveTwoDao slaveTwoDao;

    @HikariCPDataSource("slave2")
    public Customer findCustomerById(){
        Customer customer = slaveTwoDao.findCustomerById(1);
        log.info("Customer name : ",customer);
        return customer;
    }
}

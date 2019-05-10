package dynamicDataSource;

import dynamicDataSource.example.dao.SlaveOneDao;
import dynamicDataSource.example.dao.SlaveTwoDao;
import dynamicDataSource.example.entity.Customer;
import dynamicDataSource.example.entity.TbUser;
import dynamicDataSource.example.service.SlaveOneService;
import dynamicDataSource.example.service.SlaveTwoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HikaridatasourceApplication.class,SlaveOneService.class,SlaveTwoService.class, SlaveOneDao.class, SlaveTwoDao.class})
@Slf4j
public class HikaridatasourceApplicationTests {

    @Autowired
    private SlaveOneService slaveOneService;

    @Autowired
    private SlaveTwoService slaveTwoService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void dynamicDataSourceTest(){
        TbUser tbUser = slaveOneService.findUserById();
        Assert.assertEquals("mark",tbUser.getUsername());
        System.out.println(tbUser.toString());
        Customer customer = slaveTwoService.findCustomerById();
        System.out.println(customer.toString());
        Assert.assertEquals("customer1",customer.getName());

    }

}

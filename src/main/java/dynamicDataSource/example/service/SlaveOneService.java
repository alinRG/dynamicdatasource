package dynamicDataSource.example.service;

import dynamicDataSource.example.dao.SlaveOneDao;
import dynamicDataSource.example.entity.TbUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SlaveOneService {
    @Autowired
    private SlaveOneDao slaveOneDao;

    public TbUser findUserById(){
        TbUser tbUser = slaveOneDao.findUserById(1);
        log.info("User name : " ,tbUser);
        return tbUser;
    }
}

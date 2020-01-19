package cn.lianhy.demo.service.impl;

import cn.lianhy.demo.dao.UserDao;
import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.service.UserService;
import cn.lianhy.demo.to.UserTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao<UserTO,UserFO> userDao;

    @Override
    public List<UserTO> getList(UserFO fo) {
        return userDao.getList(fo);
    }
}

package cn.lianhy.demo.service.impl;

import cn.lianhy.demo.dao.UserDao;
import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.service.UserService;
import cn.lianhy.demo.to.UserTO;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao<UserTO,UserFO> userDao;

    @Override
    @Transactional
    public long insertBySelective(UserFO fo) {
        return userDao.insertBySelective(fo);
    }

    @Override
    @Transactional
    public long updateByIdSelective(UserFO fo) {
        return userDao.updateByIdSelective(fo);
    }

    @Override
    public List<UserTO> getList(UserFO fo) {
        return userDao.getList(fo);
    }

    @Override
    public List<UserTO> getListPage(UserFO fo) {
        PageHelper.startPage((fo.getPageIndex()-1) * fo.getPageSize(),fo.getPageSize());
        return userDao.getList(fo);
    }
}

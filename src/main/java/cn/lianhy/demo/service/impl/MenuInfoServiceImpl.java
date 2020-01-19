package cn.lianhy.demo.service.impl;

import cn.lianhy.demo.dao.MenuInfoDao;
import cn.lianhy.demo.form.MenuInfoFO;
import cn.lianhy.demo.service.MenuInfoService;
import cn.lianhy.demo.to.MenuInfoTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Resource
    private MenuInfoDao<MenuInfoTO,MenuInfoFO> menuInfoDao;

    @Override
    public List<MenuInfoTO> getUserRoleMenuInfoPermssion(MenuInfoFO fo) {
        return menuInfoDao.getUserRoleMenuInfoPermssion(fo);
    }
}

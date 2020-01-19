package cn.lianhy.demo.service;

import cn.lianhy.demo.form.MenuInfoFO;
import cn.lianhy.demo.to.MenuInfoTO;

import java.util.List;

public interface MenuInfoService {
    List<MenuInfoTO> getUserRoleMenuInfoPermssion(MenuInfoFO fo);
}

package cn.lianhy.demo.dao;

import java.util.List;

public interface MenuInfoDao<TO, FO> {

    List<TO> getUserRoleMenuInfoPermssion(FO fo);
}

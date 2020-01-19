package cn.lianhy.demo.dao;

import java.util.List;

public interface UserDao<TO, FO> {

    List<TO> getList(FO fo);
}

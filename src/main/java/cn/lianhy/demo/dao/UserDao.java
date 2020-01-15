package cn.lianhy.demo.dao;

import java.util.List;

public interface UserDao<TO, FO> {

    long insertBySelective(FO fo);

    long updateByIdSelective(FO fo);

    List<TO> getList(FO fo);
}

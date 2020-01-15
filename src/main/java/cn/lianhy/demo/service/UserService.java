package cn.lianhy.demo.service;

import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.to.UserTO;

import java.util.List;

public interface UserService {

    long insertBySelective(UserFO fo);

    long updateByIdSelective(UserFO fo);

    List<UserTO> getList(UserFO fo);

    List<UserTO> getListPage(UserFO fo);
}

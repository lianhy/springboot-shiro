package cn.lianhy.demo.service;

import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.to.UserTO;

import java.util.List;

public interface UserService {

    List<UserTO> getList(UserFO fo);
}

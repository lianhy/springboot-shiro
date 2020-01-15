package cn.lianhy.demo.action;

import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.service.UserService;
import cn.lianhy.demo.to.UserTO;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoAction {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/addUser")
    public String addUser(String name){
        UserFO fo=new UserFO();
        fo.setName(name);
        userService.insertBySelective(fo);
        return "success";
    }

    @GetMapping(value = "/user/getUser")
    public String getUser(Integer id){
        UserFO fo=new UserFO();
        fo.setId(id);
        List<UserTO> list=userService.getList(fo);
        return JSON.toJSONString(list);
    }

    @GetMapping(value = "/user/getUserPage")
    public String getUserPage(Integer pageIndex){
        UserFO fo=new UserFO();
        fo.setPageSize(2);
        fo.setPageIndex(pageIndex);
        List<UserTO> list=userService.getListPage(fo);
        return JSON.toJSONString(list);
    }
}

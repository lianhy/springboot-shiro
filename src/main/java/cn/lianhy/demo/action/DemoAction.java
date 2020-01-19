package cn.lianhy.demo.action;

import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.service.UserService;
import cn.lianhy.demo.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DemoAction {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/toUserView")
    public String toUserView(Integer id, Model model){
        UserFO fo=new UserFO();
        fo.setId(id);
        List<UserTO> list=userService.getList(fo);
        if(list !=null && list.size()>0){
            model.addAttribute("user",list.get(0));
        }
        return "user/userView";
    }

    @GetMapping(value = "/user/toUserPage")
    public ModelAndView toUserPage(Model model){
        ModelAndView view=new ModelAndView();
        UserFO fo=new UserFO();
        List<UserTO> list=userService.getList(fo);
        if(list !=null && list.size()>0){
            view.addObject("userList",list);
        }
        view.setViewName("user/userPage");
        return view;
    }
}

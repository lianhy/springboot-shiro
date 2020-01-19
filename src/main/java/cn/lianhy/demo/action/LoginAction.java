package cn.lianhy.demo.action;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAction {

    @RequestMapping(value = "login.do")
    @ResponseBody
    public JSONObject login(String userName,String password){
        JSONObject jsonObject=new JSONObject();

        //执行登录
        Subject subjects = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subjects.login(token);


        return jsonObject;
    }
}

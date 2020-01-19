package cn.lianhy.demo.config;

import cn.lianhy.demo.form.MenuInfoFO;
import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.service.MenuInfoService;
import cn.lianhy.demo.service.UserService;
import cn.lianhy.demo.to.MenuInfoTO;
import cn.lianhy.demo.to.UserTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuInfoService menuInfoService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserTO userTO=(UserTO)SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        MenuInfoFO menuInfoFO=new MenuInfoFO();
        menuInfoFO.setRoleId(userTO.getRoleId());
        List<MenuInfoTO> listM=menuInfoService.getUserRoleMenuInfoPermssion(menuInfoFO);
        Set<String> listP=new HashSet<>();
        if(listM !=null && listM.size()>0){
            for(MenuInfoTO m:listM){
                listP.add(m.getPermissionFlag());
            }
        }
        info.setStringPermissions(listP);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String userName=token.getUsername();

        UserFO userFO=new UserFO();
        userFO.setName(userName);
        List<UserTO> list = userService.getList(userFO);
        if(list == null || list.size() == 0){
            throw new UnknownAccountException();
        }
        UserTO userTO=list.get(0);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userTO,userTO.getPassword(), ByteSource.Util.bytes(userName),getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", userTO);
        return info;
    }
}

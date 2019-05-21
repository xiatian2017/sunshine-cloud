package com.csd.sunshine.config;


import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuqi
 * @description shiro授权，认证 realm,shiro需要自己处理异常
 * @date 2019/5/17 10:47
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登陆用户后查询该用户角色和权限并赋值
        Admin user = (Admin) SecurityUtils.getSubject().getPrincipal();
        //角色
        List<Role> roles = adminService.queryRolesUser(user);
        //权限
        List<Permission> permissions = adminService.queryByUser(user);
        user.setRoles(roles);
        user.setPermissions(permissions);

        roles.forEach( role ->info.addRole(role.getDisplayName()));
        permissions.forEach(permission -> info.addStringPermission(permission.getName()));
        return info;
    }

    /**
     * 登陆
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String username = authenticationToken.getPrincipal().toString();
        Admin user = null;
        try {
            //调用查询的方法查询用户名
            user = adminService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            String password = user.getPassword();
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    //shiro自动检验密码
                    //user，密码，唯一权限id
            new SimpleAuthenticationInfo(user, password, getName());
            return simpleAuthenticationInfo;
        }
    }

}

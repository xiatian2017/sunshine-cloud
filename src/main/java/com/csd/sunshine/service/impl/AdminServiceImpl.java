package com.csd.sunshine.service.impl;

import com.csd.sunshine.controller.AdminController;
import com.csd.sunshine.mapper.AdminMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.service.AdminService;
import com.csd.sunshine.util.CommontUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:48
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    //通过用户名查询
    @Override
    public List<Admin> findByName(String username) {

        return adminMapper.findByName(username);
    }

    /**
     * 登陆
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {

        return adminMapper.login(admin);
    }


    @Override
    public List<Role> queryRolesUser(Admin user) {

        return adminMapper.queryRolesUser(user);
    }



    @Override
    public List<Permission> queryByUser(Admin user) {

        return adminMapper.queryByUser(user);
    }


    //为管理员分配角色
    @Override
    public void setRoles(AdminController.AdminRoles adminRoles) throws Exception {

        List<AdminController.AdminRoles> obj = adminRoles.getObj();
        adminMapper.setRoles(obj);
    }

    //新建管理员
    @Override
    public int createNewAdmin(Admin user) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("username",user.getUsername());
        List<Admin> admins = adminMapper.selectByMap(map);
        //如果已存在该用户名的用户，新建失败
        if(null != admins && admins.size() > 0){
            return  -1;
        }else{
            user.setCreated_at(CommontUtil.getTimeStampTime());
            return adminMapper.insert(user);
        }

    }
}

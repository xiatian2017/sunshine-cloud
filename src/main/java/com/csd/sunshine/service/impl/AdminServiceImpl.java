package com.csd.sunshine.service.impl;

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


    //查询用户名
    @Override
    public Admin findByName(String username) {

        return adminMapper.findByName(username);
    }

    //新建管理员用户
    @Override
    public int createNewAdmin(Admin user) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("username",user.getUsername());
        //查询
        List<Admin> admins = adminMapper.selectByMap(map);
        //如果已存在该用户名的用户，新建失败
        if(null != admins && admins.size() > 0){
            return  -1;
        }else{
            //添加
            user.setCreated_at(CommontUtil.getTimeStampTime());

            //执行添加操作
            System.out.println(user.getUsername());
            //同步手机号和用户名，保持一致
            user.setPhone(user.getUsername());
            //调用添加方法
            return adminMapper.insert(user);
        }

    }


    @Override
    public List<Role> queryRolesUser(Admin user) {

        return adminMapper.queryRolesUser(user);
    }


    @Override
    public List<Permission> queryByUser(Admin user) {

        return adminMapper.queryByUser(user);
    }





}

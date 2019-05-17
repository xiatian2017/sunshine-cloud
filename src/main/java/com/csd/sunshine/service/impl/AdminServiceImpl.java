package com.csd.sunshine.service.impl;

import com.csd.sunshine.mapper.AdminMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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





}

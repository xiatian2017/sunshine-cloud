package com.csd.sunshine.service.impl;

import com.csd.sunshine.mapper.RoleMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/21 17:15
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    //查询用户的角色
    @Override
    public List<Role> queryRolesUser(Admin user) {

        return roleMapper.queryRolesUser(user);
    }

    //新建角色
    @Override
    public void add(Role role) {

        roleMapper.insert(role);
    }
}

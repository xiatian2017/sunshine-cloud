package com.csd.sunshine.service.impl;

import com.csd.sunshine.mapper.PermissionMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/22 10:54
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    //查询用户的权限
    @Override
    public List<Permission> queryByUser(Admin user) {

        return permissionMapper.queryByUser(user);
    }
}

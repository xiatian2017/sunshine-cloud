package com.csd.sunshine.service;

import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/22 10:53
 */
public interface PermissionService {

    /**
     * 查询用户的权限
     * @param user 用户
     * @return 权限
     */
    List<Permission> queryByUser(Admin user);
}

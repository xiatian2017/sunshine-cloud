package com.csd.sunshine.service;

import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Role;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/21 17:14
 */
public interface RoleService {

    /**
     * 查询用户的角色
     * @param user 用户
     * @return 角色
     */
    List<Role> queryRolesUser(Admin user);

    /**
     * 增加角色
     * @param role 角色
     * @throws
     */
    void add(Role role);

    /**
     * 根据id删除角色
     * @param id id
     * @throws
     */
    void deleteById(Integer id);
}

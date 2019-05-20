package com.csd.sunshine.service;

import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:48
 */
public interface AdminService {


    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 管理员用户
     */
    Admin findByName(String username);
    
    /**
     * 查询用户的角色集
     * @param user 用户
     * @return 角色集合
     */
    List<Role> queryRolesUser(Admin user);

    /**
     * 通过某用户的权限
     * @param user 用户
     * @return 权限集合
     */
    List<Permission> queryByUser(Admin user);

    /**
     * 新建管理员用户
     * @param user 用户参数
     * @return 影响行数
     */
    int createNewAdmin(Admin user);

    /**
     * 添加
     * @param user
     * @return 添加一行---》id自增
     */
    int insert(Admin user);

    /**
     * 查询
     * @param user
     * @return 查询多行
     */
    List<Admin> selectByMap(Admin user);

}

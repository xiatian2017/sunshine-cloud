package com.csd.sunshine.service;

import com.csd.sunshine.controller.AdminController;
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
    List<Admin> findByName(String username);

    /**
     * 登陆
     * @param admin
     * @return
     */
    Admin login(Admin admin);


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
     * 为管理员分配角色
     * @param adminRoles 封装了管理员id和所分配的角色id集合
     */
    void setRoles(AdminController.AdminRoles adminRoles) throws Exception;

    /**
     * 新建管理员用户
     * @param user 用户参数
     * @return 影响行数
     */
    int createNewAdmin(Admin user);

}

package com.csd.sunshine.service;

import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;

import javax.servlet.http.HttpServletRequest;
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
     * @return
     */
    int createNewAdmin(Admin user);

    /**
     * 修改用户状态
     * @param user
     * @return
     */
    int updateUserSataus(Admin user, HttpServletRequest request);

    /**
     * 根据id删除管理员
     * @param id id
     * @return
     */
    void deleteById(Integer id);

}

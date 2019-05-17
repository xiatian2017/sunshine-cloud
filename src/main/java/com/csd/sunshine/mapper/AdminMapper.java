package com.csd.sunshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csd.sunshine.controller.AdminController;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:48
 */
@Repository
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {


    List<Admin> findByName(String username);

    Admin login(Admin admin);

    int createNewAdmin(Admin user);

    List<Permission> queryByUser(Admin user);

    List<Role> queryRolesUser(Admin user);

    void setRoles(List<AdminController.AdminRoles> obj) throws Exception;
}

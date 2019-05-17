package com.csd.sunshine.mapper;

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
public interface AdminMapper {

    Admin login(Admin admin);

    List<Admin> findByName(String username);

    List<Permission> queryByUser(Admin user);

    List<Role> queryRolesUser(Admin user);

}

package com.csd.sunshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.model.vo.AdminRoles;
import org.apache.ibatis.annotations.Insert;
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

    Admin findByName(String username);

    List<Permission> queryByUser(Admin user);

    int updateUserSataus(Admin user);

    void deleteAdminRole(Integer id);

    /**
     * 批量插入 分配用户角色
     *
     * @param obj
     */
    @Insert({"<script>insert into sun_admin_role (admin_id, role_id) values ",
            "<foreach collection='list'  item='item' separator=','> ",
            "(#{item.uid},#{item.role})",
            "</foreach></script>"})
    void setRoles(List<AdminRoles> obj);
}

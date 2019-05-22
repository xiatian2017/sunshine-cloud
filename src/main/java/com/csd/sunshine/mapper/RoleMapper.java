package com.csd.sunshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.model.vo.RolePermissions;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/21 17:16
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> queryRolesUser(Admin user);

    void deleteRolePermission(Integer id);

    void deleteAdminRole(Integer id);

    @Insert({"<script>insert into sun_role_permission (permission_id, role_id) values ",
            "<foreach collection='list'  item='item' separator=','> ",
            "(#{item.pid},#{item.rid})",
            "</foreach></script>"})
    void allotPermission(List<RolePermissions> obj);

}

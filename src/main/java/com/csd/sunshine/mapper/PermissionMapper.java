package com.csd.sunshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/22 10:56
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    //查询用户id的权限
    @Select({"select p.* from sun_permission p " ,
            "join sun_role_permission rp on rp.permission_id = p.id " ,
            "join sun_role r on r.id = rp.role_id " ,
            "join sun_admin_role ar on ar.role_id = r.id " ,
            "join sun_admin u on u.id = ar.admin_id " ,
            "where u.id = #{user.id} and p.status = 1"})
    List<Permission> queryByUser(@Param("user") Admin user);


    //根据角色id查询该角色对应的所有权限
    @Select({"select p.id, p.name, p.parent_id pid, p.display_name sName, p.is_show isShow ",
            "from sun_permission p ",
            "join sun_role_permission rp on p.id = rp.permission_id ",
            "join sun_role r on r.id = rp.role_id ",
            "where r.id = #{id} and p.status = 1 ",
            "order by pid"})
    @ResultType(Map.class)
    List<Map> queryByRole(Integer id);

}

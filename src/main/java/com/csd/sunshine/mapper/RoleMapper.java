package com.csd.sunshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.entity.Role;
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

}

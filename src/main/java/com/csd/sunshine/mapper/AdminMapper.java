package com.csd.sunshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.model.vo.AdminRoles;
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

    int updateUserStatus(Admin user);

    void deleteAdminRole(Integer id);

    //调用了封装的obj方法
    void setRoles(List<AdminRoles> obj);
}

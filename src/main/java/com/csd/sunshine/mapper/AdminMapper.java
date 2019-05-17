package com.csd.sunshine.mapper;

import com.csd.sunshine.model.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:48
 */
@Repository
@Mapper
public interface AdminMapper {


    Admin findByName(String username);


    /**
     * 登陆
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}

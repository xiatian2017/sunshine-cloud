package com.csd.sunshine.service;

import com.csd.sunshine.model.entity.Admin;

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
}

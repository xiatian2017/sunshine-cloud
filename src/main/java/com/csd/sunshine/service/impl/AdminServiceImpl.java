package com.csd.sunshine.service.impl;

import com.csd.sunshine.mapper.AdminMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:48
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //通过用户名查询
    @Override
    public Admin findByName(String username) {

        return adminMapper.findByName(username);
    }
}

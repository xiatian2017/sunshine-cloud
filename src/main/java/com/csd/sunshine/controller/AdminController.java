package com.csd.sunshine.controller;

import com.csd.sunshine.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 19:14
 */
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;




}

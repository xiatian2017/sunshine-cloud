package com.csd.sunshine.controller;

import com.csd.sunshine.common.BaseCode;
import com.csd.sunshine.common.BaseResult;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.service.AdminService;
import com.csd.sunshine.util.SHA256;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 19:14
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //slat
    @Value("${salt}")
    private String slat;


    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return 返回状态
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public BaseResult login( String username, String password, HttpServletRequest request){

        //接收前端传过来的信息
        System.out.println(username);
        System.out.println(password);

        //密码加盐sha256加密
        password = SHA256.SHA256Encode(password + slat);
        //subject
        Subject subject = SecurityUtils.getSubject();
        //token
        AuthenticationToken authenticationToken = new UsernamePasswordToken(username, password);
        //返回信息
        try {
            subject.login(authenticationToken);

            return new BaseResult("200","登陆成功",1);
        }catch (Exception e){
            e.printStackTrace();
            log.error("登陆失败",e);
            return new BaseResult("500","登陆失败，用户名或密码错误",0);
        }
    }



    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 查询返回结果
     */
    @GetMapping("/findByName")
    public BaseResult findByName(String username){
        //接收前端传过来的信息
        System.out.println(username);
        //调用查询的方法
        List<Admin> us = adminService.findByName(username);
        //判断是否存在
        if(null != us && us.size() > 0){
            return new BaseResult("-1","用户名已存在",0);
        }else{
            return new BaseResult(BaseCode.SUCCESS.getCode(),"用户名可用",1);
        }
    }





}

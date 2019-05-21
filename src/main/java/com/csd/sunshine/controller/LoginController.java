package com.csd.sunshine.controller;

import com.csd.sunshine.common.BaseResult;
import com.csd.sunshine.common.ResultBean;
import com.csd.sunshine.mapper.AdminMapper;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.service.AdminService;
import com.csd.sunshine.util.SHA256;
import com.csd.sunshine.util.TokenProccessor;
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

/**
 * admin用户登陆界面
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/17 15:02
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE }, origins = "*")
public class LoginController {

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
    public BaseResult login(String username, String password, HttpServletRequest request){

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

            Admin admin = new Admin();
            //获取用户登录的token--->没有存数据库，感觉不需要，后期需要再存
            admin.setToken(TokenProccessor.getInstance().makeToken());
            admin.setLast_login_token(admin.getToken());
            System.out.println(admin);

            return new BaseResult("200","登陆成功",1);
        }catch (Exception e){
            e.printStackTrace();
            log.error("登陆失败",e);
            return new BaseResult("500","登陆失败，用户名或密码错误",0);
        }
    }



    @GetMapping("/logout")
    @ApiOperation(value = "用户退出")
    public BaseResult logout(){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return new BaseResult("200","退出成功",1);
        }catch (Exception e){
            e.printStackTrace();
            log.error("登陆失败",e);
            return new BaseResult("500","退出失败",0);
        }
    }


    /**
     * 用户名查询
     * @param username 用户名
     * @return 查询返回结果
     */
    @GetMapping("/findByName")
    @ApiOperation(value = "用户名查询")
    public ResultBean findByName(String username){

        //接收前端传过来的信息
        System.out.println(username);
        //调用查询的方法
        Admin us = adminService.findByName(username);
        //判断是否存在
        if (us != null){
            return ResultBean.ofError(0,"用户名已存在");
        }else {
            return ResultBean.ofSuccess(1,"用户名可用");
        }

    }
}

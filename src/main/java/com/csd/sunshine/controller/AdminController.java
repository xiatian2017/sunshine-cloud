package com.csd.sunshine.controller;


import com.csd.sunshine.common.BaseCode;
import com.csd.sunshine.common.BaseResult;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.service.AdminService;
import com.csd.sunshine.util.SHA256;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;



/**
 * 管理员界面
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 19:14
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE }, origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //slat
    @Value("${salt}")
    private String slat;

    /**
     * 新建管理用户
     * @param user 要新建的用户
     * @return 返回信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "新建管理用户")
    public BaseResult createAdminUser(@RequestBody Admin user){

        //接收的参数不能为空
        Admin loginUser = (Admin) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(user.getUsername(),"用户名不可为空");
        Assert.notNull(user.getPassword(),"密码不可为空");
        //密码加密
        user.setPassword(SHA256.SHA256Encode(user.getPassword()+slat));
        int us = adminService.createNewAdmin(user);
        if(us == -1){
            return new BaseResult("-1","用户名重复",0);
        }else{
            log.info("用户(id="+loginUser.getId()+") 新建用户（name："+user.getUsername()+")");
            return new BaseResult(BaseCode.SUCCESS.getCode(),"新建成功",1);
        }
    }



}

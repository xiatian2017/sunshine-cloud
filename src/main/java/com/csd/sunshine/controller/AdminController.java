package com.csd.sunshine.controller;

import com.csd.sunshine.common.AppException;
import com.csd.sunshine.common.BaseCode;
import com.csd.sunshine.common.BaseResult;
import com.csd.sunshine.model.entity.Admin;
import com.csd.sunshine.service.AdminService;
import com.csd.sunshine.util.SHA256;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 19:14
 */
@Slf4j
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    //slat
    @Value("${salt}")
    private String slat;


    /**
     * 登陆
     * @param phone 用户名
     * @param password 密码
     * @return 返回状态
     */
    @PostMapping("/login")
    public BaseResult login(String phone, String password, HttpServletRequest request){

        //接收前端传过来的信息

        //密码加盐sha256加密
        password = SHA256.SHA256Encode(password + slat);
        //subject
        Subject subject = SecurityUtils.getSubject();
        //token
        AuthenticationToken authenticationToken = new UsernamePasswordToken(phone, password);
        //返回信息
        try {
            subject.login(authenticationToken);

            //登陆成功后修改用户状态
//            Admin user = (Admin) subject.getPrincipal();
//            adminService.updateUserSataus(user, request);
            return new BaseResult("200","登陆成功",null);
        }catch (Exception e){
            e.printStackTrace();
            log.error("登陆失败",e);
            return new BaseResult("500","登陆失败，用户名或密码错误",null);
        }
    }


    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 查询返回结果
     */
    @GetMapping("/findByName")
    public BaseResult findByName(@PathVariable("username") String username){

        List<Admin> users = adminService.findByName(username);
        //判断
        if(null != users && users.size() > 0){
            return new BaseResult("-1","用户名已存在",null);
        }else{
            return new BaseResult(BaseCode.SUCCESS.getCode(),"用户名可用",null);
        }
    }


    @Getter
    @Setter
    public static class AdminRoles{
        Integer uid;
        Integer role;
        List<Integer> roles;

        public AdminRoles() {
        }

        public AdminRoles(Integer uid, List<Integer> roles) {
            this.uid = uid;
            this.roles = roles;
        }

        public AdminRoles(Integer uid, Integer role) {
            this.uid = uid;
            this.role = role;
        }

        public List<AdminRoles> getObj(){
            List<AdminRoles> adminRoles = new ArrayList<>(12);
            roles.forEach( rid ->{
                adminRoles.add(new AdminRoles(uid,rid));
            });
            return adminRoles;
        }
    }

    /**
     * 新建管理用户
     * @param user 要新建的用户
     * @return 返回信息
     */
    @PostMapping("/add")
    public BaseResult createAdminUser(Admin user){

        Admin loginUser = (Admin) SecurityUtils.getSubject().getPrincipal();

        Assert.notNull(user.getUsername(),"用户名不可为空");
        Assert.notNull(user.getPassword(),"密码不可为空");
        //密码加密
        user.setPassword(SHA256.SHA256Encode(user.getPassword()+slat));
        int isOk = adminService.createNewAdmin(user);
        if(-1 == isOk){
            return new BaseResult("-1","用户名重复",null);
        }else{
            log.info("用户(id="+loginUser.getId()+") 新建用户（name："+user.getUsername()+")");
            return new BaseResult(BaseCode.SUCCESS.getCode(),"新建成功",null);
        }
    }

    /**
     * 为管理员分配角色
     * @param adminRoles 包装了用户id和分配的角色id集合
     */
    @RequestMapping("/allotRoles")
    public BaseResult setRoles(AdminRoles adminRoles) throws AppException {
        try {
            adminService.setRoles(adminRoles);

            return new BaseResult(BaseCode.SUCCESS.getCode(),"分配成功",null);
        } catch (Exception e) {

            e.printStackTrace();
            log.error("分配角色时异常",e);
            throw new AppException("分配角色失败",e);
        }
    }



}

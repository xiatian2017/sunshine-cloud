package com.csd.sunshine.controller;

import com.csd.sunshine.common.BaseCode;
import com.csd.sunshine.common.BaseResult;
import com.csd.sunshine.model.entity.Role;
import com.csd.sunshine.service.RoleService;
import com.csd.sunshine.util.CommontUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/21 17:17
 */
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, origins = "*")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 增加角色
     * @return 结果
     */
//    @PostMapping("/add")
//    @ApiOperation(value = "增加角色")
//    public BaseResult createRole(@RequestBody Role role){
//       // Admin user = (Admin) SecurityUtils.getSubject().getPrincipal();
//        role.setCreated_at(CommontUtil.getTimeStampTime());
//        try {
//            roleService.add(role);
//            return new BaseResult(BaseCode.SUCCESS.getCode(),"增加角色成功", null);
//        }catch (Exception e){
//            e.printStackTrace();
//            log.error("增加角色异常",e);
//            return new BaseResult(BaseCode.SUCCESS.getCode(),"增加角色异常", 0);
//        }
//    }

}

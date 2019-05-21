package com.csd.sunshine.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加角色----》封装了管理员id和所分配的角色id集合
 *
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/21 16:43
 */
@Getter
@Setter
public class AdminRoles {


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

    public List<AdminRoles> getObj() {
        List<AdminRoles> adminRoles = new ArrayList<>(12);
        roles.forEach(rid -> {
            adminRoles.add(new AdminRoles(uid, rid));
        });
        return adminRoles;
    }


}

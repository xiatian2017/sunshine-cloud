package com.csd.sunshine.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 管理员表
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:15
 */

@Data
public class Admin implements Serializable {

    private Integer id;
    private String phone;
    private String username;
    private String nickname;
    private String password;
    private Integer status;
    //是否只允许读操作 0否 1是
    private Integer is_readonly;
    private String last_login_token;
    private Date login_at;
    private Date created_at;
    private Date updated_at;

    //角色和权限
    private List<Role> roles;
    private List<Permission> permissions;


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", is_readonly=" + is_readonly +
                ", last_login_token='" + last_login_token + '\'' +
                ", login_at=" + login_at +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }

}

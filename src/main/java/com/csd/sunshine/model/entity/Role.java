package com.csd.sunshine.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:26
 */

@Data
public class Role implements Serializable {


    private Integer id;
    private String displayName;//角色展示名
    private Integer level;      //角色等级
    private Date created_at;
    private Date updated_at;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", level=" + level +
                ", createdAt=" + created_at +
                ", updatedAt=" + updated_at +
                '}';
    }
}

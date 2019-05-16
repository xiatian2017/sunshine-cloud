package com.csd.sunshine.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
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
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", level=" + level +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

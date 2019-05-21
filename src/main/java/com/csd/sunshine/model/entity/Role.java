package com.csd.sunshine.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sun_role")
public class Role implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String display_name;//角色展示名
    private Integer level;      //角色等级
    private Date created_at;
    private Date updated_at;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", displayName='" + display_name + '\'' +
                ", level=" + level +
                ", createdAt=" + created_at +
                ", updatedAt=" + updated_at +
                '}';
    }
}

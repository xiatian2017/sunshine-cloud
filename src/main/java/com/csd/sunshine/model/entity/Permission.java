package com.csd.sunshine.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/16 18:26
 */

@Data
@TableName("sun_permission")
public class Permission implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;        //权限唯一ID
    private Integer parent_id;  //父类ID,根节点为0
    private String display_name;//权限展示名
    private Integer is_show;    //是否展示在菜单栏
    private Integer status;     //状态 0：正常 1：禁用
    private Date created_at;
    private Date updated_at;


    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", display_name='" + display_name + '\'' +
                ", is_show=" + is_show +
                ", status=" + status +
                ", createdAt=" + created_at +
                ", updatedAt=" + updated_at +
                '}';
    }
}

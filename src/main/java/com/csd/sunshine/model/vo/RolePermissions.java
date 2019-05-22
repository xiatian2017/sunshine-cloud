package com.csd.sunshine.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装roleid和permissionid,用来给角色赋权
 *
 * @Description: sunshine
 * @EnglishName LuKe
 * @authod liuqi
 * @date 2019/5/22 14:35
 */
@Getter
@Setter
public class RolePermissions {


    Integer rid;
    Integer pid;
    List<Integer> pids;

    public RolePermissions() {
    }

    public RolePermissions(Integer rid, List<Integer> pids) {
        this.rid = rid;
        this.pids = pids;
    }

    public RolePermissions(Integer rid, Integer pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public List<RolePermissions> getObj() {
        List<RolePermissions> list = new ArrayList<>(12);
        pids.forEach(pid -> {
            list.add(new RolePermissions(this.rid, pid));
        });
        return list;
    }

}

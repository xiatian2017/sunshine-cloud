package com.csd.sunshine;

import com.csd.sunshine.mapper.AdminMapper;
import com.csd.sunshine.mapper.PermissionMapper;
import com.csd.sunshine.mapper.RoleMapper;
import com.csd.sunshine.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SunshineApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;


    @Test
    public void contextLoads() {
    }

}

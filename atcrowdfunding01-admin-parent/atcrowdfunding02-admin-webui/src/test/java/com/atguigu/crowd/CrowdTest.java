package com.atguigu.crowd;

import com.atguigu.crowd.service.api.AdminService;
import org.junit.jupiter.api.Test;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// 这里用junit5进行测试
@SpringJUnitConfig(locations = {"classpath:spring-persist-tx.xml","classpath:spring-persist-mybatis.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "mei Lee", "123456", "mei", "mei@qq.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        adminService.saveAdmin(admin);
    }


    @Test
    public void  testConnection() throws SQLException{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsertAdmin(){
        Admin admin;
        admin = new Admin(null,"Rachel","123123","rui","rui@qq.com",null);
        int count = adminMapper.insert(admin);
        System.out.println(count);
    }

    @Test
    public void testLog(){

        // 1. 获取Logger对象，通常传入当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);

        // 2. 根据不同日志级别打印日志
        logger.debug("Hello I am DEBUG");
        logger.debug("Hello I am DEBUG");
        logger.debug("Hello I am DEBUG");

        logger.error("Hello I am ERROR");
        logger.error("Hello I am ERROR");
        logger.error("Hello I am ERROR");

        logger.info("Hello I am INFO");
        logger.info("Hello I am INFO");
        logger.info("Hello I am INFO");

        logger.warn("Hello I am WARN");
        logger.warn("Hello I am WARN");
        logger.warn("Hello I am WARN");

    }
}
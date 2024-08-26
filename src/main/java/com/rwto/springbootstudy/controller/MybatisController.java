package com.rwto.springbootstudy.controller;

import com.rwto.springbootstudy.MybatisDynamicSQLUtil;
import com.rwto.springbootstudy.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author renmw
 * @create 2024/8/26 9:18
 **/
@RestController
@RequestMapping("mybatis")
public class MybatisController {

    @Resource
    private UserDao userDao;

    @RequestMapping("user")
    public Object user(String name){
        return userDao.getUser(1l);
    }


    @RequestMapping("select")
    public Object select(String name){
        String sql = "select * from t_user where     <if test=\"params.id != null\">\n" +
                "        id = #{params.id}\n" +
                "    </if>";

        String sql1 = "select * from t_user where     id = #{params.id}";

        String sql2 = "select * from t_user ";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1l);
        String s = MybatisDynamicSQLUtil.parsingDynamicSql(sql, map);
        System.out.println(s);
        String s1 = MybatisDynamicSQLUtil.parsingDynamicSql(sql1, map);
        System.out.println(s1);
        String s2 = MybatisDynamicSQLUtil.parsingDynamicSql(sql2, map);
        System.out.println(s2);

        return userDao.selectSql(s,map);
    }


    @RequestMapping("dynamicSelect")
    public Object dynamicSelect(String name){
        return userDao.dynamicSelect(1l);
    }
}

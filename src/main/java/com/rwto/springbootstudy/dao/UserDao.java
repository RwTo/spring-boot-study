package com.rwto.springbootstudy.dao;

import com.rwto.springbootstudy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author renmw
 * @create 2023/12/29 9:36
 **/
/*
@Mapper 是 Mybatis 的注解，和 Spring 没有关系，@Repository 是 Spring 的注解，用于声明一个 Bean。
@Mapper 一定要有，否则 Mybatis 找不到 mapper。
@Repository可有可无，可以消去依赖注入的报错信息。和@Component一样
@MapperScan 可以替代 @Mapper。
* */
@Mapper
public interface UserDao {

    Integer insertUser(User user);

    User getUser(Long id);

    List<Map<String, String>> selectSql(@Param("sql") String sql, @Param("params") Map<String, Object> params);

    Object dynamicSelect(Long id);
}

package com.rwto.springbootstudy.service;

import com.rwto.springbootstudy.dao.UserDao;
import com.rwto.springbootstudy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author renmw
 * @create 2023/12/29 15:34
 **/
@Service
public class UserBatchService {

    @Autowired
    private UserService userService;

    /**
     不能通过this.进行自调用，必须使用aop代理对象，否则无法实现事务控制
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> users){
        int count = 0;
        for (User user : users) {
            count += userService.insertUser(user);
        }
        return count;
    }

}

/**
 Spring 事务的7种传播行为
 REQUIRED (默认) required
 需要事务，如果当前存在事务，就沿用当前事务，否则创建一个新的事务运行

 SUPPORTS       supports
 支持事务，如果当前存在事务，就沿用当前事务，如果不存在，则继续采用无事务的方式运行

 MANDATORY      mandatory
 必须使用事务，如果当前没有事务，则抛出异常，如果存在当前当前事务，就沿用当前事务

 REQUIRES_NEW   requires_new
 无论当前事务是否存在，都会创建新的事务运行，新的事务可以拥有新的锁和隔离级别等特性，与之前事务独立
 挂起当前事务，执行新的事务

 NOT_SUPPORTED  not_supported
 不支持事务，如果当前存在事务时，将挂起当前事务，使用新的连接无事务的方式运行方法

 NEVER          never
 不支持事务，如果当前方法存在事务，则抛出异常，否则继续使用无事务机制运行

 NESTED         nested
 当前方法调用子方法时，如果子方法发生异常，只回滚子方法执行过的sql，而不回滚当前方法的事务
 如果之前存在一个事务，则创建一个嵌套事务。嵌套事务的回滚不会影响到父事务，但是父事务的回滚会影响到嵌套事务。
 如果没有事务，则创建一个新的事务
 与 REQUIRES_NEW 的区别，
 NESTED 是嵌套事务，与主事务一同提交
 REQUIRES_NEW 是平行的新事物，可以分别提交
 * */
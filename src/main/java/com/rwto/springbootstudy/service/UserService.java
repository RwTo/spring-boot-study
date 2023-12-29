package com.rwto.springbootstudy.service;

import com.rwto.springbootstudy.dao.UserDao;
import com.rwto.springbootstudy.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author renmw
 * @create 2023/12/29 9:40
 **/
@Service
public class UserService implements ApplicationContextAware {

    @Autowired(required = false)
    private UserDao userDao;

    private ApplicationContext context;

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id){
        return userDao.getUser(id);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public Integer insertUser(User user){
        return userDao.insertUser(user);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
/***
 数据库隔离级别
 READ-UNCOMMITTED  READ-COMMITTED  REPEATABLE-READ  SERIALIZABLE
 设置数据库隔离级别
 全局|会话
 set [session|global] transaction_isolation = 'REPEATABLE-READ';
 show [session|global]  variables like 'tx_isolation';
 事务操作：begin; commit; rollback;

 脏读：读取到回滚的错误数据
 不可重复读：同一个事务中的简单读出现不同的数据
 幻读：针对读取的数据后，再执行的操作，例如如果没有数据则插入，
 * */




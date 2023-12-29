package com.rwto.springbootstudy.aspect;

import com.rwto.springbootstudy.service.HelloService;
import com.rwto.springbootstudy.service.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author renmw
 * @create 2023/12/26 20:03
 **/
@SpringBootTest
public class AspectTest {

    /**动态代理，打断点调试，idea debug 会提前执行方法*/
    @Test
    public void testProxy(){
        HelloService proxy = (HelloService)ProxyBean.getProxyBean(new HelloServiceImpl(), new MyInterceptor());
        proxy.sayHello("小明");
        System.out.println("============================null+++++++++++++++++++++");
        proxy.sayHello(null);
    }
}

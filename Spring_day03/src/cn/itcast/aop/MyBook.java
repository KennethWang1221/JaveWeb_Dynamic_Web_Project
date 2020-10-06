package cn.itcast.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {

    //在方法上面使用注解完成 增强 配置

    @Before(value="execution(* cn.itcast.aop.Book.*(..))")
    public void before1() {
        System.out.println("before.....");
    }
}

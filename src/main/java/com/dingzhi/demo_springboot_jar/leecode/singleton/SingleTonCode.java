package com.dingzhi.demo_springboot_jar.leecode.singleton;

/**
 * @author feiwen
 * @date 2024/5/11
 */
public class SingleTonCode {

    private SingleTonCode() {
    }

    //为什么使用volatile 保证内存可见性 应对多线程
    private static volatile SingleTonCode singleton;

    public static SingleTonCode getSingleton() {
        //为什么进行双重校验判空 并发执行 可能同时进入==null判断
        if (singleton == null) {
            synchronized (SingleTonCode.class) {
                if (singleton == null) {
                    singleton=new SingleTonCode();
                }
            }
        }
        return singleton;
    }

}

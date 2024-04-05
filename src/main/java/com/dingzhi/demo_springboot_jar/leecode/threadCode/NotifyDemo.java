package com.dingzhi.demo_springboot_jar.leecode.threadCode;

/**
 * @author feiwen
 * @date 2024/3/31
 */
public class NotifyDemo {

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                synchronized (NotifyDemo.class){
                    NotifyDemo.class.notifyAll();
                    System.out.println("AA");

                    try {
                        Thread.sleep(1000);
                        NotifyDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        new Thread(()->{
            while (true){
                synchronized (NotifyDemo.class){
                    NotifyDemo.class.notifyAll();
                    System.out.println("BB");
                    try {
                        Thread.sleep(1000);
                        NotifyDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}

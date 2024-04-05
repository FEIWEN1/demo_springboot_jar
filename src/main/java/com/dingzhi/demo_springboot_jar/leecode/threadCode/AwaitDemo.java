package com.dingzhi.demo_springboot_jar.leecode.threadCode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author feiwen
 * @date 2024/3/31
 */
public class AwaitDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition condition = lock.newCondition();

        new Thread(()->{
            while (true){
                lock.lock();
                condition.signalAll();
                System.out.println("CC");
                try {
                    Thread.sleep(1000);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                lock.lock();
                condition.signalAll();
                System.out.println("DD");
                try {
                    Thread.sleep(1000);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

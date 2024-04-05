package com.dingzhi.demo_springboot_jar.leecode.threadCode;

import java.util.concurrent.Semaphore;

/**
 * @author feiwen
 * @date 2024/3/31
 */
public class SemaphoreDemo {

    private static Semaphore semaphorenode = new Semaphore(1);
    private static Semaphore semaphorenode1 = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    semaphorenode.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("EE");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphorenode1.release();

            }
        }).start();
        new Thread(()->{
            while (true){
                try {
                    semaphorenode1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("FF");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphorenode.release();

            }
        }).start();
    }

}

package com.dingzhi.demo_springboot_jar.delay;

import java.util.concurrent.DelayQueue;

/**
 * @author feiwen
 * @date 2024/3/6
 */
public class DelayQueueTest {

    public void putDelayTask(){
        DelayQueue<DelayTask> delayQueue=new DelayQueue<DelayTask>();
        DelayTask task1=new DelayTask();
        delayQueue.put(task1);
        DelayTask task= delayQueue.poll();
    }
}

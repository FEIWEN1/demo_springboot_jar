package com.dingzhi.demo_springboot_jar.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author feiwen
 * @date 2024/3/6
 */
public class DelayTask implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}

package com.dt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @ProjectName: springcloud2020
 * @ClassName: MyLB
 * @Description: 自定义的轮询算法
 * @Author: WD
 * @Date: 2020/5/29 17:03
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    /**
     * 获取下一个要调用服务的ID
     */
    public final int getAndIncrement() {
        int current;//当前的第几次请求数
        int next;//下一次的请求数
        do {
            current = nextServerCyclicCounter.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
            // 当前值不是所期望的值，继续循环
            // 调用 cas ,进行自旋锁，每次next+1
        } while (!this.nextServerCyclicCounter.compareAndSet(current, next));
        System.out.println("***next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        // 第几次的请求数 % 服务器集群的总数 = 实际调用服务器的下标
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}

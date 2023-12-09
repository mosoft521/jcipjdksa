package javaguide.highAvailability;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimiterDemo2 {

    public static void main(String[] args) {
        // 1s 放 5 个令牌到桶里也就是 0.2s 放 1个令牌到桶里
        // 预热时间为3s,也就说刚开始的 3s 内发牌速率会逐渐提升到 0.2s 放 1 个令牌到桶里
        RateLimiter rateLimiter = RateLimiter.create(5, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 20; i++) {
            double sleepingTime = rateLimiter.acquire(1);
            System.out.printf("get " + i + " tokens: %sds%n", sleepingTime);
        }
    }
}
/*
get 0 tokens: 0.0ds
get 1 tokens: 0.559033ds
get 2 tokens: 0.510415ds
get 3 tokens: 0.466281ds
get 4 tokens: 0.412667ds
get 5 tokens: 0.359451ds
get 6 tokens: 0.303389ds
get 7 tokens: 0.252172ds
get 8 tokens: 0.205113ds
get 9 tokens: 0.199036ds
get 10 tokens: 0.190374ds
get 11 tokens: 0.198535ds
get 12 tokens: 0.198678ds
get 13 tokens: 0.19889ds
get 14 tokens: 0.198975ds
get 15 tokens: 0.199467ds
get 16 tokens: 0.185676ds
get 17 tokens: 0.198998ds
get 18 tokens: 0.198763ds
get 19 tokens: 0.199499ds
 */
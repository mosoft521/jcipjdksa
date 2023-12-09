package javaguide.highAvailability;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterDemo {

    public static void main(String[] args) {
        // 1s 放 5 个令牌到桶里也就是 0.2s 放 1个令牌到桶里
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            double sleepingTime = rateLimiter.acquire(1);
            System.out.printf("get " + i + " tokens: %ss%n", sleepingTime);
        }
    }
}
/*
get 0 tokens: 0.0s
get 1 tokens: 0.170555s
get 2 tokens: 0.196576s
get 3 tokens: 0.198458s
get 4 tokens: 0.19772s
get 5 tokens: 0.198506s
get 6 tokens: 0.19881s
get 7 tokens: 0.197807s
get 8 tokens: 0.198766s
get 9 tokens: 0.198782s
 */
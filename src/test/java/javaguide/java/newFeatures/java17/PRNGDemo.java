package javaguide.java.newFeatures.java17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PRNGDemo {
    public static void main(String[] args) {
        RandomGeneratorFactory<RandomGenerator> l128X256MixRandom = RandomGeneratorFactory.of("L128X256MixRandom");
        // 使用时间戳作为随机数种子
        RandomGenerator randomGenerator = l128X256MixRandom.create(System.currentTimeMillis());
        // 生成随机数
        System.out.println(randomGenerator.nextInt(10));
        System.out.println(randomGenerator.nextInt(10));
    }
}
/*
第一次
6 5
第二次
6 3
第三次
9 9
第四次
0 2
 */
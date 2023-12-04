package javaguide.cs.ds;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;

public class GuavaBloomFilterTest {
    @Test
    public void test() {
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));//false
        System.out.println(filter.mightContain(2));//false
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));//true
        System.out.println(filter.mightContain(2));//true
        System.out.println(filter.mightContain(3));//false
    }
}
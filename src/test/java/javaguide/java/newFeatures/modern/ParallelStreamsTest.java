package javaguide.java.newFeatures.modern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamsTest {
    private static final int MAX = 1000000;
    private List<String> values = new ArrayList<>(MAX);

    @BeforeEach
    private void be() {
        for (int i = 0; i < MAX; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    @Test
    public void sequentialTest() {
        //串行排序
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }
    /*
    1000000
    sequential sort took: 959 ms//串行排序所用的时间
     */

    @Test
    public void parallelStreamTest() {
        //并行排序
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
    /*
    1000000
    parallel sort took: 495 ms//并行排序所用的时间
     */
}
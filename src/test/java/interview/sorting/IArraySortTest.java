package interview.sorting;

import org.junit.jupiter.api.Assertions;

/**
 * 一本关于排序算法的 GitBook 在线书籍 《十大经典排序算法》，多语言实现。
 * https://github.com/hustcc/JS-Sorting-Algorithm
 */
public class IArraySortTest {
    /**
     * Asserts that two int arrays are equal. If they are not an
     * AssertionFailedError is thrown.
     */
    static public void assertEquals(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], actual[i]);
        }
    }
}
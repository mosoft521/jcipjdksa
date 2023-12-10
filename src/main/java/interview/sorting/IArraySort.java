package interview.sorting;

/**
 * 一本关于排序算法的 GitBook 在线书籍 《十大经典排序算法》，多语言实现。
 * https://github.com/hustcc/JS-Sorting-Algorithm
 */
public interface IArraySort {
    /**
     * 对数组进行排序，并返回排序后的数组
     *
     * @param sourceArray
     * @return
     * @throws Exception
     */
    int[] sort(int[] sourceArray) throws Exception;
}
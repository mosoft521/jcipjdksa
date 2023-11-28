package javaguide.java.collection.caution;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateCaution {
    // Set 去重代码示例
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        if (CollectionUtils.isEmpty(data)) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    // List 去重代码示例【不要用】
    @Deprecated
    public static <T> List<T> removeDuplicateByList(List<T> data) {

        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<>();

        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }
}

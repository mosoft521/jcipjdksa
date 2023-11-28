package javaguide.java.collection.caution;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Array2ListUseApacheCommonsCollections {

    public static void main(String[] args) {
        String str = "a";
        List<String> list = new ArrayList<String>();
        CollectionUtils.addAll(list, str);
        CollectionUtils.addAll(list, "b");
        System.out.println(list);//[a, b]
    }
}
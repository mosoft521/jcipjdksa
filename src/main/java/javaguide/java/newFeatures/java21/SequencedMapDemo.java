package javaguide.java.newFeatures.java21;

import java.util.LinkedHashMap;
import java.util.Map;

public class SequencedMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        map.firstEntry();   //1=One
        map.lastEntry();    //3=Three

        System.out.println(map);  //{1=One, 2=Two, 3=Three}

        Map.Entry<Integer, String> first = map.pollFirstEntry();   //1=One
        Map.Entry<Integer, String> last = map.pollLastEntry();    //3=Three

        System.out.println(map);  //{2=Two}

        map.putFirst(1, "One");     //{1=One, 2=Two}
        map.putLast(3, "Three");    //{1=One, 2=Two, 3=Three}

        System.out.println(map);  //{1=One, 2=Two, 3=Three}
        System.out.println(map.reversed());   //{3=Three, 2=Two, 1=One}
    }
}
package javaguide.java.basic.ch09SyntacticSugar;

import java.util.HashMap;
import java.util.Map;

public class MapSugar {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "hollis");
        map.put("wechat", "Hollis");
        map.put("blog", "www.hollischuang.com");
        System.out.println(map);
    }
}
/*
{name=hollis, wechat=Hollis, blog=www.hollischuang.com}
 */
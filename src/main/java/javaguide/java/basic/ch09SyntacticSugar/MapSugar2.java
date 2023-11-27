package javaguide.java.basic.ch09SyntacticSugar;

import java.util.HashMap;
import java.util.Map;

public class MapSugar2 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name", "hollis");
        map.put("wechat", "Hollis");
        map.put("blog", "www.hollischuang.com");
        System.out.println(map);
    }
}
/*
{name=hollis, wechat=Hollis, blog=www.hollischuang.com}
 */
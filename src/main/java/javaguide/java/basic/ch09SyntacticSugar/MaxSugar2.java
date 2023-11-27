package javaguide.java.basic.ch09SyntacticSugar;

import java.util.Collection;
import java.util.Iterator;

public class MaxSugar2 {
    public static Comparable max(Collection xs) {
        Iterator xi = xs.iterator();
        Comparable w = (Comparable) xi.next();
        do {
            if (!xi.hasNext())
                break;
            Comparable x = (Comparable) xi.next();
            if (w.compareTo(x) < 0)
                w = x;
        } while (true);
        return w;
    }
}

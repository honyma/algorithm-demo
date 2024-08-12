package linked;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mazehong
 * @date 2024/7/15
 */
public class LRUCache2<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f,  true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> entry) {
        return size() > capacity;
    }
}

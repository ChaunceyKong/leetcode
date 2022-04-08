import java.util.*;

// 146. LRU 缓存
public class Test {

    public static void main(String[] args) {


    }
}

//使用哈希链表，既有哈希表查找快，又有双向链表添加和删除快的特点
class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.capacity) {
            // 链表头部就是最久未使用的 key
            // keySet() 获取所有键的集合，iterator()迭代遍历
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, value);
    }
    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}


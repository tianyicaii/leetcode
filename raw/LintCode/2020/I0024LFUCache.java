package lintcode;

import java.util.ArrayList;
import java.util.HashMap;


/*

    描述
    LFU是一个著名的缓存算法
    对于容量为k的缓存，如果缓存已满，并且需要逐出其中的密钥，则最少使用的密钥将被踢出。
    实现LFU中的set 和 get

    您在真实的面试中是否遇到过这个题？  
    样例
    Input:
    LFUCache(3)
    set(2,2)
    set(1,1)
    get(2)
    get(1)
    get(2)
    set(3,3)
    set(4,4)
    get(3)
    get(2)
    get(1)
    get(4)

    Output:
    2
    1
    2
    -1
    2
    1
    4

*/


public class I0024LFUCache {

    
    public class LFUCache {

        public int counter = 0;
        public class CacheEntry {
            public int key;
            public int value;
            public int freq;
            public int cnt;  // break tie when freqs equal
    
            public CacheEntry(int k, int v) {
                key = k;
                value = v;
                freq = 0;
                touch();
            }
    
            public void touch() {
                freq++;
                cnt = counter++;
            }
        }

        private int cap;
        private ArrayList<CacheEntry> heap;
        private HashMap<Integer, Integer> map;  // key -> index on heap

        private boolean less(int i, int j) { 
            int f1 = heap.get(i).freq;
            int f2 = heap.get(j).freq;
            int c1 = heap.get(i).cnt;
            int c2 = heap.get(j).cnt;
            return f1 == f2 && c1 < c2 || f1 < f2;
        }

        private void swap(int i, int j) {
            CacheEntry tmp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, tmp);
            map.put(heap.get(i).key, i);
            map.put(heap.get(j).key, j);
        }

        private void swim(int i) {
            while (i > 1 && less(i, i / 2)) {
                swap(i, i / 2);
                i /= 2;
            }
        }

        private void sink(int i) {
            while (i * 2 < heap.size()) {
                int x = i;
                int l = i * 2;
                int r = i * 2 + 1;
                if (less(l, x)) x = l;
                if (r < heap.size() && less(r, x)) x = r;
                if (i != x) {
                    swap(i, x);
                    i = x;
                } else break;
            }
        }

        private CacheEntry poll() {
            CacheEntry min = heap.get(1);
            swap(1, heap.size() - 1);
            heap.remove(heap.size() - 1);
            map.remove(min.key);
            sink(1);
            return min;
        }

        private void offer(CacheEntry e) {
            heap.add(e);
            map.put(e.key, heap.size() - 1);
            swim(heap.size() - 1);
        }


        public LFUCache(int capacity) {
            cap = capacity + 1;
            heap = new ArrayList<>();
            map = new HashMap<>();
            heap.add(new CacheEntry(0, 0));  // unused;
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                int i = map.get(key);
                CacheEntry e = heap.get(i);
                e.touch();
                e.value = value;
                sink(i);
            } else {
                if (heap.size() == cap) poll();
                offer(new CacheEntry(key, value));
            }
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int i = map.get(key);
            CacheEntry e = heap.get(i);
            e.touch();
            sink(i);
            return e.value;
        }
    }
}

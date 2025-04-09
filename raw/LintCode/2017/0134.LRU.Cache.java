/*
 *  http://www.lintcode.com/en/problem/lru-cache/
 *
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *      get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *      set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 *                        it should invalidate the least recently used item before inserting a new item.
 */

    public class LRUCache {

        class Entry {  //  doubly linked list.
            int key;
            int value;
            Entry prev;
            Entry next;
            public Entry (int k, int v) {
                key = k;
                value = v;
            }
        }
        
        final int capacity;
        Entry head;  // dummy head and tail
        Entry tail;
        Map<Integer, Entry> m;
        
        public LRUCache (int capacity) {
            head = new Entry(0, 0);
            tail = new Entry(0, 0);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            m = new HashMap<>();
        }

        void remove (Entry p) {  // remove a node
            Entry prev = p.prev;
            Entry next = p.next;
            prev.next = next;
            next.prev = prev;
        }
        
        void append (Entry p) {  // add to end of list
            Entry prev = tail.prev;
            prev.next = p;
            p.prev = prev;
            p.next = tail;
            tail.prev = p;
        }
        
        public int get (int key) {
            if (!m.containsKey(key)) return -1;
            Entry p = m.get(key);
            remove(p);  // re-insert to end of list
            append(p);
            return p.value;
        }

        public void set (int key, int value) {
            if (!m.containsKey(key)) {  //  add new node
                Entry p = new Entry(key, value);
                m.put(key, p);
                append(p);  // add to tail
                if (m.size() > capacity) {
                    Entry x = head.next;  // remove oldest one
                    m.remove(x.key);  // reverse pointer from list to map
                    remove(x);
                }
            } else {
                Entry p = m.get(key);
                p.value = value;
                remove(p);  // move to end of list
                append(p);
            }
        }
    }




// java
    public class LRUCache {

        int capacity;
        LinkedHashMap<Integer, Integer> map;
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map  = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int v = map.get(key);
            map.remove(key);
            map.put(key, v);  // will be move to the end of queue.
            return v;
        }

        public void set(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == capacity) {
                    Iterator<Integer> it = map.keySet().iterator();  // map is ordered by insertion order
                    int first = it.next();
                    map.remove(first);
                }
                map.put(key, value);
            } else {
                map.remove(key);
                map.put(key, value);
            }
        }
    }   

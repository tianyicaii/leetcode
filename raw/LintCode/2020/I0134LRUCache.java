package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0134LRUCache {

    public class LRUCache {

        private class ListNode {
            int key;
            int value;
            ListNode prev;
            ListNode next;
            public ListNode(int k, int v) {
                key = k;
                value = v;
                prev = null;
                next = null;
            }
        }

        private ListNode head;
        private ListNode tail;
        int capacity;
        Map<Integer, ListNode> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }
    
        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int value = map.get(key).value;
            remove(key);
            add(key, value);
            return value;
        }
    
        public void set(int key, int value) {
            if (map.containsKey(key)) {
                remove(key);
                add(key, value);
            } else {
                if (map.size() == capacity) remove(head.next.key);
                add(key, value);
            }
        }

        private void add(int key, int value) {
            ListNode x = new ListNode(key, value);
            tail.prev.next = x;
            x.prev = tail.prev;
            x.next = tail;
            tail.prev = x;
            map.put(key, x);
        }

        private void remove(int key) {
            ListNode x = map.get(key);
            x.prev.next = x.next;
            x.next.prev = x.prev;
            map.remove(key);
        }
    }
}

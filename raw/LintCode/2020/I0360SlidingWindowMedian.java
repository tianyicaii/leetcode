package lintcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class I0360SlidingWindowMedian {
    
    
    class HashHeap {

        HashMap<Integer, Integer> nums = new HashMap<>();  // index => value
        ArrayList<Integer> heap = new ArrayList<>();  // index, heap ordered
        HashMap<Integer, Integer> map = new HashMap<>();  // index => heap index
        boolean minHeap = true;

        HashHeap(boolean minHeap) {
            this.minHeap = minHeap;
            heap.add(-1);
        }

        private boolean less(int i, int j) {
            int I = nums.get(heap.get(i));
            int J = nums.get(heap.get(j));
            return minHeap ? (I < J) : (I > J);
        }
    
        private void swap(int i, int j) {
            int t = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, t);
            map.put(heap.get(i), i);
            map.put(heap.get(j), j);
        }
    
        private void swim(int i) {
            while (i > 1 && less(i, i/2)) {
                swap(i, i/2);
                i = i/2;
            }
        }

        private void sink(int i) {
            while (true) {
                int left = i * 2;
                int right = i * 2 + 1;
                int min = i;
                if (left < heap.size() && less(left, min)) min = left;
                if (right < heap.size() && less(right, min)) min = right;
                if (min == i) return;
                swap(i, min);
                i = min;
            }
        }

        public void add(int i, int v) {
            nums.put(i, v);
            heap.add(i);
            map.put(i, heap.size() - 1);
            swim(heap.size() - 1);
        }

        public void delete(int i) {
            int heapIndex = map.get(i);
            swap(heapIndex, heap.size() - 1);
            heap.remove(heap.size() - 1);
            map.remove(i);
            nums.remove(i);
            if (heapIndex < heap.size()) {
                // lost a hair here !!!
                sink(heapIndex);
                swim(heapIndex);    
            }
        }

        public Map.Entry<Integer, Integer> poll() {
            int index = heap.get(1);
            int value = nums.get(index);
            delete(index);
            return new AbstractMap.SimpleEntry<>(index, value);
        }

        public int size() { return nums.size(); }
        public boolean isEmpty() { return size() == 0; }
        public int peek() { return nums.get(heap.get(1)); }
        public boolean contains(int i) { return nums.containsKey(i); }
    }

    HashHeap left = new HashHeap(false);  // max heap
    HashHeap right = new HashHeap(true);  // min heap

    private void balance() {
        if (left.size() < right.size()) {
            Map.Entry<Integer, Integer> e = right.poll();
            left.add(e.getKey(), e.getValue());
        } else if (left.size() > right.size() + 1) {
            Map.Entry<Integer, Integer> e = left.poll();
            right.add(e.getKey(), e.getValue());
        }
    }

    private void add(int i, int v) {
        if (left.isEmpty()) left.add(i, v);
        else if (v > left.peek()) right.add(i, v);
        else left.add(i, v);
        balance();
    }

    private void delete(int i) {
        if (left.contains(i)) left.delete(i);
        else right.delete(i);
        balance();
    }

    private int getMedian() { return left.peek(); }

    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) return ans;
        for (int i = 0; i < k-1 && i < nums.length; i++) {
            add(i, nums[i]);
        }
        for (int i = k-1; i < nums.length; i++) {
            add(i, nums[i]);
            ans.add(getMedian());
            delete(i-k+1);
        }
        return ans;
    }



    //

    class Node implements Comparable<Node> {
        int index;
        int value;
        Node(int i, int v) {
            index = i;
            value = v;
        }
        @Override
        public int compareTo(Node other) {
            // set CANNOT contain equal values
            if (value == other.value) return index - other.index;
            // return value - other.value;  // might overflow
            if (value < other.value) return -1;
            else return 1;
        }
    }

    TreeSet<Node> L = new TreeSet<>();
    TreeSet<Node> R = new TreeSet<>();

    private void insert(Node x) {
        if (L.isEmpty()) L.add(x);
        else if (L.last().value < x.value) R.add(x);
        else L.add(x);
        balanceTrees();
    }

    private void balanceTrees() {
        if (L.size() < R.size()) L.add(R.pollFirst());
        else if (L.size() > R.size() + 1) R.add(L.pollLast());
    }

    private int median() { return L.last().value; }

    private void delete(Node x) {
        if (L.contains(x)) L.remove(x);
        else R.remove(x);
        balanceTrees();
    }

    public List<Integer> medianSlidingWindow_(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) return ans;
        for (int i = 0; i < k-1 && i < nums.length; i++) {
            insert(new Node(i, nums[i]));
        }
        for (int i = k-1; i < nums.length; i++) {
            insert(new Node(i, nums[i]));
            ans.add(median());
            delete(new Node(i-k+1, nums[i-k+1]));
        }
        return ans;
    }

}

package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class I0081StreamMedian {
    
    
    
    private class Greater implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    private void balance() {
        if (left.size() == right.size()) return;
        if (left.size() == right.size() + 1) return;
        if (left.size() < right.size()) left.offer(right.poll());
        else right.offer(left.poll());
    }

    private int median() {
        return left.peek();
    }

    private void add(int i) {
        if (left.isEmpty()) {
            left.offer(i);
            return;
        }
        if (i > median()) right.offer(i);
        else left.offer(i);
        balance();
    }
    
    public int[] medianII(int[] nums) {
        left = new PriorityQueue<>(new Greater());
        right = new PriorityQueue<>();
        int N = nums.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            add(nums[i]);
            ans[i] = median();
        }
        return ans;
    }
}

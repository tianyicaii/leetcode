package lintcode;

import java.util.PriorityQueue;

public class I0544TopKLargest {
    
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for (int i = k-1; i >= 0; i--) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}

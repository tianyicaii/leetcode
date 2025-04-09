package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class I0545TopKLargest2 {
    

    public class Solution {

        int k;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        public Solution(int k) { this.k = k; }
    
        public void add(int num) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        public List<Integer> topk() {
            List<Integer> ans = new ArrayList<>();
            for (int i : pq) ans.add(i);
            Collections.sort(ans);
            Collections.reverse(ans);
            return ans;
        }
    }

}

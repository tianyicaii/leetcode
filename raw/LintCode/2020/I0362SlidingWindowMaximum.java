package lintcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class I0362SlidingWindowMaximum {

    Deque<Integer> max = new ArrayDeque<>();

    private void enque(int v) {
        while (!max.isEmpty() && max.peekLast() < v) max.pollLast();
        max.offerLast(v);
    }

    private void deque(int v) {
        if (max.peekFirst() == v) max.pollFirst();
    }

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        while (i < k - 1) { enque(nums[i++]); }
        while (i < nums.length) {
            enque(nums[i++]);
            ans.add(max.peekFirst());
            deque(nums[i-k]);
        }

        return ans;
    }
}

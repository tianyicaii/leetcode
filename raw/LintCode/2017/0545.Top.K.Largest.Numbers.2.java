/*
 *  http://www.lintcode.com/en/problem/top-k-largest-numbers-ii/#
 *
 *  Implement a data structure, provide two interfaces:
 *      add(number). Add a new number in the data structure.
 *      topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
 */


public class Solution {


    int size;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public Solution (int k) {
        this.size = k;
    }

    public void add (int num) {
        if (pq.size() < size) {
            pq.offer(num);
        } else {
            if (num <= pq.peek()) return;
            pq.offer(num);
            pq.poll();
        }
    }

// should make copy and poll all elements
    public List<Integer> topk () {
        List<Integer> ans = new ArrayList<>();
        for (int i : pq) {  // pq can be iterated in java
            ans.add(i);
        }
        Collections.sort(ans);
        Collections.reverse(ans);
        return ans;
    }

}

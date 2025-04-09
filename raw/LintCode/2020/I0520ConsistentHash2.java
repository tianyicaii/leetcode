package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

class Solution {

    int n;
    int k;
    TreeMap<Integer, Integer> intervals = new TreeMap<>();
    Random rand = new Random();

    Solution(int n, int k) { this.n = n; this.k = k; }
    public static Solution create(int n, int k) { return new Solution(n, k); }


    private int getRandom() {
        do {
            int r = (int)(rand.nextDouble() * n);
            if (!intervals.containsKey(r)) return r;
        } while (true);
    }

    public List<Integer> addMachine(int machine_id) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int endPoint = getRandom();
            intervals.put(endPoint, machine_id);
            ans.add(endPoint);
        }
        Collections.sort(ans);
        return ans;
    }

    public int getMachineIdByHashCode(int hashcode) {
        if (intervals.ceilingKey(hashcode) == null) return intervals.firstEntry().getValue();
        else return intervals.ceilingEntry(hashcode).getValue();
    }
}


public class I0520ConsistentHash2 {
    
}

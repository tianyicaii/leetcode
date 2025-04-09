package lintcode;

import java.util.HashSet;
import java.util.PriorityQueue;

/*

    描述
    设计一个算法，找出只含素因子2，3，5 的第 n 小的数。

    符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

    我们可以认为 1 也是一个丑数。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1：

    输入：9
    输出：10
    样例 2：

    输入：1
    输出：1
    挑战
    要求时间复杂度为 O(nlogn) 或者 O(n)。

*/

public class I0004UglyNumber {
    
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> candidates = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        candidates.offer(1L);
        seen.add(1L);
        long[] factors = {2, 3, 5};

        for (int i = 0; i < n - 1; i++) {
            long curr = candidates.poll();
            for (long f : factors) {
                long next = curr * f;
                if (!seen.contains(next)) {
                    candidates.add(next);
                    seen.add(next);
                }
            }
        }

        long ans = candidates.poll();
        return (int)ans;
    }

    public static void main(String[] args) {
        I0004UglyNumber solver = new I0004UglyNumber();
        System.out.println(solver.nthUglyNumber(9));
        System.out.println(solver.nthUglyNumber(1));
    }
}

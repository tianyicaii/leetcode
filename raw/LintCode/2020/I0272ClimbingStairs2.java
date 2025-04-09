package lintcode;

import java.util.ArrayList;

public class I0272ClimbingStairs2 {
    


    public int climbStairs2(int n) {

        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        dp.add(2);
        for (int i = 3; i <= n; i++) {
            dp.add(dp.get(i-1) + dp.get(i-2) + dp.get(i-3));
        }
        return dp.get(n);
    }
}

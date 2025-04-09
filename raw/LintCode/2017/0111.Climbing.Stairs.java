/*
 *  http://www.lintcode.com/en/problem/climbing-stairs/
 *
 *  You are climbing a stair case. It takes n steps to reach to the top.
 *  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

    public int climbStairs(int n) {
        int[] A = new int[3];
        A[0] = 0;  //  or 1 ?
        A[1] = 1;
        A[2] = 2;
        for (int i = 3; i <= n; i++) {
            A[i % 3] = A[(i - 1) % 3] + A[(i - 2) % 3];
        }
        return A[n % 3];
    }


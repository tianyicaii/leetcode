/*
 *  http://www.lintcode.com/en/problem/triangle-count/
 *
 *  Given an array of integers, how many three numbers can be found in the array,
 *  so that we can build an triangle whose three edges length is the three numbers that we find?
 */

    public int triangleCount (int S[]) {
        
        Arrays.sort(S);
        int ans = 0;
        
        for (int k = S.length - 1; k >= 2; k--) {
            int j = k-1;
            int i = 0;
            while (i < j) {
                int sum = S[i] + S[j];
                if (sum <= S[k])
                    i ++;
                else {  // sum of two smaller sides is larger than the largest side
                    ans += j - i;
                    j --;
                }
            }
        }
        return ans;
    }

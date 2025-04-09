package lintcode;
/*
    描述
    计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1：

    输入：
    k = 1, n = 1
    输出：
    1
    解释：
    在 [0, 1] 中，我们发现 1 出现了 1 次 (1)。
    样例 2：

    输入：
    k = 1, n = 12
    输出：
    5
    解释：
    在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 中，我们发现 1 出现了 5 次 (1, 10, 11, 12)(注意11中有两个1)。
*/

public class I0003DigitCount {

    public int digitCounts(int k, int n) {
        int cnt = 0;
        for (int i = k; i <= n; i++) {
            cnt += count(k, i);
        }
        return cnt;
    }

    private int count(int k, int i) {
        if (i == 0) {
            if (k == 0) return 1;
            else return 0;
        }
        int cnt = 0;
        while (i != 0) {
            if (i % 10 == k) cnt ++;
            i /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        I0003DigitCount solver = new I0003DigitCount();
        System.out.println(solver.digitCounts(1, 1));
        System.out.println(solver.digitCounts(1, 12));
    }
}

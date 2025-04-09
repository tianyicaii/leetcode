package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/*

    描述
    扔 n 个骰子，向上面的数字之和为 S。给定 n，请列出所有可能的 S 值及其相应的概率。

    你不需要关心结果的准确性，我们会帮你输出结果。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1：

    输入：n = 1
    输出：[[1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]]
    解释：掷一次骰子，向上的数字和可能为1,2,3,4,5,6，出现的概率均为 0.17。
    样例 2：

    输入：n = 2
    输出：[[2,0.03],[3,0.06],[4,0.08],[5,0.11],[6,0.14],[7,0.17],[8,0.14],[9,0.11],[10,0.08],[11,0.06],[12,0.03]]
    解释：掷两次骰子，向上的数字和可能在[2,12]，出现的概率是不同的。

*/


 public class I0020DiceSum {
    

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int sum = 1; sum <= 6; sum++) {
            dp[1][sum] = 1.0 / 6;
        }
        for (int numDice = 2; numDice <= n; numDice++) {
            for (int sum = numDice; sum <= numDice * 6; sum++) {
                for (int lastDiceValue = 1; lastDiceValue <= 6; lastDiceValue++) {
                    if (sum > lastDiceValue) {
                        dp[numDice][sum] += dp[numDice - 1][sum - lastDiceValue] * dp[1][lastDiceValue];
                    }
                }
            }
        }

        return gatherResult(dp, n);
    }

    private List<Map.Entry<Integer, Double>> gatherResult(double[][] dp, int n) {
        List<Map.Entry<Integer, Double>> ans = new ArrayList<>();
        TreeMap<Integer, Double> prob = new TreeMap<>();
        for (int sum = n; sum <= 6 * n; sum++) {
            prob.put(sum, dp[n][sum]);
        }
        for (Map.Entry<Integer, Double> e : prob.entrySet()) {
            ans.add(e);
        }
        return ans;
    }
}

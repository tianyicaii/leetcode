package lintcode;

import java.util.Set;

public class I0107WordBreak {
    
    public boolean wordBreak(String s, Set<String> wordSet) {
        int N = s.length();
        int wlen = maxWordLen(wordSet);

        boolean[] dp = new boolean[N + 1];
        dp[0] = true;
        
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= i && j <= wlen && !dp[i]; j++) {
                String lastWord = s.substring(i-j, i);
                dp[i] = wordSet.contains(lastWord) && dp[i-j];
            }
        }

        return dp[N];
    }

    private int maxWordLen(Set<String> wordSet) {
        int max = 0;
        for (String s : wordSet) {
            max = Math.max(max, s.length());
        }
        return max;
    }
}

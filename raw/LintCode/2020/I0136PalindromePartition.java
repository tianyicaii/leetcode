package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0136PalindromePartition {
    


    List<List<String>> ans;
    String s;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        this.s = s;
        dfs(new ArrayList<String>(), 0);
        return ans;
    }

    private void dfs(ArrayList<String> path, int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int len = 1; i + len <= s.length(); len++) {
            if (isPal(s, i, len)) {
                path.add(s.substring(i, i + len));
                dfs(path, i + len);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPal(String s, int i, int len) {
        int j = i + len - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

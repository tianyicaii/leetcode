package lintcode;


/*

    描述
    给出一个字符串，找到它的所有排列，注意同一个字符串不要打印两次。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1：

    输入："abb"
    输出：
    ["abb", "bab", "bba"]
    样例 2：

    输入："aabb"
    输出：
    ["aabb", "abab", "baba", "bbaa", "abba", "baab"]

*/


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class I0010StringPermutation2 {

    public List<String> stringPermutation2(String str) {
        List<String> ans = new ArrayList<>();
        dfs(ans, buildCharacterCountsMap(str), new StringBuilder());
        return ans;
    }

    private TreeMap<Character, Integer> buildCharacterCountsMap(String s) {
        TreeMap<Character, Integer> chars = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.containsKey(c)) chars.put(c, chars.get(c) + 1);
            else chars.put(c, 1);
        }
        return chars;
    }

    private void dfs(List<String> ans, TreeMap<Character, Integer> chars, StringBuilder path) {
        if (chars.isEmpty()) {
            ans.add(path.toString());
            return;
        }
        TreeMap<Character, Integer> copy = new TreeMap<>(chars);  // avoid concurrent modification
        for (Map.Entry<Character, Integer> e : copy.entrySet()) {
            char c = e.getKey();
            int v = e.getValue();
            if (v > 1) chars.put(c, v - 1);
            else chars.remove(c);

            path.append(c);
            dfs(ans, chars, path);
            path.deleteCharAt(path.length() - 1);
            chars.put(c, v);
        }
    }

    public static void main(String[] args) {
        I0010StringPermutation2 solver = new I0010StringPermutation2();
        System.out.println(solver.stringPermutation2("abb"));
    }
    
}

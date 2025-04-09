package lintcode;

import java.util.HashMap;
import java.util.HashSet;

public class I0032MinimumWindowSubstring {


    String ans;
    String source;
    String target;
    int left;
    int right;
    HashMap<Character, Integer> sourceCounts;
    HashMap<Character, Integer> targetCounts;
    HashSet<Character> containedChars;

    public String minWindow(String s , String t) {
        if (t.length() == 0) return "";

        init(s, t);
        while (true) {
            expandRight();
            if (!isValidWindow()) break;
            shrinkLeft();
            if (ans.length() == 0 || right - left < ans.length()) ans = source.substring(left, right);
            removeLeft();
        }

        return ans;
    }

    private boolean isValidWindow() {
        return targetCounts.size() == containedChars.size();
    }

    private void expandRight() {
        while (right < source.length() && !isValidWindow()) {
            addRight();
        }
    }

    private void shrinkLeft() {
        while (true) {
            char c = source.charAt(left);  // peek
            if (targetCounts.containsKey(c) && sourceCounts.get(c).equals(targetCounts.get(c))) return;
            removeLeft();
        }
    }

    private void addRight() {
        char c = source.charAt(right++);
        if (!targetCounts.containsKey(c)) return;
        sourceCounts.put(c, sourceCounts.get(c) + 1);
        if (sourceCounts.get(c) >= targetCounts.get(c)) containedChars.add(c);
    }

    private void removeLeft() {
        char c = source.charAt(left++);
        if (!targetCounts.containsKey(c)) return;
        sourceCounts.put(c, sourceCounts.get(c) - 1);
        if (sourceCounts.get(c) < targetCounts.get(c)) containedChars.remove(c);
    }

    private void init(String s, String t) {
        source = s;
        target = t;
        ans = "";
        left = 0;
        right = 0;
        
        sourceCounts = new HashMap<>();
        targetCounts = new HashMap<>();
        containedChars = new HashSet<>();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (targetCounts.containsKey(c)) targetCounts.put(c, targetCounts.get(c) + 1);
            else targetCounts.put(c, 1);
            sourceCounts.put(c, 0);
        }
    }

}

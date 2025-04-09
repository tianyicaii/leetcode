package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class I0215RateLimiter {
    

    private Map<String, ArrayList<Integer>> M = new HashMap<>();

    private int getUnitInSeconds(String rate) {
        int i = rate.indexOf('/');
        char u = rate.charAt(i + 1);
        if (u == 'm') return 60;
        if (u == 'h') return 60 * 60;
        if (u == 'd') return 60 * 60 * 24;
        return 1;
    }

    private int getLimit(String rate) {
        int i = rate.indexOf('/');
        return Integer.parseInt(rate.substring(0, i));
    }

    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        if (!M.containsKey(event)) M.put(event, new ArrayList<>());
        
        int windowSize = getUnitInSeconds(rate);
        int windowLeft = timestamp + 1 - windowSize;
        boolean isLimited = countEventsInWindow(M.get(event), windowLeft) >= getLimit(rate);
        if (!isLimited && increment) M.get(event).add(timestamp);
        return isLimited;
    }

    private int countEventsInWindow(ArrayList<Integer> list, int windowLeft) {
        if (list.isEmpty()) return 0;
        if (list.get(0) >= windowLeft) return list.size();
        int left = 0;
        int right = list.size();

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < windowLeft) left = mid;
            else right = mid;
        }
        return list.size() - (left + 1);
    }
}

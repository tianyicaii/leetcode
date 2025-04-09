package lintcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class I0471TopKFrequentWords {

    public String[] topKFrequentWords(String[] words, int k) {

        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) {
            if (!counts.containsKey(w)) counts.put(w, 0);
            counts.put(w, counts.get(w) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                int c1 = arg0.getValue();
                int c2 = arg1.getValue();
                if (c1 < c2) return -1;
                if (c1 == c2) return arg1.getKey().compareTo(arg0.getKey());
                return 1;
			}
        });

        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }

        String[] ans = new String[k];
        for (int i = k-1; i >= 0; i--) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}

package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class I0548IntersectionTwoArrays2 {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int a = nums1[i];
            int b = nums2[j];
            if (a == b) {
                ans.add(a);
                i++; j++;
            } else if (a < b) i++;
            else j++;
        }
        int[] ret = new int[ans.size()];
        for (int x = 0; x < ret.length; x++) ret[x] = ans.get(x);
        return ret;
    }

    public int[] intersection_(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums1) {
            if (!counts.containsKey(i)) counts.put(i, 0);
            counts.put(i, counts.get(i)+1);
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums2);
        for (int i : nums2) {
            if (counts.containsKey(i)) {
                ans.add(i);
                counts.put(i, counts.get(i)-1);
                if (counts.get(i) == 0) counts.remove(i);
            }
        }
        int[] ret = new int[ans.size()];
        for (int x = 0; x < ret.length; x++) ret[x] = ans.get(x);
        return ret;
    }
}

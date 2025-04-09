package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I0547IntersectionTwoArrays {
    

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
                if (ans.isEmpty() || ans.get(ans.size()-1) != a) ans.add(a);
                i++; j++;
            } else if (a < b) i++;
            else j++;
        }
        int[] ret = new int[ans.size()];
        for (int x = 0; x < ret.length; x++) ret[x] = ans.get(x);
        return ret;
    }
}

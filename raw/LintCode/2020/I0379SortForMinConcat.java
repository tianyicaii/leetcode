package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class I0379SortForMinConcat {

    class ConcatComp implements Comparator<Integer> {
        private String concat(int i, int j) {
            return "" + i + j;
        }
        @Override
        public int compare(Integer i, Integer j) {
            return concat(i, j).compareTo(concat(j, i));  // transitive
        }
    }
    
    public String minNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);
        Collections.sort(list, new ConcatComp());
        StringBuilder ans = new StringBuilder();
        for (int i : list) ans.append("" + i);
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') i++;
        return i == ans.length() ? "0" : ans.substring(i);
    }
}

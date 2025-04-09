package lintcode;

public class I0143SortColors2 {

    public void sortColors2(int[] colors, int k) {

        int[] counts = new int[k + 2];  // [1 ... k]
        int[] aux = new int[colors.length];

        for (int i : colors) counts[i + 1]++;
        for (int i = 0; i < k; i++) counts[i+1] += counts[i];
        for (int i : colors) aux[counts[i]++] = i;
        for (int i = 0; i < colors.length; i++) colors[i] = aux[i];

    }
    
}

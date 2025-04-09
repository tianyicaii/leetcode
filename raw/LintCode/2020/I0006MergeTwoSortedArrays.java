package lintcode;

import java.util.Arrays;

public class I0006MergeTwoSortedArrays {

/*

    描述
    合并两个有序升序的整数数组A和B变成一个新的数组。新数组也要有序。


    样例
    样例 1:

    输入: A=[1], B=[1]
    输出:[1,1]	
    样例解释: 返回合并后的数组。
    样例 2:

    输入: A=[1,2,3,4], B=[2,4,5,6]
    输出: [1,2,2,3,4,4,5,6]	
    样例解释: 返回合并后的数组。
    挑战
    你能否优化你的算法，如果其中一个数组很大而另一个数组很小？

*/

    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        for (int a = 0, b = 0, c = 0; c < C.length; c++) {
            if (a == A.length) C[c] = B[b++];
            else if (b == B.length) C[c] = A[a++];
            else if (A[a] <= B[b]) C[c] = A[a++];
            else C[c] = B[b++];
        }
        return C;
    }

    public static void main(String[] args) {
        I0006MergeTwoSortedArrays solver = new I0006MergeTwoSortedArrays();
        System.out.println(Arrays.toString(solver.mergeSortedArray(new int[]{1}, new int[]{1})));
        System.out.println(Arrays.toString(solver.mergeSortedArray(new int[]{1,2,3,4}, new int[]{2,4,5,6})));
    }
}

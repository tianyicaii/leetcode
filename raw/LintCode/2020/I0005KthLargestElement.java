package lintcode;

import java.util.Random;


/*

    样例
    样例 1：

    输入：
    n = 1, nums = [1,3,4,2]
    输出：
    4
    样例 2：

    输入：
    n = 3, nums = [9,3,2,4,8]
    输出：
    4
    挑战
    要求时间复杂度为O(n)，空间复杂度为O(1)。

*/


public class I0005KthLargestElement {
    
    public int kthLargestElement(int n, int[] nums) {
        n = nums.length - n;  // look for largest
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int[] equalRange = partition(nums, left, right, getPivotIndex(left, right));
            if (n < equalRange[0]) right = equalRange[0];
            else if (n >= equalRange[1]) left = equalRange[1];
            else return nums[equalRange[0]];
        }
        throw new IllegalArgumentException();
    }

    private int[] partition(int[] nums, int left, int right, int p) {
        swap(nums, left, p);
        int pivot = nums[left];
        int x = left + 1;
        while (x < right) {
            if (nums[x] < pivot) swap(nums, left++, x++);
            else if (nums[x] == pivot) x++;
            else swap(nums, x, --right);
        }
        return new int[] {left, x};
    }

    private int getPivotIndex(int left, int right) {
        Random r = new Random();
        return r.nextInt(right - left) + left;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        I0005KthLargestElement solver = new I0005KthLargestElement();
        System.out.println(solver.kthLargestElement(1, new int[]{1, 3, 4, 2}));
        System.out.println(solver.kthLargestElement(3, new int[]{9, 3, 2, 4, 8}));
    }
}

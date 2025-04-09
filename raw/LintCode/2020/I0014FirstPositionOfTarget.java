package lintcode;


/*

    描述
    给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例  1:
        输入:[1,4,4,5,7,7,8,9,9,10]，1
        输出: 0
        
        样例解释: 
        第一次出现在第0个位置。

    样例 2:
        输入: [1, 2, 3, 3, 4, 5, 10]，3
        输出: 2
        
        样例解释: 
        第一次出现在第2个位置
        
    样例 3:
        输入: [1, 2, 3, 3, 4, 5, 10]，6
        输出: -1
        
        样例解释: 
        没有出现过6， 返回-1

    挑战
    如果数组中的整数个数超过了2^32，你的算法是否会出错？

*/


class FirstPositionOfTarget {


    public int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        if (right == nums.length) return -1;
        return nums[right] == target ? right : -1;
    }





    public static void main(String[] args) {
        FirstPositionOfTarget solver = new FirstPositionOfTarget();
        System.out.println(solver.binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 3));
        System.out.println(solver.binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 6));
    }
}
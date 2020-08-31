package com.yanyi.link;

/**
 * @author chenqiang
 * @description
 */
public class Test1 {


    // 1 3 4 8 10 12 15
    public static void main(String[] args) {
        int[] nums = {1,5,6,9,10,12,19,21};
        int search = binarySearch(nums, 13);
        System.out.println("search = " + search);
    }


    private static int binarySearch(int[] num, int target){
        int left = 0;
        int right = num.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2; //防止left+right直接溢出
            if (num[mid] == target) {
                return mid;
            }else if (target > num[mid]) {
                //在右侧
                left = mid+1;
            }else if (target < num[mid]) {
                right = mid-1;
            }
        }
        return -1;
    }


    private static int leftBinarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left+(right-left)/2;
            if (nums[mid] == target){
                right = mid;
            }
        }
        return 0;
    }
}

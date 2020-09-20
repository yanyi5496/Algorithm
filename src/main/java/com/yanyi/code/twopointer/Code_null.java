package com.yanyi.code.twopointer;

/**
 * 给定一个有序整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 双指针解决
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenqiang
 * @date 2020-09-18
 */
public class Code_null {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{left, right};
            } else if (target > sum) {
                left++;
            } else if (target < sum) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 19, 22, 23};
        int[] ints = twoSum(nums, 18);
        for (int i : ints) {
            System.out.println("i = " + i);
        }
    }
}

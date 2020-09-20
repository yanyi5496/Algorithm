package com.yanyi.code.twopointer;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 通过快慢指针
 *
 * @author chenqiang
 * @date 2020-09-17
 */
public class Code_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                //如果值不相等 则慢指针的下一个值存放新的不相等值
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        //长度为索引+1
        return slow + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 5, 6, 7, 7, 9, 10};
        int i = removeDuplicates(nums);
        System.out.println("i = " + i);
    }
}

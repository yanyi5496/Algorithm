package com.yanyi.code;

/**
 * 通过快慢指针
 *
 * @author chenqiang
 * @date 2020-09-17
 */
public class Code_28 {

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
        int[] nums = new int[]{1, 5, 5, 6, 7 ,7 ,9 ,10};
        int i = removeDuplicates(nums);
        System.out.println("i = " + i);
    }
}

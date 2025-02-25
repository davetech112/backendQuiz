package org.example;

import java.util.Arrays;

public class App {
    public static void main( String[] args )
    {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        int target = 0;
        findTriplets(nums, target);

    }

    public static void findTriplets(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1, sum = target - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
    }

}

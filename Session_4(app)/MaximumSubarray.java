public class MaximumSubarray {

    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.println(maxSubArray(nums2));

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums3));

        int[] nums4 = {1};
        System.out.println(maxSubArray(nums4));
    }
}
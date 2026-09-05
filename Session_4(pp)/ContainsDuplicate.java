public class ContainsDuplicate {

    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2));

        int[] nums3 = {5};
        System.out.println(containsDuplicate(nums3));
    }
}
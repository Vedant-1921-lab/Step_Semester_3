import java.util.HashMap;
import java.util.Map;

public class SumEqualsK {

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixCount.containsKey(currentSum - k)) {
                count += prefixCount.get(currentSum - k);
            }

            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2));

        int[] nums2 = {1, -1, 0};
        System.out.println(subarraySum(nums2, 0));

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(subarraySum(nums3, 7));

        int[] nums4 = {-1, -1, 1};
        System.out.println(subarraySum(nums4, 0));
    }
}
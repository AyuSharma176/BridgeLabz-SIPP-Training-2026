
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int currentSum = numbers[left] + numbers[right];

                if (currentSum == target) {
                    // LeetCode requires 1-indexed array for this specific problem
                    return new int[] { left + 1, right + 1 };
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[] { -1, -1 };
        }
    }
}

import java.util.*;

public class HashingScenarios {

    // Scenario 1: Duplicate Session Token Detection
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    // Scenario 2: Most Frequent Error Code
    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0], bestCount = 0;

        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }
        return bestCode;
    }

    // Scenario 3: Fraud Pair Detection (Two Sum)
    public static int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];

            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            seen.put(amounts[i], i);
        }

        return new int[]{-1, -1};
    }

    // Scenario 4: Subarray Sum Equals K
    public static int subarraySumEqualsK(int[] revenueChanges, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {
            runningSum += change;

            answer += prefixCount.getOrDefault(runningSum - k, 0);

            prefixCount.merge(runningSum, 1, Integer::sum);
        }

        return answer;
    }

    // Scenario 5: Group Anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    // Scenario 6: Longest Consecutive Run
    public static int longestConsecutiveRun(int[] ids) {
        Set<Integer> idSet = new HashSet<>();

        for (int id : ids) {
            idSet.add(id);
        }

        int longest = 0;

        for (int id : idSet) {
            if (!idSet.contains(id - 1)) {
                int current = id;
                int length = 1;

                while (idSet.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

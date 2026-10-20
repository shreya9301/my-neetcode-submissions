class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute force - for every nums[i], iterate from i+1 to n to find j such that nums[j] = target - nums[i] (TC: O(N^2) SC: O(1))
        // Optimal - Make use of hashmap to store the <number, index> and check at every i if the map contains target - nums[i] key already, if yes then generate the result
        Map<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!mp.isEmpty() && mp.containsKey(target - nums[i])) {
                res[0] = mp.get(target - nums[i]);
                res[1] = i;
            }
            mp.put(nums[i], i);
        }
        return res;
    }
}

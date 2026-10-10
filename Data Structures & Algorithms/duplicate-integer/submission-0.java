class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer, Boolean> mp = new HashMap<>();
        if (n <= 1) return false;
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(nums[i])) return true;
            mp.put(nums[i], true);
        }
        return false;
    }
}
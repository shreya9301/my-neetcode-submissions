class Solution {
    public boolean isAnagram(String s, String t) {
        // Brute Force: sort the two strings and then run a loop on both to compare character by character
        // once a mismatch is found, return false [TC: O(nlogn + mlogm) SC: O(n)]

        // Solution 2 : Use a hashmap to store <character, frequency> of first string
        // Then iterate over the second string and keep decreasing the freq of characters if found
        // If freq becomes 0, remove that character from hashmap (also, if second string has a totally diff char, return false)
        // At the end of the loop, if hashmap is empty -> return true [TC: O(N) SC: O(N)]
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        for (char ch: s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (char ch: t.toCharArray()) {
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if (mp.get(ch) == 0) {
                    mp.remove(ch);
                }
            } else { return false; }
        }
        return mp.isEmpty() ? true : false;
    }
}

class Solution {
    private String computeHashOfString(String str) {
        if (str.equals("")) return "";
        int[] charFreq = new int[26];
        StringBuilder hash = new StringBuilder();
        for(char ch: str.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        for(int i = 0; i < charFreq.length; i++) {
            if(charFreq[i] > 0) {
                hash.append((char)(i + 97)).append(String.valueOf(charFreq[i]));
            }
        }
        return hash.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // Brute force : For every string in the list, first keep a frequency map/array of characters in the string
        // scan the next n-i-1 strings and compare the fequencies of the characters
        // if frq matches, then add that string in the bucket. Clear the frequency map.
        // TC: O(n^2 * lengthOfString) SC: O(N)

        // Optimal : Instead of looping through the list repeatedly, we can reduce this operation
        // by using a hashmap. Now what should be the key?? - We can create a unique hash of a string
        // by maintaining a character-frequency array, it will be unique for every anagram of that string
        // Now we'll keep scanning the array and computing the hash for each string. 
        // If it matches with any previously stored hash, then we can append that string in the hashmap value 
        // If not, then simply update our hashmap with new <hash, {string}>
        // Now iterate over the hashmap and extract the values
        // TC : O(N * lenOfLongestString) SC: O(N)
        Map<String, List<String>> mp = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            String hash = computeHashOfString(strs[i]);
            mp.computeIfAbsent(hash, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}

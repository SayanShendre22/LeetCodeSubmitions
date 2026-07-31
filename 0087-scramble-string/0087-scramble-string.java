class Solution {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    public boolean solve(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        String key = s1 + "_" + s2;

        if (map.containsKey(key))
            return map.get(key);

        int n = s1.length();

        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int x : freq) {
            if (x != 0) {
                map.put(key, false);
                return false;
            }
        }

        for (int i = 1; i < n; i++) {

            boolean swap = solve(s1.substring(0, i), s2.substring(n - i))
                    && solve(s1.substring(i), s2.substring(0, n - i));

            boolean notSwap = solve(s1.substring(0, i), s2.substring(0, i))
                    && solve(s1.substring(i), s2.substring(i));

            if (swap || notSwap) {
                // map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}
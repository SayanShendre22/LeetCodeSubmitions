class Solution {

    // Map<String, Integer> map = new HashMap<>();

    public int maxLength(List<String> arr) {
        int n = arr.size();

        String[] sarr = arr.toArray(new String[0]);

        return solve(sarr, 0, new StringBuilder(), n);
    }

    public int solve(String[] str, int idx, StringBuilder sb, int n) {

        if (idx == n) {
            return sb.length();
        }

        // if (map.containsKey(sb.toString()))
        //     return map.get(sb.toString());

        // Exclude
        int exclude = solve(str, idx + 1, sb, n);

        int include = 0;

        // Include
        if (hasDuplicate(str[idx], sb.toString())) {

            int len = sb.length();

            sb.append(str[idx]);
            include = solve(str, idx + 1, sb, n);
            sb.setLength(len); // Backtrack
        }

        // map.put(sb.toString(), Math.max(include, exclude));

        return Math.max(include, exclude);
    }

    public boolean hasDuplicate(String s1, String s2) {

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            int idx = c - 'a';
            if (freq[idx] > 0)
                return false;
            freq[idx]++;
        }

        for (char c : s2.toCharArray()) {
            int idx = c - 'a';
            if (freq[idx] > 0)
                return false;
            freq[idx]++;
        }

        return true;
    }
}
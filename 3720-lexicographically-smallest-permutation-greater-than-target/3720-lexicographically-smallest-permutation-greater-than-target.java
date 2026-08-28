class Solution {
    StringBuilder sb = new StringBuilder();

    public boolean solve(StringBuilder cur, int[] fq, String tg, int idx, boolean greater) {
        if (idx == tg.length()) {
            if (greater) {
                sb = cur;
                return true;
            }
            return false;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (fq[i - 'a'] == 0) {
                continue;
            }

            if (greater == false && i < tg.charAt(idx))
                continue;

            int len = cur.length();
            cur.append(i);
            fq[i - 'a']--;

            boolean isGreater = greater || i > tg.charAt(idx);

            if (solve(cur, fq, tg, idx + 1, isGreater)) {
                return true;
            }

            cur.setLength(len);
            fq[i - 'a']++;
        }

        return false;
    }

    public String lexGreaterPermutation(String s, String target) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;
        }

        solve(new StringBuilder(), freq, target, 0, false);

        return sb.toString();
    }
}
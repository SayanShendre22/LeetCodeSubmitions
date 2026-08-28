class Solution {
    int n;
    String sb = "";
    int freq[] = new int[26];
    char odd = '$';

    public boolean solve(StringBuilder cur, int i, String tg, boolean greater) {
        if (i == n) {
            String left = cur.toString();
            String right = new StringBuilder(left).reverse().toString();
            String res = "";

            if (odd == '$') {
                res = left + right;
            } else {
                res = left + odd + right;
            }

            if (res.compareTo(tg) > 0) {
                sb = res;
                return true;
            }

            return false;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (freq[c - 'a'] == 0)
                continue;

            if (!greater && c < tg.charAt(i)) {
                continue;
            }

            boolean isGreater = greater || c > tg.charAt(i);

            freq[c - 'a']--;
            int len = cur.length();
            cur.append(c + "");

            if (solve(cur, i + 1, tg, isGreater))
                return true;

            freq[c - 'a']++;
            cur.deleteCharAt(cur.length() - 1);

        }
        return false;
    }

    public String lexPalindromicPermutation(String s, String tg) {
        n = s.length();

        if (n == 1)
            return s.compareTo(tg) > 0 ? s : "";

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                if (odd != '$') {
                    return "";
                }
                odd = (char) (i + 'a');
            }
            freq[i] /= 2;
        }
        sb = "";
        n = n / 2;

        solve(new StringBuilder(), 0, tg, false);

        return sb.compareTo(tg) > 0 ? sb : "";
    }
}
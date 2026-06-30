class Solution {
    int freq[] = new int[3];

    public boolean checkFreq() {
        for (int i : freq) {
            if (i <= 0)
                return false;
        }
        return true;
    }

    public int numberOfSubstrings(String s) {
        int res = 0;
        int n = s.length();
        int start = 0;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;

            while (i - start >= 2 && checkFreq()) {
                res += n - i;
                int sidx = s.charAt(start) - 'a';
                freq[sidx]--;
                start++;
            }
        }
        return res;

    }
}
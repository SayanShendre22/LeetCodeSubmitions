class Solution {
    int[] freq = new int[3];

    public boolean checkFreq() {
        for (int f : freq) {
            if (f <= 0) {
                return false;
            }
        }
        return true;
    }

    public int numberOfSubstrings(String s) {

        int n = s.length();
        int res = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;

            while (checkFreq()) {
                res += n - i;
                int sidx = s.charAt(start) - 'a';
                freq[sidx]--;
                start++;
            }
        }

        return res;
    }
}
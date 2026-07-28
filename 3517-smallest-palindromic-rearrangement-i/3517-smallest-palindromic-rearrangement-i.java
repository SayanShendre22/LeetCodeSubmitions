class Solution {
    public String smallestPalindrome(String str) {
        int n = str.length();
        int fq[] = new int[26];

        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            fq[idx]++;
        }

        char[] res = new char[n];
        int s = 0, e = n - 1;
        for (int i = 0; i < 26; i++) {
            if (fq[i] != 0) {
                if (fq[i] % 2 == 0) {
                    while (fq[i] > 0) {
                        res[s++] = (char) ('a' + i);
                        res[e--] = (char) ('a' + i);
                        fq[i] = fq[i] - 2;
                    }
                } else {
                    if (fq[i] == 1) {
                        res[n / 2] = (char) ('a' + i);
                    } else {
                        while (fq[i] > 1) {
                            res[s++] = (char) ('a' + i);
                            res[e--] = (char) ('a' + i);
                            fq[i] = fq[i] - 2;
                        }
                        res[n / 2] = (char) ('a' + i);
                    }

                }
            }
        }

        return new String(res);
    }
}
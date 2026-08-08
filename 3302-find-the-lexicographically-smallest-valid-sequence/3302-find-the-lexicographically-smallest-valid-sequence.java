class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int[] last = new int[m];
        Arrays.fill(last, -1);
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && w1.charAt(i) == w2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        int[] res = new int[m];
        int skip = 0;
        j = 0;

        for (int i = 0; i < n; i++) {
            if (j == m)
                break;
            if (w1.charAt(i) == w2.charAt(j) // normal condition
                    || (skip == 0 && (j == m - 1 ||  last[j + 1] > i  )) // tying to chnage the char if not match
            ) {
                skip += w1.charAt(i) == w2.charAt(j) ? 0 : 1;
                res[j] = i;
                j++;
            }
        }

        return j == m ? res : new int[0];
    }
}
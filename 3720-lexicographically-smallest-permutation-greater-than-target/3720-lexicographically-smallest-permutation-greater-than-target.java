class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int freq[] = new int[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;
        }

        int n = s.length();
        int matched = 0;

        while (matched < n && freq[target.charAt(matched) - 'a'] > 0) {
            freq[target.charAt(matched) - 'a']--;
            matched++;
        }

        int start = matched < n ? matched : n - 1;

        // if (matched == n) {
        //     return "";
        // }

        for (int i = start; i >= 0; i--) {
            if (i < matched) {
                freq[target.charAt(i) - 'a']++;
            }

            int bigger = -1;
            for (int ch = target.charAt(i) - 'a' + 1; ch < 26; ch++) {
                if (freq[ch] > 0) {
                    bigger = ch;
                    break;
                }
            }

            if (bigger != -1) {
                freq[bigger]--;

                StringBuilder answer = new StringBuilder(target.substring(0, i));

                answer.append((char) ('a' + bigger));

                for (int ch = 0; ch < 26; ch++) {
                    while (freq[ch]-- > 0) {
                        answer.append((char) ('a' + ch));
                    }
                }

                return answer.toString();
            }
        }

        return "";
    }
}
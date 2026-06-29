class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;

        for (String str : patterns) {
            for (int i = 0; i < word.length(); i++) {
                if (word.startsWith(str, i)) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;

        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int idx = 0, d = 1;

        for (char c : s.toCharArray()) {
            sbs[idx].append(c);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder str : sbs) {
            res.append(str);
        }

        return res.toString();
    }
}
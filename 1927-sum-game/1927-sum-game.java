class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?')
                leftQ++;
            else
                leftSum += c - '0';
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?')
                rightQ++;
            else
                rightSum += c - '0';
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        // Equal number of '?'
        if (qDiff == 0) {
            return diff != 0;
        }

        // Alice can force a win unless Bob can exactly balance
        // the existing difference using the extra '?'.
        return 2 * diff + 9 * qDiff != 0;
    }
}
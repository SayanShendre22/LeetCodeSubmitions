class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else { // ')'
                stack.pop();

                if (stack.isEmpty()) {
                    // no base to calculate from
                    stack.push(i);
                } else {
                    // valid substring length
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
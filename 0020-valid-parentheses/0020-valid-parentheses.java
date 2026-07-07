class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            // open Parentheses
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                // close Parentheses
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.peek();

                if (top == '(' && c == ')') {
                    st.pop();
                } else if (top == '{' && c == '}') {
                    st.pop();
                } else if (top == '[' && c == ']') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
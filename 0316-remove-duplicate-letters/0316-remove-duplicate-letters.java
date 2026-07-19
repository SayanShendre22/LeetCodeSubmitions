class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean vis[] = new boolean[26];
        int lastPos[] = new int[26];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            lastPos[c] = i;
        }

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (vis[c]) {
                continue;
            }

            while (!st.isEmpty() && st.peek() > c) {
                int peek = st.peek();
                if (lastPos[peek] > i) {
                    st.pop();
                    vis[peek] = false;
                } else {
                    break;
                }
            }
            st.push(c);
            vis[c] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : st) {
            sb.append((char)( i + 'a'));
        }

        return sb.toString();
    }
}
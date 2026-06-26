class TrieNode {
    TrieNode left;
    TrieNode right;
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int n : nums) {
            insert(n, root);
        }
        int max = 0;
        for (int n : nums) {
            int temp = findMax(n, root);
            max = Math.max(max, temp);
        }
        return max;
    }

    public void insert(int n, TrieNode root) {
        TrieNode p = root;
        for (int i = 31; i >= 0; i--) {
            int cur = (n >> i) & 1;
            if (cur == 1) { // right
                if (p.right == null) {
                    p.right = new TrieNode();
                }
                p = p.right;
            } else { // left
                if (p.left == null) {
                    p.left = new TrieNode();
                }
                p = p.left;
            }
        }
    }

    public int findMax(int n, TrieNode root) {
        TrieNode p = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int cur = (n >> i) & 1;
            if (cur == 0) {
                if (p.right != null) {
                    res += Math.pow(2, i);
                    p = p.right;
                } else {
                    p = p.left;
                }
            } else {
                if (p.left != null) {
                    res += Math.pow(2, i);
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }
        return res;
    }
}
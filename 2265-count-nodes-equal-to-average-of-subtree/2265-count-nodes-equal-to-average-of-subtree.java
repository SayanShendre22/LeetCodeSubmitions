class Solution {
    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }

    public int[] helper(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int sum = left[0] + right[0] + node.val;
        int n = left[1] + right[1] + 1;

        if (node.val == sum / n) {
            res++;
        }

        return new int[] { sum, n };
    }
}
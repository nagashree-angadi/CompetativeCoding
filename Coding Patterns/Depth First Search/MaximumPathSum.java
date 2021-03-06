/*
* Path with Maximum Sum (hard) #
* Find the path with the maximum sum in a given binary tree.
* Write a function that returns the maximum sum.
* A path can be defined as a sequence of nodes between any two nodes
* and doesn’t necessarily pass through the root.
* */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class MaximumPathSum {

    private static int maximumSum = 0;
    public static int findMaximumPathSum(TreeNode root) {
        if(root == null)
            return 0;
        maximumSum = Integer.MIN_VALUE;;
        helper(root);
        return maximumSum;
    }

    private static int helper(TreeNode root) {
        if(root == null)
            return 0;

        int L = Math.max(helper(root.left), 0);
        int R = Math.max(helper(root.right), 0);

        maximumSum = Math.max(maximumSum, L+R+root.val);

        return Math.max(L, R)+root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}

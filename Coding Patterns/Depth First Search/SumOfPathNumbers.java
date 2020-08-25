/*
* Sum of Path Numbers (medium)
* Given a binary tree where each node can only have a digit (0-9) value,
* each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
* */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return helper(root,0);
    }

    public static int helper(TreeNode root, int number){
        if (root == null)
            return 0;

        number = number*10+root.val;
        if (root.left == null && root.right == null){
            return number;
        }

        return helper(root.left, number)+helper(root.right, number);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}

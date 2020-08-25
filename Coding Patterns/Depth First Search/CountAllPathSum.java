/*
* Count Paths for a Sum (medium)
* Given a binary tree and a number ‘S’,
* find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
* Please note that the paths can start or end at any node but all paths must follow direction
* from parent to child (top to bottom).
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

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        // TODO: Write your code here
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}

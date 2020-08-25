/*
* All Paths for a Sum (medium)
* Given a binary tree and a number ‘S’,
* find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
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

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        helper(root, sum, allPaths, new ArrayList<>());
        return allPaths;
    }

    public static void helper(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> path){
        if (root == null)
            return;

        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null){
            allPaths.add(new ArrayList<Integer>(path));
        }else{
            helper(root.left, sum-root.val, allPaths, path);
            helper(root.right, sum-root.val, allPaths, path);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}

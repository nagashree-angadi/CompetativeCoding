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
    public static int countPaths(TreeNode root, int sum) {
        List<Integer> currentPath = new LinkedList<>();
        return helper(root, sum, currentPath);
    }

    public static int helper(TreeNode root, int sum, List<Integer> path){
        if (root == null)
            return 0;

        path.add(root.val);

        int pathCount = 0, pathSum = 0;
        for(int i=path.size()-1; i>=0; i--) {
            pathSum += path.get(i);
            if (pathSum == sum) {
                pathCount++;
            }
        }

        pathCount += helper(root.left, sum, path);
        pathCount += helper(root.right, sum, path);

        path.remove(path.size() - 1);
        return pathCount;
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

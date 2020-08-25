/*
* Right View of a Binary Tree (easy) #
* Given a binary tree, return an array containing nodes in its right view.
* The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.
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

class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            TreeNode node = null;
            for( int i=0; i<len; i++) {
                node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            if(node != null)
                res.add(node);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}


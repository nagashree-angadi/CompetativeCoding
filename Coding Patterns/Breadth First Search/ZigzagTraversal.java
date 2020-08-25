/*
* Zigzag Traversal (medium)
* Given a binary tree, populate an array to represent its zigzag level order traversal.
* You should populate the values of all nodes of the first level from left to right,
* then right to left for the next level and keep alternating in the same manner for the following levels.
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

class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean reverse = false;

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            for( int i=0; i<len; i++){
                TreeNode node = q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                temp.add( node.val );
            }
            if( reverse )
                Collections.reverse(temp);

            reverse = !reverse;
            res.add(temp);
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}

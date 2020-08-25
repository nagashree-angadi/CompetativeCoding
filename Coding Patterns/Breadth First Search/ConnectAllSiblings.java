/*
* Connect All Level Order Siblings (medium) #
* Given a binary tree, connect each node with its level order successor.
* The last node of each level should point to the first node of the next level.
* */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
};

class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        TreeNode prevMain = null;
        while(!q.isEmpty()){
            int len = q.size();
            TreeNode prev = null;
            if(prevMain != null)
                prevMain.next = q.peek();
            for( int i=0; i<len; i++) {
                TreeNode node = q.poll();
                if(prev != null)
                    prev.next = node;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                prev = node;
            }
            prevMain = prev;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
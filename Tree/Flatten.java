/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Flatten {
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        
        root.left = null;
        root.right = left;
        
        TreeNode cur = root;
        
        while (cur.right != null) {
            cur = cur.right;
        }
        
        cur.right = right;
        
        
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
       if (root == null) {
           return;
       }
        
        flatten(root.right);
        flatten(root.left);
        
        root.left = null;
        root.right = prev;
        
        prev = root;
    }
}

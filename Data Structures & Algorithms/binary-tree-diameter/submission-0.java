/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int heightmax = diamTree(root);
        return diam;
    }
    int diamTree(TreeNode root){
        
        if(root == null){
            return 0;
        }
        int leftside = diamTree(root.left);
        int rightside = diamTree(root.right);
        diam = Math.max(diam , leftside+rightside);
        return 1+Math.max(leftside,rightside);
    }
}

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
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> lst = new ArrayList<>();
        search(root,x,y,-1,lst);
        //System.out.println(lst);
        return lst.get(0)==lst.get(1)?(lst.get(0)!=0):false;
    }
    public static void search(TreeNode r, int x, int y, int k, List<Integer> lst) {
        if (r!=null) {
            k++;
            if (r.left!=null && r.right!=null) {
                if ((r.left.val==x && r.right.val==y) || (r.left.val==y && r.right.val==x)) {lst.add(0);lst.add(0);}
            } 
            if (r.val==x) lst.add(k);
            if (r.val==y) lst.add(k);
            search(r.left,x,y,k,lst);
            search(r.right,x,y,k,lst);
        }
    }
}

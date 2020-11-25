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
        search(root,x,y,0,0,0,lst);
        System.out.println(lst);
        return lst.get(0)==lst.get(1);
    }
    public static boolean search(TreeNode r, int x, int y, int k, int kx, int ky,List<Integer> lst) {
        if (r!=null) {
            k++;
            if (r.left!=null && r.right!=null) {
                if ((r.left.val==x && r.right.val==y) || (r.left.val==y && r.right.val==x)) return false;
            }
            if (k>0 && r.val==x) lst.add(k);
            if (k>0 && r.val==y) lst.add(k);
            System.out.println("k="+k+"; kx="+kx+"; ky="+ky);
            if (kx>0 && ky>0 && kx==ky) return true;
            search(r.left,x,y,k,kx,ky,lst);
            search(r.right,x,y,k,kx,ky,lst);
        }
        return false;
    }
}

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
         List<Integer> list;
        
        queue.add(root);
        
        while(queue.size() > 0){
            
            int size = queue.size();
            list = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left !=null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);     
        }
        
        return result;
    }
}
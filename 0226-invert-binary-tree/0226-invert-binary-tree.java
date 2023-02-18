class Solution {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        // Base case: if the tree is empty...
        if(root != null){
            // Push the root node...
            q.add(root);
        }
        // Loop till queue is empty...
        while(!q.isEmpty()){
            // Dequeue front node...
            TreeNode temp = q.poll();
            // Enqueue left child of the popped node...
            if(temp.left != null)
                q.add(temp.left);
            // Enqueue right child of the popped node
            if(temp.right != null)
                q.add(temp.right);
            // Swapping process...
            TreeNode curr = temp.left;
            temp.left = temp.right;
            temp.right = curr;
        }
         return root;    // Return the root...
    }
}
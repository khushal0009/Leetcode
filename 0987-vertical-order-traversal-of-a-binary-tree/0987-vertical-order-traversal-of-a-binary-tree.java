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
    class Pair{
        TreeNode node;
        int x;
        int y;
        
        public Pair(TreeNode node, int x, int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Comparator<Pair> comparator=(a,b)->{
            if(a.y==b.y) return a.node.val-b.node.val;
            else return a.y-b.y;
        };
        
        HashMap<Integer,PriorityQueue<Pair>> map=new HashMap<>();
        Queue<Pair> q = new LinkedList<>();                                                                                   q.add(new Pair(root,0,0));
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        while(q.size()>0){
            Pair x=q.poll();
            
            if(!map.containsKey(x.x)){
                map.put(x.x,new PriorityQueue<>(comparator));
            }
            
            min=Math.min(min,x.x);
            max=Math.max(max,x.x);
            
            PriorityQueue<Pair> pq=map.get(x.x);
            pq.add(x);
            
            map.put(x.x,pq);
            
            if(x.node.left!=null) q.add(new Pair(x.node.left,x.x-1,x.y+1));
            if(x.node.right!=null) q.add(new Pair(x.node.right,x.x+1,x.y+1));
        }
        
        for(int i=min;i<=max;i++){
            List<Integer> temp=new ArrayList<>();
            
            PriorityQueue<Pair> pq=map.get(i);
            
            while(pq.size()>0){
                temp.add(pq.poll().node.val);
            }
            ans.add(temp);
        }
        
        return ans;
    }
}
class MyStack {
    
    private Queue<Integer> que;
    private Queue<Integer> queHelper;

    public MyStack() {
        que = new LinkedList<>();
        queHelper = new LinkedList<>();
    }
    
    public void push(int x) {
        que.add(x);
    }
    
    public int pop() {

        while (que.size() > 1){
            queHelper.add(que.remove());
        }

        int pop = que.remove();
        while (queHelper.size() > 0){
            que.add(queHelper.remove());
        }

        return pop;
    }
    
    public int top() {

        while (que.size() > 1){
            queHelper.add(que.remove());
        }

        int top = que.remove();
        while (queHelper.size() > 0){
            que.add(queHelper.remove());
        }
        que.add(top);
        
        return top;
    }
    
    public boolean empty() {
        return que.isEmpty();
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
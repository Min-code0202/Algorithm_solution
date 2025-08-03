public class CustomStack{
    static class Node{
        Object data;
        Node link;
        public Node(Object data, Node link){
            super();
            this.data = data;
            this.link = link;
        }
        public Node(Object data){
            this(data, null);
        }
    }

    private Node top;
    private int size = 0;
    public void push(Object data){
        top = new Node(data, top.link);
        size++;
    }
    public Object pop(){
        if(isEmpty()) throw new NullPointerException("스택 비어있음");
        Node popNode = top;
        top = popNode.link;
        size--;
        return popNode.data;
    }
    public Object peek(){
        if(isEmpty()) throw new NullPointerException("스택 비어있음");
        return top.data;
    }
    public boolean isEmpty(){
        if(top == null) return true;
        return false;
    }
}
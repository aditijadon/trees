package datastructures;

public class StackUADriver {
    public static void main(String[] args){

        StackUsingArrayList<Integer> stack = new StackUsingArrayList();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);

        System.out.println("isEmpty? " + stack.isEmpty());
        System.out.println("peek " + stack.peek());
        System.out.println("size " + stack.size());
        System.out.println("pop " + stack.pop());
        System.out.println("peek " + stack.peek());

    }

}

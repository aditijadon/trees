package datastructures;

public class QueueUADriver {
    public static void main(String[] args){

        QueueUsingArrayList<Integer> queue = new QueueUsingArrayList();
        queue.enqueue(8);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(1);

        System.out.println("isEmpty? " + queue.isEmpty());
        System.out.println("dequeue " + queue.dequeue());
        System.out.println("size " + queue.size());
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("size" + queue.size());

    }
}

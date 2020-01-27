package datastructures;

public class LinkedListDriver {
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList();
        ll.insertAt(3,0);
        ll.insertAt(8,1);
        ll.insertAt(6,2);
        ll.insertAt(3,3);

        System.out.print(ll.getHead());
        ll.printList(ll);
        ll.deleteNodeAt(6);
        ll.printList(ll);
        //ll.reverse(ll.head);


    }
}

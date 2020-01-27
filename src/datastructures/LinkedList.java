package datastructures;

public class LinkedList<T> {

    public LNode<T> head = null;


    boolean isEmpty() {
        return (head == null);
    }

    public LNode getHead(){
        return head;
    }


    public LNode insertAt(T data, int position) {
        LNode newNode = new LNode(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        LNode prev = null;
        LNode current = head;
        int count=0;

        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }

        newNode.next = prev.next;
        prev.next = newNode;
        return head;

    }

    public void deleteNodeAt(int position) {
        if (head == null){
            System.out.println("nothing to delete");
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        LNode prev = null;
        LNode current = head;
        int count=0;

        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }

        if(current == null ){
            System.out.println("invalid position");
        }

        prev.next = current.next;

    }




    public LNode reverse(LNode h) {
        if (head == null || head.next == null) {
            return head;
        }

        LNode p = head;
        LNode c = head.next;
        LNode n = c.next;

        if (head.next.next == null) {
            p = c;
            c = c.next;
            c.next = p;
            return head;
        }

        while (n.next != null) {
           c.next = p;
           p.next = n;
           c = n;
           n = n.next;
           head = c;
        }
        return head;

    }

    public void printList(LinkedList list) {
        LNode curr = list.head;
        System.out.print("LinkedList: ");
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }

}














 /*      int count = 0;
        LNode curr = head;
        LNode prev = null;

        while (count != position) {
            curr = curr.next;
            prev = curr;
            count++;
        }

        LNode<T> newNode = new LNode(data);
        newNode.next = curr;
        if (count == 0) {
            head = newNode;
        }
        else {
            prev.next = newNode;
        }*/




/* LNode temp = head;
        while (temp != after) {
            temp = temp.next;
        }
        if (temp == after)
            temp.next = temp.next.next; */


/*
    public void insertAfter(LNode after, int newValue) {
        if (after == null) {
            System.out.println("after is null");
            return;
        }
        LNode newNode = new LNode(newValue);
        newNode.next = after.next;
        after.next = newNode;
    }

    public void deleteAfter(LNode after) {
        if (after == null) {
            System.out.println("after is null");
            return;
        }

        if (after.next == null) {
            System.out.println("noting to delete");
        } else {
            LNode temp = head;
            while (temp != after) {
                temp = temp.next;
            }
            if (temp == after)
                temp.next = temp.next.next;
        } */


   /* public void insertAfter(LNode after, int value){
        if(after == null){
            LNode n = new LNode(value);
        }

       LNode temp = head;
        while(temp != after){
            temp = temp.next;
        }

        if(temp == after){
            LNode n = new LNode(value);
            n.next = temp.next;
            after.next = n;

        }  */
//temp!=null &&

//while(temp != null) {
//            for (int i = 0; i < position - 1; i++) {
//                temp = temp.next;
//            }
//        }
//
//        if (temp == null || temp.next == null) return;
//
//        LNode next = temp.next.next;
//        temp.next = next;
//    }
//LNode next = temp.next.next;
//        temp.next = next;
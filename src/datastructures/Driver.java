package datastructures;

public class Driver {

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
//        bt.add(3);
//        bt.add(6);
//        bt.add(4);
//        bt.add(9);
//        bt.add(7);
//        bt.add(1);
//        bt.add(2);

        bt.root = new Node(1);
//        bt.root.left = new Node(2);
//        bt.root.left.left = new Node(4);
//        bt.root.left.left.left = new Node(9);
//        bt.root.left.left.right = new Node(14);
//        bt.root.left.right = new Node(5);
//        bt.root.right = new Node(3);
//        bt.root.right.right = new Node(6);
//        bt.root.right.right.left = new Node(7);
//        bt.root.right.right.left.right = new Node(8);
//        bt.root.right.right.left.right.right = new Node(9);
        bt.topView(bt.root);
    }
}

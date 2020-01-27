public class TreeTraversal
{

    Node root;
    TreeTraversal(){
        root = null;
    }

    void addNode(){

    }

    void Preorder(Node n)
    {
        if (n == null) return;
        System.out.print(n.key + " ");
        Preorder(n.left);
        Preorder(n.right);
    }

    void Postorder(Node n) {
        if (n == null) return;
        Postorder(n.left);
        Postorder(n.right);
        System.out.print(n.key + " ");
    }


    void Inorder(Node n)
    {
        if (n == null) return;
        Inorder(n.left);
        System.out.print(n.key + " ");
        Inorder(n.right);
    }


    void Postorder()  {     Postorder(root);  }
    void Inorder()    {     Inorder(root);   }
    void Preorder()   {     Preorder(root);  }


    public static void main(String[] args)
    {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(10);
        tree.root.left = new Node(43);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(21);
        tree.root.left.left.left = new Node(9);
        tree.root.left.left.right = new Node(14);
        tree.root.left.right = new Node(33);
        tree.root.left.right.left = new Node(2);
        tree.root.left.right.right = new Node(3);

        System.out.println("Preorder is ");
        tree.Preorder();
        System.out.println("\nInorder is ");
        tree.Inorder();
        System.out.println("\nPostorder is ");
        tree.Postorder();
    }
}


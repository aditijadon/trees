import java.util.Stack;

public class ForLoopTraversal
{
    Node root;
    void inorder()
    {
        if (root == null) return;
        Stack<Node> s = new Stack<Node>();
        Node current = root;
        while (current != null || s.size() > 0)
        {
            while (current !=  null)
            {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            System.out.print(current + " ");
            System.out.print(current.right + " ");
            current = current.right;
        }
    }

    void preorder(){
        if (root==null) return;
    }
    void postorder(){
        if (root==null) return;
    }

    public static void main(String args[])
    {

        ForLoopTraversal tree = new ForLoopTraversal();
        tree.root = new Node(10);
        tree.root.left = new Node(43);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(21);
        tree.root.left.left.left = new Node(9);
        tree.root.left.left.right = new Node(14);
        tree.root.left.right = new Node(33);
        tree.root.left.right.left = new Node(2);
        tree.root.left.right.right = new Node(3);
        tree.inorder();
    }
}

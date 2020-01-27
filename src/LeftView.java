class LeftView
{
    Node root;
    static int Min = 0;

    void leftStep(Node node, int level)
    {

        if (node == null)
            return;
        if (Min < level) {
            System.out.print(" " + node.key);
            Min = level;
        }
        leftStep(node.left, level + 1);
        leftStep(node.right, level + 1);
    }

    void leftView()
    {
        leftStep(root, 1);
    }

    public static void main(String args[])
    {

        LeftView tree = new LeftView();
        tree.root = new Node(10);
        tree.root.left = new Node(43);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(21);
        tree.root.left.left.left = new Node(9);
        tree.root.left.left.right = new Node(14);
        tree.root.left.right = new Node(33);
        tree.root.left.right.left = new Node(2);
        tree.root.left.right.right = new Node(3);

        tree.leftView();
    }
} 
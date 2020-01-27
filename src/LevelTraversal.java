public class LevelTraversal {
    Node root;

    LevelTraversal() {
        root = null;
    }

    int height(Node root) {
        int height = 0;
        if (root != null) {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            height = (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
        }
        return height;
    }

    void forEveryLevel() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            LevelTraversal(root, i);
        }
    }

    void LevelTraversal(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.key);
        else if (level > 1) {
            LevelTraversal(root.left, level - 1);
            LevelTraversal(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        LevelTraversal l = new LevelTraversal();
        l.root = new Node(10);
        l.root.left = new Node(43);
        l.root.right = new Node(22);
        l.root.left.left = new Node(21);
        l.root.left.left.left = new Node(9);
        l.root.left.left.right = new Node(14);
        l.root.left.right = new Node(33);
        l.root.left.right.left = new Node(2);
        l.root.left.right.right = new Node(3);

        System.out.println("level traversal is : ");
        l.forEveryLevel();
    }
}

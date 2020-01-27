package datastructures;

import java.util.*;
import java.util.LinkedList;


public class BinaryTree {

    private Node root;

    public Node addNode(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }
        if (key < current.value) {
            current.left = addNode(current.left, key);
        } else if (key > current.value) {
            current.right = addNode(current.right, key);
        } else {
            return current;
        }
        return current;
    }

    public void add(int key) {
        root = addNode(root, key);
    }


    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }


    public void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.value + " ");
        inorder(n.right);
    }


    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }


    public void preorderWithoutRecursion() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {

            Node node = stack.pop();
            System.out.print(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    public void inorderWithoutRecursion() {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (curr != null || !s.empty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
    }


    public ArrayList<Integer> postorderWithoutRecursion() {
        Stack<Node> S = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        S.push(root);
        Node node = null;

        while (!S.isEmpty()) {
            Node current = S.peek();

            if (node == null) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.value);
                }

            } else if (current.left == node) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.value);
                }

            } else if (current.right == node) {
                S.pop();
                list.add(current.value);
            }
            node = current;
        }
        return list;
    }


    public int height(Node root) {
        int height = 0;
        if (root != null) {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            height = (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
        }
        return height;
    }

    public void forEveryLevel() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            levelOrderTraversalGfg(root, i);
        }
    }

    public void levelOrderTraversalGfg(Node root, int level) {         //0(n^2)
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.value);
        else if (level > 1) {
            levelOrderTraversalGfg(root.left, level - 1);
            levelOrderTraversalGfg(root.right, level - 1);
        }
    }


    public void levelOrderTraversalUtil(Node root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level);
        levelOrderTraversalUtil(root.left, level + 1, map);
        levelOrderTraversalUtil(root.right, level + 1, map);
    }


    public void levelOrderTraversal() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        levelOrderTraversalUtil(root, 1, map);
        for (int i = 1; i < map.size(); i++) {
            System.out.println("Level " + i + ": " + map.get(i));
        }
    }


    public static void levelOrderTraversalQueue(Node root) {
        QueueUsingArrayList<Node> queue = new QueueUsingArrayList<>();
        queue.enqueue(root);
        Node curr;
        while (!queue.isEmpty()) {
            curr = queue.dequeue();
            System.out.print(curr.value + " ");

            if (curr.left != null) {
                queue.enqueue(curr.left);
            }

            if (curr.right != null) {
                queue.enqueue(curr.right);
            }
        }
    }


    public static void insertIntoMap(Integer key, Integer value, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }


    public static void VerticalOrderTraversalUtil(Node node, int dist, Map<Integer, List<Integer>> map, int maxHd, int minHd) {
        if (node == null) {
            return;
        }
        maxHd = dist > maxHd ? dist : maxHd;
        minHd = dist < minHd ? dist : minHd;

        insertIntoMap(dist, node.value, map);
        VerticalOrderTraversalUtil(node.left, dist - 1, map, maxHd, minHd);
        VerticalOrderTraversalUtil(node.right, dist + 1, map, maxHd, minHd);
    }

    public static void VerticalOrderTraversal(Node root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxHd = 0;
        int minHd = 0;
        VerticalOrderTraversalUtil(root, 0, map, maxHd, minHd);

        for (int i = 1; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }


    public void topView(Node r) {
        if (root == null) {
            return;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root.value);

        Node curr = root;
        while (root.left != null) {
            stack.push(root.left.value);
            root = root.left;
        }

        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr.right.value);
        curr = curr.right;

        while (curr.right != null) {
            queue.add(curr.right.value);
            curr = curr.right;
        }

        while (queue.size() != 0) {
            System.out.println(queue.poll());
        }

    }


    public void BottomView(Node root) {

    }


    public void LeftView(Node root) {

        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }


    public void leftViewUtil(Node root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(level)) {
            map.put(level, root.value);
        }
        leftViewUtil(root.left, level + 1, map);
        leftViewUtil(root.right, level + 1, map);
    }


    public void leftView(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        leftViewUtil(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i));
        }
    }


    public static void rightView(Node root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(level, root.value);
        rightView(root.left, level + 1, map);
        rightView(root.right, level + 1, map);
    }


    public static void rightView(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        rightView(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }


    public boolean bfsWithoutRecursion(Node root, int k) {
        if (root == null)
            return false;
        QueueUsingArrayList<Node> queue = new QueueUsingArrayList<>();
        queue.enqueue(root);

        Node curr;
        while (!queue.isEmpty()) {
            curr = queue.dequeue();
            if (curr.value == k) {
                return true;
            }
            if (curr.left != null) {
                queue.enqueue(curr.left);
            }
            if (curr.right != null) {
                queue.enqueue(curr.right);
            }
        }
        return false;
    }

    //TODO ye vala baaki hai
    public boolean bfsRecursion(Node root, int k) {
        if (root == null) {
            return false;
        } else if (root.value == k) {
            return true;
        } else {
            return false;
        }
    }


    public boolean dfsRecursion(Node root, int k) {
        if (root == null) {
            return false;
        } else if (root.value == k) {
            return true;
        } else {
            return dfsRecursion(root.left, k) || dfsRecursion(root.right, k);  //or merge all three
        }
    }


    public static boolean dfsUsingStack(Node root, int k) {
        if (root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.value == k) {
                return true;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return false;
    }

    public static boolean dfsUsingHash(Node root, int k) {
        if (root == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            set.add(current);
            if (current.value == k) {
                return true;
            }
            if (current.right != null && !set.contains(current.right)) {
                stack.push(current.right);
            }
            if (current.left != null && !set.contains(current.left)) {
                stack.push(current.left);
            }
        }
        return false;
    }

}


//&& stack.peek() == root

/*public void postorderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            if (stack.empty()) {
                return;
            }
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root) {
                root = root.right;
            } else {
                System.out.print(root.value + " ");
                root = null;
            }
        }
    }*/
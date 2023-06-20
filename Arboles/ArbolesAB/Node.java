package ArbolesAB;

class Node 

{
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public boolean allLeavesAtLastLevel() {
        return allLeavesAtLastLevelUtil(root);
    }

    private boolean allLeavesAtLastLevelUtil(Node node) {
        // Verificar si el nodo es nulo
        if (node == null) {
            return true;
        }

        // Verificar si el nodo es hoja o si es el último nivel
        if (node.left == null && node.right == null) {
            return true;
        }

        // Verificar si el nodo tiene ambos hijos
        if (node.left != null && node.right != null) {
            return allLeavesAtLastLevelUtil(node.left) && allLeavesAtLastLevelUtil(node.right);
        }

        // Si el nodo tiene solo un hijo, entonces no todos los nodos en el último nivel son hojas
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        System.out.println("Todos los nodos en el último nivel son hojas: " + tree.allLeavesAtLastLevel());
    }
}

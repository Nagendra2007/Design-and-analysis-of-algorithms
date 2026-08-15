package week2.kthSmallestElement;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insertRec(node.left, value);
        } else if (value > node.data) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRec(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = findMin(node.right);
            node.data = successor.data;
            node.right = deleteRec(node.right, successor.data);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node == null) return;
        inorderRec(node.left);
        System.out.print(node.data + " ");
        inorderRec(node.right);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            tree.insert(sc.nextInt());
        }

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.print("Enter value to delete: ");
        int val = sc.nextInt();
        tree.delete(val);

        System.out.print("Inorder after deletion: ");
        tree.inorder();

        sc.close();
    }
}

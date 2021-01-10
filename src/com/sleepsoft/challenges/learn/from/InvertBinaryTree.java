package com.sleepsoft.challenges.learn.from;
// A node contains the value, left and right pointers
class Node
{
    int data;
    Node left, right;


    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;

    void invert()
    {
        root = invert(root);
    }

    Node invert(Node node)
    {
        if (node == null) return null;
        Node left = invert(node.right);
        Node right = invert(node.left);
        node.right = right;
        node.left = left;
        return node;
    }

    void print_tree()
    {
        print_tree(root);
    }

    // print InOrder binary tree traversal.
    void print_tree(Node node)
    {
        if (node == null)
            return;

        print_tree(node.left);
        System.out.print(node.data + " ");

        print_tree(node.right);
    }

    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(1);
        tree.root.right = new Node(4);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.print_tree();
        System.out.println("");

        /* invert tree */
        tree.invert();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.print_tree();

    }
}
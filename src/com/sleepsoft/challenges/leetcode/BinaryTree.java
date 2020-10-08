package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Node{
    public long value;
    public Node rightNode;
    public Node leftNode;
    public Node(long value){
        this.value = value;
    }
}
public class BinaryTree {
    private static long getRightValue(Node node){
        if (node.rightNode!=null) {
            return node.value+getRightValue(node.rightNode);
        }
        return node.value;
    }

    private static long getLeftValue(Node node){
        if (node.leftNode!=null) {
            return node.value+getLeftValue(node.leftNode);
        }
        return node.value;
    }

    public static String solution(long[] arr) {
        List<Node> levelNodes = new ArrayList<>();
        // Type your solution here
        if (arr!=null && arr.length>0) {
            int currentNode = 0;
            Node root = new Node(arr[currentNode]);

            levelNodes.add(root);
            while (levelNodes.size()>0){
                Node node = levelNodes.get(0);
                levelNodes.remove(0);
                if (arr.length>currentNode+1) {
                    node.leftNode=new Node(arr[currentNode+1]);
                    levelNodes.add(node.leftNode);
                }
                if (arr.length>currentNode+2) {
                    node.rightNode=new Node(arr[currentNode+2]);
                    levelNodes.add(node.rightNode);
                }
                currentNode=currentNode+2;
            }
            long leftValue = getLeftValue(root);
            long rightValue = getRightValue(root);
            if (leftValue>rightValue) return "Left";
            if (rightValue>leftValue) return "Right";
        }
        return"";
    }

    @Test
    public void test(){
        System.out.printf("Array [1, 4, 100, 5]: %s\n", solution(new long[]{1, 10, 5, 1, 0, 6}));
    }
}
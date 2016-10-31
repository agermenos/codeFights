package com.sleepsoft.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agermenos on 10/12/2016.
 */
public class Node {
    private List<Node> children = new ArrayList<>();
    public void addNode(Node n) {children.add(n);}
    private String value;

    public boolean hasChildren(){
        if (children==null || children.size()==0)
            return false;
        return true;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChildren(){
        return this.children;
    }

}

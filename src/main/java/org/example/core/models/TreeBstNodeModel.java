package org.example.core.models;

public class TreeBstNodeModel {
    private int value;
    private TreeBstNodeModel left;
    private TreeBstNodeModel right;

    public TreeBstNodeModel(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeBstNodeModel getLeft() {
        return left;
    }

    public void setLeft(TreeBstNodeModel left) {
        this.left = left;
    }

    public TreeBstNodeModel getRight() {
        return right;
    }

    public void setRight(TreeBstNodeModel right) {
        this.right = right;
    }
}

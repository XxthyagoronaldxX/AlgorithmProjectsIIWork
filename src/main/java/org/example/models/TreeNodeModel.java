package org.example.models;

public class TreeNodeModel {
    private int value;
    private TreeNodeModel left;
    private TreeNodeModel right;

    public TreeNodeModel(int value) {
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

    public TreeNodeModel getLeft() {
        return left;
    }

    public void setLeft(TreeNodeModel left) {
        this.left = left;
    }

    public TreeNodeModel getRight() {
        return right;
    }

    public void setRight(TreeNodeModel right) {
        this.right = right;
    }
}

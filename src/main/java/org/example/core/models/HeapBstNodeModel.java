package org.example.core.custom;

import java.util.Objects;

public class HeapBstNodeModel {
    private int value;
    private int priority;
    private HeapBstNodeModel parent;
    private HeapBstNodeModel left;
    private HeapBstNodeModel right;

    public HeapBstNodeModel(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeapBstNodeModel that = (HeapBstNodeModel) o;

        if (value != that.value) return false;
        if (priority != that.priority) return false;
        if (!Objects.equals(left, that.left)) return false;
        return Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + priority;
        return result;
    }

    public int getValue() {
        return value;
    }

    public HeapBstNodeModel getParent() {
        return parent;
    }

    public void setParent(HeapBstNodeModel parent) {
        this.parent = parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public HeapBstNodeModel getLeft() {
        return left;
    }

    public void setLeft(HeapBstNodeModel left) {
        this.left = left;
    }

    public HeapBstNodeModel getRight() {
        return right;
    }

    public void setRight(HeapBstNodeModel right) {
        this.right = right;
    }
}

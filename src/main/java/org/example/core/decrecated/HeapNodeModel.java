package org.example.core.decrecated;

public class HeapNodeModel {
    private int priority;
    private char value;

    public HeapNodeModel(int priority, char value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}

package org.example.core.models;

import java.util.*;

public class TreeHeapModel {
    private final HeapNodeModel[] nodes;
    private int end;
    private final int size;

    public TreeHeapModel(int size) {
        this.nodes = new HeapNodeModel[size];
        this.end = 0;
        this.size = size;
    }

    public TreeHeapModel addNode(char value, int priority) {
        if (end + 1 > size) return null;

        HeapNodeModel heapNodeModel = new HeapNodeModel(priority, value);
        nodes[end++] = heapNodeModel;

        return this;
    }

    public TreeHeapModel heapMax() {
        int half = end / 2;

        for (int i = half;i >= 0;i--)
            heapDecreaseKey(i + 1);

        return this;
    }

    private void heapDecreaseKey(int i) {
        int child = i * 2;
        int size = end - 1;

        while (child <= size) {
            int higher = child;

            if (higher < size && nodes[higher].getPriority() < nodes[higher + 1].getPriority())
                higher++;

            if (nodes[i].getPriority() < nodes[higher].getPriority()) {
                changeValues(i, higher);
                i = higher;
                child = i * 2;
            } else {
                child = size + 1;
            }
        }
    }

    private void changeValues(int i, int j) {
        HeapNodeModel auxNode = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = auxNode;
    }

    @Override
    public String toString() {
        return Arrays.stream(nodes)
                .map(node -> node.getPriority() + " ")
                .reduce("", (node, acc) -> node + acc);
    }
}

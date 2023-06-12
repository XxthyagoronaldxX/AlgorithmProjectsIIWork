package org.example.core.models;

import java.util.*;

public class TreeHeapBstModel {
    private HeapBstNodeModel rootNode;

    public void add(int value, int priority) {
        HeapBstNodeModel node = new HeapBstNodeModel(value, priority);

        if (rootNode == null) { //Árvore vazia.
            rootNode = node;
        } else if (priority > rootNode.getPriority()) { //Caso o Nó tenha uma prioridade maior que o nó raiz.
            if (value > rootNode.getValue())
                node.setLeft(rootNode);
            else
                node.setRight(rootNode);

            rootNode.setParent(node);

            rootNode = node;
        } else {
            HeapBstNodeModel currentNode = rootNode;

            while (true) {
                if (priority > currentNode.getPriority()) {
                    HeapBstNodeModel rightNode = currentNode.getRight();
                    HeapBstNodeModel leftNode = currentNode.getLeft();
                    HeapBstNodeModel parentNode = currentNode.getParent();

                    node.setParent(parentNode);

                    if (value > currentNode.getValue()) {
                        if (rightNode == null || value > rightNode.getValue()) {
                            node.setLeft(currentNode);
                        } else {
                            node.setLeft(currentNode);
                            node.setRight(currentNode.getRight());
                            currentNode.setRight(null);
                        }
                    } else {
                        if (leftNode == null || value < leftNode.getValue()){
                            node.setRight(currentNode);
                        } else {
                            node.setRight(currentNode);
                            node.setLeft(currentNode.getLeft());
                            currentNode.setLeft(null);
                        }
                    }

                    if (parentNode.getRight() != null && parentNode.getRight().equals(currentNode))
                        parentNode.setRight(node);
                    else
                        parentNode.setLeft(node);

                    currentNode.setParent(node);
                    break;
                } else {
                    if (value > currentNode.getValue()) {
                        if (currentNode.getRight() == null) {
                            node.setParent(currentNode);
                            currentNode.setRight(node);
                            break;
                        } else {
                            currentNode = currentNode.getRight();
                        }
                    } else {
                        if (currentNode.getLeft() == null) {
                            node.setParent(currentNode);
                            currentNode.setLeft(node);
                            break;
                        } else {
                            currentNode = currentNode.getLeft();
                        }
                    }
                }
            }
        }
    }

    public String customToString(HeapBstNodeModel node) {
        if (node == null) return "";

        return "(" + customToString(node.getLeft()) + ((char) node.getValue()) + "/" + node.getPriority() + customToString(node.getRight()) + ")";
    }

    @Override
    public String toString() {
        return customToString(rootNode);
    }
}

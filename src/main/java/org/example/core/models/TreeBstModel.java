package org.example.core.models;

public class TreeBstModel {
    private TreeBstNodeModel rootNode;

    public TreeBstModel() {
        this.rootNode = null;
    }

    public static TreeBstModel buildFromValues(int[] values, int k) {
        TreeBstModel treeBstModel = new TreeBstModel();

        for (int i = 0;i < k;i++)
            treeBstModel.addNode(values[i]);

        return treeBstModel;
    }

    public boolean searchInTree(int value) {
        TreeBstNodeModel currentNode = rootNode;

        while (currentNode != null) {
            if (value > currentNode.getValue())
                currentNode = currentNode.getRight();
            else if (value < currentNode.getValue())
                currentNode = currentNode.getLeft();
            else return true;
        }

        return false;
    }

    public void addNode(int value) {
        if (searchInTree(value)) return;

        TreeBstNodeModel node = new TreeBstNodeModel(value);

        if (rootNode == null) {
            rootNode = node;
            return;
        }

        TreeBstNodeModel currentNode = rootNode;

        while (true) {
            if (node.getValue() > currentNode.getValue()) {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(node);
                    break;
                }

                currentNode = currentNode.getRight();
            } else {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(node);
                    break;
                }

                currentNode = currentNode.getLeft();
            }
        }
    }

    public TreeBstNodeModel getRootNode() {
        return rootNode;
    }
}

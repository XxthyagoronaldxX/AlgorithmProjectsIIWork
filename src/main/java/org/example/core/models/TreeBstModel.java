package org.example.core.models;

public class TreeBstModel {
    private TreeNodeModel rootNode;

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
        TreeNodeModel currentNode = rootNode;

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

        TreeNodeModel node = new TreeNodeModel(value);

        if (rootNode == null) {
            rootNode = node;
            return;
        }

        TreeNodeModel currentNode = rootNode;

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

    public TreeNodeModel getRootNode() {
        return rootNode;
    }
}

package org.example.models;

public class TreeBstModel {
    private TreeNodeModel rootNode;
    private String acc;

    private TreeBstModel() {
        this.rootNode = null;
    }

    public static TreeBstModel buildFromValues(int[] values, int k) {
        TreeBstModel treeBstModel = new TreeBstModel();

        for (int i = 0;i < k;i++)
            treeBstModel.addNode(values[i]);

        return treeBstModel;
    }

    public void addNode(int value) {
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

    public String printPreOrder() {
        acc = "";

        preOrder(rootNode);

        return acc;
    }

    private void preOrder(TreeNodeModel node) {
        if (node != null) {
            acc += " " + node.getValue();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public String printInOrder() {
        acc = "";

        inOrder(rootNode);

        return acc;
    }

    private void inOrder(TreeNodeModel node) {
        if (node != null) {
            inOrder(node.getLeft());
            acc += " " + node.getValue();
            inOrder(node.getRight());
        }
    }

    public String printPosOrder() {
        acc = "";

        posOrder(rootNode);

        return acc;
    }

    private void posOrder(TreeNodeModel node) {
        if (node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            acc += " " + node.getValue();
        }
    }

    @Override
    public String toString() {
        return "Pre.:" + printPreOrder() + "\n" +
                "In..:" + printInOrder() + "\n" +
                "Post:" + printPosOrder() + "\n";
    }
}

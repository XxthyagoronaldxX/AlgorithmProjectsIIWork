package org.example.core.helpers;

import org.example.core.models.TreeBstModel;
import org.example.core.models.TreeBstNodeModel;

public class TreeHelper {
    private static String acc;

    public static String printTree(TreeBstModel treeBstModel) {
        return "Pre.:" + printPreOrder(treeBstModel) + "\n"
                + "In..:" + printInOrder(treeBstModel) + "\n"
                + "Post:" + printPosOrder(treeBstModel) + "\n";
    }

    public static String printPreOrder(TreeBstModel treeBstModel) {
        acc = "";

        preOrder(treeBstModel.getRootNode());

        return acc;
    }

    private static void preOrder(TreeBstNodeModel node) {
        if (node != null) {
            acc += " " + node.getValue();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static String printInOrder(TreeBstModel treeBstModel) {
        acc = "";

        inOrder(treeBstModel.getRootNode());

        return acc;
    }

    private static void inOrder(TreeBstNodeModel node) {
        if (node != null) {
            inOrder(node.getLeft());
            acc += " " + node.getValue();
            inOrder(node.getRight());
        }
    }

    public static String printPosOrder(TreeBstModel treeBstModel) {
        acc = "";

        posOrder(treeBstModel.getRootNode());

        return acc;
    }

    private static void posOrder(TreeBstNodeModel node) {
        if (node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            acc += " " + node.getValue();
        }
    }
}

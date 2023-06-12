package org.example.activity01.letterC;

import org.example.core.models.TreeHeapModel;

public class Main {
    public static void main(String[] args) {
        TreeHeapModel treeHeapModel = new TreeHeapModel(3);

        System.out.println(treeHeapModel.addNode('a', 7)
                .addNode('b', 4)
                .addNode('c', 6)
                .heapMax()
                .toString());
    }
}

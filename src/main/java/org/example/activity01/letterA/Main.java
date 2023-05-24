package org.example.activity01.letterA;

import org.example.core.helpers.TreeHelper;
import org.example.core.models.TreeBstModel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        int tests = read.nextInt();

        for (int i = 0; i < tests; i++) {
            int k = read.nextInt();

            int[] values = new int[k];
            for (int j = 0; j < k; j++)
                values[j] = read.nextInt();

            TreeBstModel treeBst = TreeBstModel.buildFromValues(values, k);

            result.append("Case ").append(i + 1).append(":\n").append(TreeHelper.printTree(treeBst)).append("\n");
        }

        System.out.print(result);
        read.close();
    }
}

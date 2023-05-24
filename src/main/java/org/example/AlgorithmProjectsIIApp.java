package org.example;

import org.example.models.TreeBstModel;

import java.util.Scanner;

public class AlgorithmProjectsIIApp {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int tests = read.nextInt();

        for (int i = 0;i < tests;i++) {
            int k = read.nextInt();

            int[] values = new int[k];
            for (int j = 0;j < k;j++)
                values[j] = read.nextInt();

            TreeBstModel treeBst = TreeBstModel.buildFromValues(values, k);

            result.append("Case ")
                    .append(i + 1)
                    .append(":\n")
                    .append(treeBst)
                    .append("\n");
        }

        System.out.print(result);
        read.close();
    }
}

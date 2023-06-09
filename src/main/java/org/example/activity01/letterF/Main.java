package org.example.activity01.letterF;

import java.util.Scanner;

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        int tests = read.nextInt();

        for (int i = 0;i < tests;i++) {
            int addresses = read.nextInt();
            int inputs = read.nextInt();

            int[] values = new int[inputs];
            for (int j = 0;j < inputs;j++)
                values[j] = read.nextInt();

            for (int j = 0;j < addresses;j++) {
                output.append(j).append(" -> ");

                for (int k = 0; k < inputs; k++) {
                    if (values[k] % addresses == j) {
                        output.append(values[k]).append(" -> ");
                    }
                }

                output.append("\\").append("\n");
            }

            if (i+1 != tests) output.append("\n");
        }

        System.out.print(output);
    }
}

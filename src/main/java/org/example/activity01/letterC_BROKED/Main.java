package org.example.activity01.letterC_BROKED;

import org.example.core.models.TreeHeapBstModel;

import java.util.Scanner;

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();

        while(true) {
            int inputs = read.nextInt();

            if (inputs == 0) break;

            TreeHeapBstModel treeHeapBstModel = new TreeHeapBstModel();
            for (int i = 0;i < inputs;i++) {
                String input = read.next();

                String[] values = input.split("/");

                treeHeapBstModel.add(values[0].charAt(0), Integer.parseInt(values[1]));
            }

            output.append(treeHeapBstModel).append("\n");
        }

        System.out.print(output);
    }
}

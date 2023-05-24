package org.example.activity01.letterB;

import org.example.core.helpers.TreeHelper;
import org.example.core.models.TreeBstModel;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    private static final Function<String, String> formatter = (print) -> {
        String[] values = print.split(" ");

        StringBuilder valueOutput = new StringBuilder();

        for (String character : values)
            if (character.length() > 0)
                valueOutput.append((char) Integer.parseInt(character)).append(" ");

        return valueOutput.substring(0, valueOutput.length() - 1);
    };

    public static void main(String[] args)  {
        StringBuilder result = new StringBuilder();
        TreeBstModel treeBstModel = new TreeBstModel();
        Scanner read = new Scanner(System.in);

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] lineSplit = line.split(" ");

            String operation = lineSplit[0];

            switch (operation) {
                case "I":
                    char value = lineSplit[1].charAt(0);
                    treeBstModel.addNode(value);
                    break;
                case "P":
                    char search = lineSplit[1].charAt(0);

                    if (treeBstModel.searchInTree(search))
                        result.append(search).append(" existe");
                    else result.append(search).append(" nao existe");
                    result.append("\n");
                    break;
                case "INFIXA":
                    result.append(formatter.apply(TreeHelper.printInOrder(treeBstModel)))
                            .append("\n");
                    break;
                case "PREFIXA":
                    result.append(formatter.apply(TreeHelper.printPreOrder(treeBstModel)))
                            .append("\n");
                    break;
                case "POSFIXA":
                    result.append(formatter.apply(TreeHelper.printPosOrder(treeBstModel)))
                            .append("\n");
                    break;
            }
        }

        System.out.print(result);
    }
}

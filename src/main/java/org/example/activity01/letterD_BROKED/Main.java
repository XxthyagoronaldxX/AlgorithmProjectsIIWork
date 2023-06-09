package org.example.activity01.letterD_BROKED;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        while (read.hasNextLine()) {
            String text = read.nextLine();

            String[] strings = text.split("[?]");
            StringBuilder work = new StringBuilder();
            Set<String> substrings = new HashSet<>();

            for (String string : strings) {
                work.append(string);

                for (int j = 1; j <= work.length(); j++) {
                    for (int l = 0;l+j <= work.length(); l++) {
                        String value = work.substring(l, l + j);

                        substrings.add(value);
                    }
                }

                result.append(substrings.size()).append("\n");
            }
        }

        System.out.println(result);
    }
}

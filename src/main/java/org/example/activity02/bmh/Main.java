package org.example.activity02.bmh;

import java.util.*;

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        String input = read.next();

        Map<Character, Integer> charJumpMap = preProcessInput(input);

        String text = "hbadecaedcade";

        List<Integer> ocurrencePositions = searchForOcurrencePositions(charJumpMap, input, text);

        System.out.println("Ocurrences: " + ocurrencePositions.size());
        System.out.println("Positions: ");
        ocurrencePositions.forEach(System.out::println);
    }

    public static List<Integer> searchForOcurrencePositions(Map<Character, Integer> charJumpMap, String input, String text) {
        List<Integer> ocurrencePositions = new ArrayList<>();

        for (int i = 0; i + input.length() - 1 < text.length(); ) {
            String testMatch = text.substring(i, i + input.length());

            if (testMatch.equals(input)) {
                ocurrencePositions.add(i);
            }

            char character = text.charAt(i + input.length() - 1);

            if (charJumpMap.containsKey(character)) {
                i += charJumpMap.get(character);
            } else {
                i += input.length();
            }
        }

        return ocurrencePositions;
    }

    public static Map<Character, Integer> preProcessInput(String input) {
        int n = input.length();
        char[] inputChars = input.toCharArray();
        Map<Character, Integer> charJumpMap = new HashMap<>();
        charJumpMap.put(inputChars[n - 1], n);

        for (int i = 1; i <= n - 1; i++) {
            char character = inputChars[n - i - 1];

            if (!charJumpMap.containsKey(character))
                charJumpMap.put(character, i);
            else
                charJumpMap.put(character, Math.min(i, charJumpMap.get(character)));
        }

        return charJumpMap;
    }
}

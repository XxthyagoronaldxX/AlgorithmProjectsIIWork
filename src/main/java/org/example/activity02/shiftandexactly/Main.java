package org.example.activity02.shiftandexactly;

import java.util.*;

public class Main {
    public static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        String search = read.next();
        String text = "o teste testam os testes";

        List<Integer> ocurrences = execute(text, search);

        System.out.println("Matches: " + ocurrences.size());
        System.out.println("Ocurrences:");
        ocurrences.forEach(System.out::println);
    }

    public static List<Integer> execute(String text, String search) {
        List<Integer> ocurrenceIndexes = new ArrayList<>();
        int size = search.length();

        Map<Character, int[]> map = preProcess(search);

        int[] currentThread = new int[size];
        int[] constThread = new int[size];
        constThread[0] = 1;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            int[] threadOfChar = map.getOrDefault(character, null);

            if (threadOfChar == null) {
                currentThread = new int[size];
            } else {
                shift(currentThread);

                int[] orResultThread = new int[size];
                for (int j = 0; j < size; j++)
                    orResultThread[j] = currentThread[j] == 1 || constThread[j] == 1 ? 1 : 0;

                int[] andResultThread = new int[size];
                for (int j = 0; j < size; j++)
                    andResultThread[j] = orResultThread[j] == 1 && threadOfChar[j] == 1 ? 1 : 0;

                if (andResultThread[size - 1] == 1) ocurrenceIndexes.add(i - size + 1);

                currentThread = andResultThread;
            }
        }

        return ocurrenceIndexes;
    }

    public static void shift(int[] thread) {
        for (int j = thread.length - 1; j > 0; j--)
            thread[j] = thread[j - 1];
        thread[0] = 0;
    }

    public static Map<Character, int[]> preProcess(String search) {
        Map<Character, int[]> map = new HashMap<>();
        int size = search.length();

        for (int i = 0; i < size; i++) {
            char value = search.charAt(i);

            int[] thread = map.getOrDefault(value, new int[size]);

            thread[i] = 1;

            map.put(value, thread);
        }

        return map;
    }
}

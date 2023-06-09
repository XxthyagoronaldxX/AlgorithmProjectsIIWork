package org.example.activity01.letterE;

import java.util.*;

class Child {
    public int red;
    public int black;
}

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int grandchildren = read.nextInt();

        Map<Child, Integer> same = new HashMap<>();
        List<Child> children = new ArrayList<>();
        int ranks = 0;

        for (int i = 0;i < grandchildren;i++) {
            Child child = new Child();
            child.red = read.nextInt();
            child.black = read.nextInt();

            if (children.contains(child)) {
                Integer same_amount = same.get(child);

                if (same_amount == null) same.put(child, 2);
                else same.put(child, same_amount + 1);
            } else {
                children.add(child);
            }
        }



        for (int value : same.values()) ranks += value * value - value;

        System.out.println(ranks);
    }
}

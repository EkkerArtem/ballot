package com.javaclasses.ballot;

import org.junit.jupiter.api.Test;

import java.util.Random;


public class VoterImplTest {
    @Test
    void timeChecker() {
        BSTimpl BSTimpl = new BSTimpl();
        int biggest = 0;
        int secondbiggest = 0;
        int votesLeft = 1_000_000;
        long time = System.nanoTime();
        Random random = new Random();
        if (biggest - secondbiggest < votesLeft) {
            for (int i = 1; i < 1_000_000; i++) {
                int a = random.nextInt();
                if (BSTimpl.search(a) != null) {
                    BSTimpl.increment(BSTimpl.search(a));
                    int value = BSTimpl.getValue(BSTimpl.search(a));
                    if (biggest < value) {
                        biggest = value;
                    } else if (secondbiggest < value) {
                        secondbiggest = value;
                    }
                } else BSTimpl.insert(a, 1);
                votesLeft--;
            }
        }
        System.out.println("Your code run in " + (System.nanoTime() - time) / 1e+9 + " seconds");
    }
}
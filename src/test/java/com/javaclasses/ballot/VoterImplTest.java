package com.javaclasses.ballot;

import org.junit.jupiter.api.Test;

import java.util.Random;


public class VoterImplTest {
    @Test
    void timeChecker() {
        BST bst = new BST();
        int biggest = 0;
        int secondbiggest = 0;
        int votesLeft = 1_000_000;
        long time = System.nanoTime();
        Random random = new Random();
        if (biggest - secondbiggest < votesLeft) {
            for (int i = 1; i < 1_000_000; i++) {
                int a = random.nextInt();
                if (bst.search(a) != null) {
                    bst.increment(bst.search(a));
                    int value = bst.getValue(bst.search(a));
                    if (biggest < value) {
                        biggest = value;
                    } else if (secondbiggest < value) {
                        secondbiggest = value;
                    }
                } else bst.insert(a, 1);
                votesLeft--;
            }
        }
        System.out.println("Your code run in " + (System.nanoTime() - time) / 1e+9 + " seconds");
    }
}
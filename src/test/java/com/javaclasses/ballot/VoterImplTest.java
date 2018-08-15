package com.javaclasses.ballot;

import com.javaclasses.ballot.impl.VoterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;


public class VoterImplTest {

    @Test
    void thirdCandidateWin() {
        int electorate = 10_000;
        VoterImpl voter = new VoterImpl();
        Random random = new Random(42);

        for (int i = 0; i < electorate / 3; i++) {
            int randomId = random.nextInt(3);
            voter.vote(randomId);
        }

        for (int i = electorate / 3; i < electorate * 2 / 3; i++) {
            int randomId = random.nextInt(3) + 1;
            voter.vote(randomId);
        }
        for (int i = electorate * 2 / 3; i < electorate; i++) {
            int randomId = random.nextInt(3) + 2;
            voter.vote(randomId);
        }
        Assertions.assertTrue(voter.getVotes(2) > voter.getVotes(1) && voter.getVotes(2) > voter.getVotes(3));
    }

    @Test
    void timeChecker() {
        VoterImpl voter = new VoterImpl();
        int biggest = 0;
        int secondbiggest = 0;
        int votesLeft = 1_000;
        long time = System.nanoTime();
        Random random = new Random();
        if (biggest - secondbiggest < votesLeft) {
            for (int i = 1; i < 1_000; i++) {
                int randomId = random.nextInt();
                voter.vote(randomId);
                voter.getVotes(randomId);
                if (randomId > biggest) {
                    biggest = randomId;
                }
                if (randomId > secondbiggest && randomId < biggest) {
                    secondbiggest = randomId;
                }
                votesLeft--;
            }
        }
        System.out.println("Your code run in " + (System.nanoTime() - time) / 1e+9 + " seconds");
    }

    @Test
    void worstCaseTest() {
        int electorate = 2_000;
        long time = System.nanoTime();
        Random random;
        VoterImpl voter = new VoterImpl();

        for (int j = 0; j < 1; j++) {
            random = new Random(42);
            for (int i = 1; i < electorate; i++) {
                int randomId = random.nextInt(1_000_000);
                voter.vote(randomId);
            }
        }

        System.out.println("Your code run in " + (System.nanoTime() - time) / 1e+9 + " ms, number of tries: " + 2000);
    }

}
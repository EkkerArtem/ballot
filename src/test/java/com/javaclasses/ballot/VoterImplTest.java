package com.javaclasses.ballot;

import com.javaclasses.ballot.impl.VoterImpl;
import com.javaclasses.ballot.impl.Voting;
import org.junit.jupiter.api.Test;

import java.util.Random;


public class VoterImplTest {
    Voter voter;


    @Test
    void firstCandidateWin() {
        Voting voting = VoterImpl.getVoting();
        voting.setVotersLeft(1000);
        voter = new VoterImpl();
        for (int i = 1; i < voting.getVotersLeft() / 2 + 5; i++) {

            voter.vote(0);
        }
    }

    @Test
    void thirdCandidateWin() {
        Voting voting = VoterImpl.getVoting();
        voting.setVotersLeft(100_000);
        voter = new VoterImpl();
        Random random = new Random();

        for (int i = 0; i < voting.getVotersLeft() / 3; i++)
            voter.vote(random.nextInt((3 - 0) + 1) + 0);

        for (int i = voting.getVotersLeft() / 3; i < voting.getVotersLeft() * 2 / 3; i++)
            voter.vote(random.nextInt((4 - 1) + 1) + 1);

        for (int i = voting.getVotersLeft() * 2 / 3; i < voting.getVotersLeft(); i++)
            voter.vote(random.nextInt((5 - 2) + 1) + 2);
    }

    @Test
    void newLeaderAppearsInMiddle() {
        Voting voting = VoterImpl.getVoting();
        voting.setVotersLeft(10_000);
        voter = new VoterImpl();
        Random random = new Random();

        for (int i = 1; i < voting.getVotersLeft() / 2; i++) {
            voter.vote(random.nextInt(500));
        }
        for (int i = voting.getVotersLeft() / 2; i < voting.getVotersLeft(); i++) {
            voter.vote(500);
        }
    }

    @Test
    void timeCheckerForLongElections() {
        Voting voting = VoterImpl.getVoting();
        voting.setVotersLeft(1_000_000);
        voter = new VoterImpl();
        long time = System.nanoTime();
        Random random = new Random();
        for (int i = 1; i < voting.getVotersLeft(); i++) {
            if (i < voting.getVotersLeft() * 0.6) {
                if ((i % 10 == 0)) voter.vote(10);
                else voter.vote(random.nextInt(100));
            } else voter.vote(10);
        }
        System.out.println("Your code run in " + (System.nanoTime() - time) / 1e+9 + " seconds");
    }

}
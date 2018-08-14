package com.javaclasses.ballot.impl;

import com.javaclasses.ballot.Voter;
import com.javaclasses.ballot.ballotbox.BallotBox;

public class VoterImpl implements Voter {

    public static Voting getVoting() {
        return voting;
    }

    private static Voting voting = new Voting();
    private final BallotBox ballotBox = new BallotBox();


    @Override
    public void vote(int id) {
        int votes = voting.getVotersLeft();
        int votesrLeft = votes - 1;
        voting.setVotersLeft(votesrLeft);
        boolean check = votes/2 >= votesrLeft;
        int a = voting.getFirstLargest();
        int b = voting.getSecondLargest();

        if (voting.check() || check) {

            ballotBox.addCandidate(id);
            ballotBox.addVote(id);

            if (check) {
                if (a == 0 || ballotBox.getBallotbox().get(id) > a || ballotBox.getBallotbox().get(id) > b) {
                    voting.getLeaders();
                }
            }

        } else throw new IllegalStateException("Voting ended");
    }
}

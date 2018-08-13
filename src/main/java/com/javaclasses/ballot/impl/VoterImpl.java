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

        if (voting.check()) {

            int a = voting.getFirstLargest();
            int b = voting.getSecondLargest();

            ballotBox.addCandidate(id);
            ballotBox.addVote(id);

            if (votes/2 >= voting.getVotersLeft()) {
                if (a == 0 || ballotBox.getBallotbox().get(id) > a || ballotBox.getBallotbox().get(id) > b) {
                    voting.getLeaders();
                }
            }
            int votesrLeft = votes - 1;
            voting.setVotersLeft(votesrLeft);
        } else throw new IllegalStateException("Voting ended");

    }
}

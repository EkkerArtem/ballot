package com.javaclasses.ballot.impl;

import com.javaclasses.ballot.Voter;
import com.javaclasses.ballot.ballotbox.BallotBox;

public class VoterImpl implements Voter {

    public VoterImpl(int amountOfVoters) {
        ballotBox = new BallotBox(amountOfVoters);
    }

    private  Voting voting;
    private final BallotBox ballotBox;


    @Override
    public void vote(int id) {
        voting  = new Voting(ballotBox);
        if (voting.check() == true) {

            int a = voting.getFirstLargest();
            int b = voting.getSecondLargest();

            ballotBox.addVote(id);

            if (a == 0 || ballotBox.getBallotbox()[id] > a || ballotBox.getBallotbox()[id] > b) {
                voting.getLeaders();
            }
        } else throw new IllegalStateException("Voting ended");

    }
}

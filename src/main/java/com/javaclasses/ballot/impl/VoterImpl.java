package com.javaclasses.ballot.impl;

import com.javaclasses.ballot.Voter;

public class VoterImpl implements Voter {

    public static Voting getVoting() {
        return voting;
    }

    private static Voting voting = new Voting();


    @Override
    public void vote(int id) {
        if (voting.check() == true) {

            voting.getBallotBox().addCandidate(id);
            voting.getBallotBox().addVote(id);
            voting.getLeaders();

            int votesrLeft = voting.getVotersLeft() - 1;
            voting.setVotersLeft(votesrLeft);
        } else System.exit(0);

    }
}

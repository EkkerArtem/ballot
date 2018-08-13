package com.javaclasses.ballot;

import com.javaclasses.ballot.ballotbox.BallotBox;

public class VoterImpl implements Voter {

    private final BallotBox ballotBox = new BallotBox();
    private Voting voting = new Voting();

    @Override
    public void vote(int id) {
        ballotBox.addCandidate(id);
        ballotBox.addVote(id);
        voting.getLeaders();
        voting.check();
        int votesrLeft = voting.getVotersLeft() - 1;
        voting.setVotersLeft(votesrLeft);
    }
}

package com.javaclasses.ballot.ballotbox;


public class BallotBox {

    private int[] ballotbox;

    private final int amountOfVoters;

    public BallotBox(int amountOfVoters) {
        this.amountOfVoters = amountOfVoters;
        ballotbox = new int[amountOfVoters];
    }

    public int[] getBallotbox() {
        return ballotbox;
    }

    /**
     * Method for incrementing count of votes for candidate.
     *
     * @param id id of candidate that is voted for.
     */
    public void addVote(int id) {
        ballotbox[id] = ballotbox[id] + 1;
    }
}


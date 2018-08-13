package com.javaclasses.ballot.ballotbox;

import java.util.HashMap;

public class BallotBox {

    private final HashMap<Integer, Integer> ballotbox = new HashMap();

    public HashMap<Integer, Integer> getBallotbox() {
        return ballotbox;
    }

    /**
     * Method for adding a new id of candidate if it is first vote for him.
     *
     * @param id id of candidate that is voted for.
     */
    public void addCandidate(int id) {
        if (!ballotbox.containsKey(id)) {
            ballotbox.put(id, 0);
        }
    }

    /**
     * Method for incrementing count of votes for candidate.
     *
     * @param id id of candidate that is voted for.
     */
    public void addVote(int id) {
        if (ballotbox.containsKey(id)) {
            ballotbox.replace(id, ballotbox.get(id) + 1);
        }
    }

}

package com.javaclasses.ballot.ballotbox;

import java.util.HashMap;

public class BallotBox {

    private final HashMap<Integer , Integer> ballotbox  = new HashMap();

    public HashMap<Integer, Integer> getBallotbox() {
        return ballotbox;
    }

    public void addCandidate(int id){
        if (!ballotbox.containsKey(id) && id<1000000){
            ballotbox.put(id,1);
        }
    }

    public void addVote(int id){
        if (ballotbox.containsKey(id)){
            ballotbox.replace(id,ballotbox.get(id)+1);
        }
    }

}

package com.javaclasses.ballot.impl;

import com.javaclasses.ballot.ballotbox.BallotBox;

import java.util.Collection;
import java.util.Collections;

public class Voting {

    private int VOTERS_LEFT;
    private final BallotBox ballotBox = new BallotBox();
    private int firstLargest;
    private int secondLargest;

    public int getVotersLeft() {
        return VOTERS_LEFT;
    }

    public void setVotersLeft(int votersLeft) {
        VOTERS_LEFT = votersLeft;
    }

    public BallotBox getBallotBox() {
        return ballotBox;
    }

    public int[] getLeaders() {
        for (int value : ballotBox.getBallotbox().values()) {
            if (value > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = value;
            } else if (value > secondLargest) {
                secondLargest = value;
            }
        }
        return new int[]{firstLargest, secondLargest};
    }

    public int getFirstLargest() {
        return firstLargest;
    }

    public int getMax(){
        Collection collection = ballotBox.getBallotbox().values();
        Comparable coll = Collections.max(collection);
        int max = (int) coll;
        return max;
    }

    public boolean check() {
        if (!(firstLargest - secondLargest > VOTERS_LEFT) && VOTERS_LEFT >= 0) {
            return true;

        } else System.out.println("У нас есть победитель, который наюбрал " + firstLargest + " голосов!");
        return false;
    }
}

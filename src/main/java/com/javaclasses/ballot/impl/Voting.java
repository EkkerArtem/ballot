package com.javaclasses.ballot.impl;

import com.javaclasses.ballot.ballotbox.BallotBox;

public class Voting {

    /**
     * Count of voters left to vote.
     */
    private int votersLeft;
    private final BallotBox ballotBox = new BallotBox();
    /**
     * Candidate with biggest amount of votes.
     */
    private int firstLargest;
    /**
     * Candidate with second biggest amount of votes.
     */
    private int secondLargest;

    public int getVotersLeft() {
        return votersLeft;
    }

    public void setVotersLeft(int votersLeft) {
        this.votersLeft = votersLeft;
    }

    /**
     * Method for getting two candidates with biggest amounts of votes.
     *
     * @return two candidates with biggest amounts of votes.
     */
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

    public int getSecondLargest() {
        return secondLargest;
    }

    /**
     * Method for checking if there is still need to continue voting.
     *
     * @return true if there is still need to continue voting. And false if there is no need to continue voting.
     */
    public boolean check() {
        if (!(firstLargest - secondLargest > votersLeft) && votersLeft >= 1) {
            return true;

        } else System.out.println("У нас есть победитель, который наюбрал " + firstLargest + " голосов!");
        return false;
    }
}

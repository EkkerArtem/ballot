package com.javaclasses.ballot;


import com.javaclasses.ballot.ballotbox.BallotBox;

import java.util.HashMap;

public class Voting {
    public int getVotersLeft() {
        return VOTERS_LEFT;
    }

    public void setVotersLeft(int votersLeft) {
        VOTERS_LEFT = votersLeft;
    }

    private static int VOTERS_LEFT = 1000000;

    BallotBox ballotBox = new BallotBox();
    HashMap<Integer, Integer> map = ballotBox.getBallotbox();
    private int firstLargest;
    private int secondLargest;

    public int[] getLeaders(){
        for (int value : this.map.values()) {
            if (value > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = value;
            } else if (value > secondLargest) {
                secondLargest = value;
            }
        }
        return new int[] {firstLargest, secondLargest};
    }

    public void check(){
        if (firstLargest - secondLargest >  VOTERS_LEFT){
            System.out.println("У нас есть победитель, который наюбрал " + firstLargest + " голосов!");
        }
    }
}

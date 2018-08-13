package com.javaclasses.ballot;

/**
 * Main class for voting. It takes id of candidate and if it already exists it will do incrementation of votes count,
 * if candidate is new, it will create id for this candidate.
 */
public interface Voter {
    /**
     * The main method. It takes id of candidate and if it already exists it will do incrementation of votes count,
     * if candidate is new, it will create id for this candidate. Also it does check if we've already got the winner or not.
     * @param id id of candidate that we want to vote for.
     */
    void vote(int id);
}

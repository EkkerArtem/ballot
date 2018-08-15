package com.javaclasses.ballot;

/**
 * Interface for voting. It is needed to insert id of candidate that you want to vote for.
 * If candidate with this id already exists it will increment his votes count,
 * if there is no candidate with inserted id - it will create him.
 */
public interface Voter {
    /**
     * Main method for voting. If candidate with this id already exists it will increment his votes count,
     *  if there is no candidate with inserted id - it will create him.
     * @param id id of candidate that is wanted to vote for.
     */
    void vote(int id);
}

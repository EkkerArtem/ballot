package com.javaclasses.ballot.impl;

import com.javaclasses.ballot.Voter;

public class VoterImpl implements Voter {
    BTree tree = new BTree();

    @Override
    public void vote(int id) {
        if (tree.search(id) == null) {
            tree.insert(id, 1);
            tree.simpleBalance();
        } else tree.increment(tree.search(id));
    }

    /**
     * @param id id of the candidate.
     * @return current of votes for his id.
     */
    public int getVotes(int id) {
        int votes = tree.getVotes(tree.search(id));
        return votes;
    }
}

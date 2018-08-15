package com.javaclasses.ballot;

public class VoterImpl implements Voter {
    BTree tree = new BTree();

    @Override
    public void vote(int id) {
        if (tree.search(id) == null) {
            tree.insert(id, 1);
            tree.simpleBalance();
        } else tree.increment(tree.search(id));
    }

    public int getVotes(int id) {
        int votes = tree.getVotes(tree.search(id));
        return votes;
    }
}

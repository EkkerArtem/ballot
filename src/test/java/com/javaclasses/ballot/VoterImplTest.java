package com.javaclasses.ballot;

import org.junit.jupiter.api.Test;

class VoterImplTest {
    VoterImpl voter = new VoterImpl();
    @Test

    void vote() {
        for (int i=0; i<10000000; i++){
           voter.vote((int) Math.abs( Math.random()*1000));
        }
    }
}
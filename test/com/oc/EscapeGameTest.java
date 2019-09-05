package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscapeGameTest {
    @Test
    public void Give_mauvaisMode_When_startGame_Then_ThrowsException(){
        assertThrows(MauvaisModeGameException.class, ()-> new EscapeGame(6));
    }
}
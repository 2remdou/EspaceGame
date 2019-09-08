package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscapeGameTest {
    @Test
    public void Give_mauvaisMode_When_startGame_Then_ThrowsException(){
        assertThrows(MauvaisModeGameException.class, ()-> new EscapeGame(6,4,4,false));
    }
    @Test
    public void Give_combinaison_When_modeChallenger_Then_aiEstFalse(){
//        EscapeGame escapeGame = new EscapeGame();

    }
}
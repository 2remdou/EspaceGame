package com.oc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UtilitaireTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }
    @Test
    public void Given_mauvaiseValeur_When_appelleGetIntInput_Then_afficheError(){
        System.setIn(new ByteArrayInputStream("15\n2\n".getBytes()));
        int valeur = Utilitaire.getIntInput(1,3);
        String[] output = outContent.toString().replace("\r\n","\n").split("\n");
        assertEquals("Veuillez recommencez, la saisie est incorrecte",output[0]);
        assertEquals(2,valeur);
    }
    @Test
    public void Given_mode_When_appellePoserQuestion_Then_afficheTextCorrect(){
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        String[] modes = {"Challenger","Défense","Duel"};
        Utilitaire.poserQuestion(modes,"Veuillez choisir un mode");
        String [] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Veuillez choisir un mode",output[0]);
        assertEquals("1 - Challenger",output[1]);
        assertEquals("2 - Défense",output[2]);
        assertEquals("3 - Duel",output[3]);
        assertEquals("Veuillez choisir :",output[4]);
    }
    @Test
    public void Given_mauvaisChoix_When_appellePoserQuestion_Then_appelleEncorePoserQuestion(){
        System.setIn(new ByteArrayInputStream("4\n2\n".getBytes()));
        String[] modes = {"Challenger","Défense","Duel"};
        int mode = Utilitaire.poserQuestion(modes,"Veuillez choisir un mode");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Veuillez recommencez, la saisie est incorrecte",output[5]);
        assertEquals(2,mode);
    }

    @Test
    public void Given_4Chiffres_When_generationCombinaire_Then_bonChiffre(){
        int nb = Utilitaire.generationCombinaison(4);
        assertTrue(nb>=1111 && nb<=9999);
    }

}
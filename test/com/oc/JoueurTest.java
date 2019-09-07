package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {


    @Test
    public void Given_reponse_When_faireProposition_Then_bonneProposition(){
        Joueur joueur = new Joueur();
        int ancienneProposition = 4526;
        joueur.getProposition().add(ancienneProposition);
        int propostion = joueur.faireProposition(4,"+--=");
        assertTrue(Utilitaire.getChiffreWithIndex(propostion,0)>Utilitaire.getChiffreWithIndex(ancienneProposition,0));
        assertTrue(Utilitaire.getChiffreWithIndex(propostion,1)<Utilitaire.getChiffreWithIndex(ancienneProposition,1));
        assertTrue(Utilitaire.getChiffreWithIndex(propostion,2)<Utilitaire.getChiffreWithIndex(ancienneProposition,2));
        assertTrue(Utilitaire.getChiffreWithIndex(propostion,3)==Utilitaire.getChiffreWithIndex(ancienneProposition,3));
    }
}
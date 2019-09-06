package com.oc;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Utilitaire {
    static Scanner sc = new Scanner(System.in);

    /**
     * Afficher une liste de choix
     * @param choix la liste des choix
     * @param message le message à afficher
     * @return le choix
     */
    public static int poserQuestion(String[] choix,String message){

        String texte = "";
        System.out.println(message);
        for(int i=0;i<=choix.length-1;i++){
            System.out.println((i+1)+" - "+ choix[i]);
        }
        System.out.println("Veuillez choisir :");
        return getIntInput(1,choix.length);
    }

    /**
     *
     * @param min la valeur minimale
     * @param max la valeur maximal
     * @return la saisie
     */
    public static int getIntInput(int min,int max){
        int input = -1;
        boolean isNotValid = false;
        do {
            try {
                if (!sc.hasNext()){sc = new Scanner(System.in);}
                input = sc.nextInt();
                isNotValid = (input<min || input>max);
            }catch (InputMismatchException e){
                isNotValid = true;
                sc.next();
            }
            if(isNotValid) {
                System.out.println("Veuillez recommencez, la saisie est incorrecte");
            }
        }while (isNotValid);
        return input;
    }

    /**
     *
     * @param nbreChiffres
     * @return [min,max]
     */
    public static int [] getBorne(int nbreChiffres){
        String min = "1";
        String max = "9";
        for(int i=2;i<=nbreChiffres;i++) {
            min +="0";
            max +="9";
        }
        int [] borne = {Integer.parseInt(min),Integer.parseInt(max)};
        return borne;
    }

    /**
     *
     * @param nbreChiffres nombre de chiffres de la combinaison
     * @return la combinaison
     */
    public static int generationCombinaison(int nbreChiffres){

        Random random = new Random();
        int[] borne = getBorne(nbreChiffres);
        int min =  borne[0];
        int max = borne[1];
        int nb = min+random.nextInt(max-min);
            return  nb;
    }

    /**
     *
     * @param nbreChiffres nombre de chiffres de la combinaison
     * @return la combinaison du joueur
     */
    public static int getCombinaison(int nbreChiffres){
        System.out.println("Donner une combinaison de ?? chiffres");
        int[] borne = getBorne(nbreChiffres);
        int combinaison = getIntInput(borne[0],borne[1]);
        return combinaison;
    }
}
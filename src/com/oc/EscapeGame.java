package com.oc;

public class EscapeGame {
    private int mode;
    private int nbreChiffres;
    private int min;
    private int max;
    /**
     *
     * @param mode le mode [1- Challenger,2- Défense, 3- Duel]
     */
    public EscapeGame(int mode,int nbreChiffres){
        if(mode<1 || mode>3) throw new MauvaisModeGameException();
        this.mode = mode;
        this.nbreChiffres = nbreChiffres;
        int [] borne = Utilitaire.getBorne(nbreChiffres);
        this.min = borne[0];
        this.max = borne[1];
    }

    public int getMode() {
        return mode;
    }

    private int propositionHumaine(Joueur attaquant,Joueur defenseur){
        System.out.print("Propostion : ");
        int proposition = Utilitaire.getIntInput(this.min,this.max);
        attaquant.getProposition().add(proposition);
        return  proposition;
    }

    private int propositionIA(Joueur attaquant,Joueur defenseur,String reponsePrecedente){
        int propostion = attaquant.faireProposition(this.nbreChiffres,reponsePrecedente);
        attaquant.getProposition().add(propostion);
        return propostion;
    }

    public void startModeChallenger(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        int proposition;
        Joueur defenseur = new Joueur(combinaison);
        Joueur attaquant = new Joueur();
        do{
            proposition = propositionHumaine(attaquant,defenseur);
            String res = defenseur.recevoirPropostion(proposition);
            System.out.println("Réponse : "+res);
        }while (combinaison!=proposition);
    }

    public void startModeDefense(){
        System.out.println("Donner une combinaison de "+ this.nbreChiffres +" chiffres");
        int combinaison = Utilitaire.getIntInput(this.min,this.max);
        int proposition;
        Joueur defenseur = new Joueur(combinaison);
        Joueur attaquant = new Joueur();
        String reponse=null;
        int i = 1;
        do{
            proposition = this.propositionIA(attaquant,defenseur,reponse);
            reponse = defenseur.recevoirPropostion(proposition);
            System.out.println(i++ +" - "+"Propostion "+proposition+" -> Réponse : "+reponse);
        }while (combinaison!=proposition);
    }
    public void startModeDuel(){
        System.out.println("Donner une combinaison de "+ this.nbreChiffres +" chiffres");
        int combinaison = Utilitaire.getIntInput(this.min,this.max);
        Joueur humain = new Joueur(combinaison);
        combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        Joueur ia = new Joueur(combinaison);
        boolean winHumain = false;
        int proposition;
        String reponseHumaine=null;
        String reponseIA=null;
        while (true){
            proposition = this.propositionHumaine(humain,ia);
            reponseIA = ia.recevoirPropostion(proposition);
            System.out.println("Réponse : "+reponseIA);
            if(proposition==ia.getCombinaison()){
                winHumain = true;
                break;
            }
            proposition = this.propositionIA(ia,humain,reponseHumaine);
            reponseHumaine = humain.recevoirPropostion(proposition);
            System.out.println("Propostion "+proposition+" -> Réponse : "+reponseHumaine);
            if(proposition == humain.getCombinaison()){
                winHumain = false;
                break;
            }
        }
        if(winHumain) System.out.println("Bravo vous avez gagné");
        else System.out.println("Désolé, vous avez perdu");

    }

    public void start(){
        Joueur defenseur;
        Joueur attaquant;
        switch (this.mode){
            case 1:
                this.startModeChallenger();
                break;
            case 2:
                this.startModeDefense();
                break;
            case 3:
                this.startModeDuel();
                break;
        }

    }

    public Joueur creationJoueurHumain(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        Joueur joueur = new Joueur(combinaison);
        return joueur;
    }

    public Joueur creationJoueurIA(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        return  new Joueur(combinaison);
    }
}

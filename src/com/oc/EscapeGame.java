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
        this.nbreChiffres = nbreChiffres;
        int [] borne = Utilitaire.getBorne(nbreChiffres);
        this.min = borne[0];
        this.max = borne[1];
    }

    public int getMode() {
        return mode;
    }


    public void startChallenger(){
        int combinaison = Utilitaire.generationCombinaison(this.nbreChiffres);
        int proposition;
        Joueur defenseur = new Joueur(combinaison);
        Joueur attaquant = new Joueur();
        do{
            System.out.print("Propostion : ");
            proposition = Utilitaire.getIntInput(this.min,this.max);
            attaquant.setProposition(proposition);
        }while (defenseur.getCombinaison()!=attaquant.getProposition());
    }

    public void start(){
        System.out.printf("mode="+this.mode);
        Joueur defenseur;
        Joueur attaquant;
        switch (this.mode){
            case 1:
                this.startChallenger();
                break;
            case 2:
                defenseur = this.creationJoueurHumain();
                attaquant = this.creationJoueurIA();
                break;
            case 3:
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

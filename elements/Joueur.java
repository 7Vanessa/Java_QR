package elements;

import java.util.HashMap;
import java.util.Map;

public class Joueur {

    private static int compteur = 100;
    private final String nom;
    private final int numero;
    private int score = 0;
    private final Map<String, String> etats;
    private String etat;
    // compteur pour le nom
    private static int compteurNom = 1;

    public Joueur() {
        this.numero = compteur;
        compteur = compteur + 10;
        nom = "" + (char)('A' + compteurNom);
        compteurNom++;
        etats = new HashMap<>();
        etats.put("s", "Sélectionné");
        etats.put("g", "Gagnant");
        etats.put("sg", "Super Gagnant");
        etats.put("e", "Eliminé");
        etats.put("a", "En attente");
        etat = etats.get("a");
    }

    public int getScore() {
        return score;
    }

    public void updateScore(String nomPhase) {
        switch (nomPhase) {
            case "PhaseI" -> score += 2;
            case "PhaseII" -> score += 3;
            case "PhaseIII" -> score += 5;
        }
    }

    public void updateEtat(String etat) {
        this.etat = etats.get(etat);
    }

    public String getEtat() {
        return etat;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Joueur " + nom + "  n°" + numero + "  Score : " + score + "  Etat : " + etat;
    }
}

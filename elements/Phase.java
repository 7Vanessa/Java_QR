package elements;

public interface Phase {
    public Joueurs selectJoueurs();
    public Joueur[] playPhase();
    public String getNomPhase();
}

package elements;

public class PhaseII implements Phase {

    private final String NOMPHASE = "PhaseII";
    private Joueurs joueursPhaseII;
    private Themes themes;

    public PhaseII(Themes themes) {
        this.themes = themes;
    }

    @Override
    public Joueurs selectJoueurs() {
        return null;
    }

    @Override
    public Joueur[] playPhase() {
        return new Joueur[0];
    }

    @Override
    public String getNomPhase() {
        return NOMPHASE;
    }

    public Joueurs getJoueursPhaseII() {
        return joueursPhaseII;
    }
}

package elements;

public class Theme {

    private final String nom;
    private Questions questions;

    public Theme(String nom) {
        this.nom = nom;
        questions = new Questions();
    }

    // Getters
    public String getTheme() {
        return nom;
    }

    public Questions getQuestions() {
        return questions;
    }

    public String getNom() {
        return nom;
    }

    // Setters
    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return nom;
    }
}

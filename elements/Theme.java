package elements;

public class Theme {

    private final String nom;
    private Questions questions;

    public Theme(String nom) {
        this.nom = nom;
        questions = new Questions();
    }

    public String getTheme() {
        return nom;
    }

    public Questions getQuestions() {
        return questions;
    }

    public String getNom() {
        return nom;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public String toString() {
        String str = "Thème : " + nom + '\n';
        for(Question question : questions) {
            str += question.toString() + '\n';
        }
        return str;
    }
}

public class Eleve implements Runnable {
    private final String nom;
    private final Cours cours;

    public Eleve(String nom, Cours cours) {
        this.nom = nom;
        this.cours = cours;
    }

    public void printNote() {
        new Thread(this).start();
    }

    public void run(){
        System.out.println(nom +": " + cours.getNote(nom));
    }
}

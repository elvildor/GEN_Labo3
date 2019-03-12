import java.util.HashMap;

public class Cours {

    private HashMap<String,Integer> notes;
    private boolean available;

    public static void main(String[] args) throws InterruptedException {
        Cours cours = new Cours();
        Eleve jean = new Eleve("Jean",cours);
        Eleve sophie = new Eleve("Sophie",cours);
        jean.printNote();
        cours.setNote("Sophie",5);
        sophie.printNote();
        cours.setNote("Jean",4);
        Thread.sleep(1000);
        cours.makeAvalaible();
    }

    public Cours() {
        this.notes = new HashMap<String, Integer>();
        available = false;
    }
    public int getNote(String nom) {
        synchronized (this) {
            while (!available) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return notes.get(nom);
    }

    public void makeAvalaible() {
        synchronized (this) {
            available = true;
            this.notifyAll();
        }
    }

    public void setNote(String nom, int note) {
        notes.put(nom,note);
    }



}

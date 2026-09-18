package ehajredini;

import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private final Random random;

    public GewinnModel(){
        this.gesamtPunkte = 30;
        this.random = new Random();
    }

    public int getGesamtPunkte(){
        return this.gesamtPunkte;
    }
    public int getComputerZahl(){
        return this.computerZahl;
    }
    public int getRundenErgebnis(){
        return this.rundenErgebnis;
    }

}

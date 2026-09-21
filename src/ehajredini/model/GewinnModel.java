package ehajredini.model;

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
    public void berechneComputerZahl(){
        this.computerZahl = random.nextInt(9) + 1;
    }

    public void berechneRunde(int spielerZahl){
        this.spielerZahl = spielerZahl;
        if(this.computerZahl == this.spielerZahl){
            this.rundenErgebnis = 20;
        }
        else if (this.spielerZahl == this.computerZahl + 1 || this.spielerZahl == this.computerZahl - 1){
            this.rundenErgebnis = 5;
        }
        else{
            this.rundenErgebnis = -10;
        }
        this.gesamtPunkte += rundenErgebnis;
    }

    public boolean hatGewonnen(){
        return this.gesamtPunkte >= 100;
    }

    public boolean hatVerloren(){
        return this.gesamtPunkte <= 0;
    }



}

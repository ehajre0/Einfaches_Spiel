package ehajredini.model;

import java.util.Random;
/**
 * Das Model des Zahlen-Gewinnspiels.
 * Verwaltet den Punktestand und die Spiellogik (Zufallszahlen, Rundenberechnung).
 *
 * @author Erdi Hajredini
 * @version 09/26/2026
 */

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private final Random random;

    /**
     * Erstellt ein neues GewinnModel. Der Startpunktestand beträgt standardmäßig 30 Punkte.
     */
    public GewinnModel(){
        this.gesamtPunkte = 30;
        this.random = new Random();
    }

    /**
     * Gibt den aktuellen Gesamtpunktestand zurück.
     * @return Gesamtpunktestand
     */
    public int getGesamtPunkte(){
        return this.gesamtPunkte;
    }

    /**
     * Gibt die zuletzt vom Computer ermittelte Zufallszahl zurück.
     * @return Computerzahl (1-9)
     */
    public int getComputerZahl(){
        return this.computerZahl;
    }

    /**
     * Gibt das Rundenergebnis der letzten Runde zurück (+20, +5 oder -10).
     * @return Rundenergebnis
     */
    public int getRundenErgebnis(){
        return this.rundenErgebnis;
    }

    /**
     * Berechnet eine zufällige Zahl von 1 bis 9 für den Computer
     * und speichert sie im Attribut computerZahl.
     */
    public void berechneComputerZahl(){
        this.computerZahl = random.nextInt(9) + 1;
    }

    /**
     * Führt eine Spielrunde aus:
     * Berechnet die Zufallszahl des Computers
     * Gleiche Zahl: +20 Punkte
     * 1 daneben: +5 Punkte
     * Sonst: -10 Punkte
     * Aktualisiert den Gesamtpunktestand
     *
     * @param spielerZahl Die Spieler getippte Zahl (1-9)
     */
    public void berechneRunde(int spielerZahl){
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();

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

    /**
     * Prüft, ob das Spiel gewonnen wurde mindestens 100 Punkte erreicht.
     * @return true, wenn gesamtPunkte >= 100
     */
    public boolean hatGewonnen(){
        return this.gesamtPunkte >= 100;
    }

    /**
     * Prüft, ob das Spiel verloren wurde 0 oder weniger Punkte.
     * @return true, wenn gesamtPunkte <= 0
     */
    public boolean hatVerloren(){
        return this.gesamtPunkte <= 0;
    }
}

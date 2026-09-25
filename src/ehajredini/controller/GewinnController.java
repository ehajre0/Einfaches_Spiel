package ehajredini.controller;


import ehajredini.model.GewinnModel;
import ehajredini.view.GewinnView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * Der Controller des Zahlen-Gewinnspiels.
 * Reagiert auf Benutzereingaben in der View, aktualisiert das Model und passt die GUI an.
 *
 * @author Erdi Hajredini
 * @version 09/26/2026
 */
public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    /**
     * Erstellt einen neuen Controller und verdrahtet Model und View.
     * @param model Das Daten und Logikmodell
     * @param view Die Benutzeroberfläche
     */
    public GewinnController(GewinnModel model, GewinnView view){
        this.model = model;
        this.view = view;
        addListeners();
    }

    /**
     * Registriert die ActionListener Textfeld und Reset-Button.
     */
    private void addListeners(){
        view.getSpielerZahlField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spielzugAusfuehren();
            }
        });

        view.getResetBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetRunde();
            }
        });
        view.getResetBtn().setEnabled(false);
    }

    /**
     * Liest die Benutzereingabe aus validiert die Zahl (1-9) führt eine Spielrunde aus
     * und aktualisiert Werte, Label-Farben sowie Sperren der GUI.
     */
    private void spielzugAusfuehren(){
        String eingabe = view.getSpielerZahlField().getText().trim();
        int zahl;
        try{
            zahl = Integer.parseInt(eingabe);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(view, "Bitte eine Zahl von 1 bis 9 eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(zahl < 1 || zahl > 9){
            JOptionPane.showMessageDialog(view, "Die Zahl muss zwischen 1 und 9 liegen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        model.berechneRunde(zahl);

        view.getComputerZahlField().setText(String.valueOf(model.getComputerZahl()));
        int ergebnis = model.getRundenErgebnis();
        String zeichen = (ergebnis > 0) ? "+" : "";
        view.getErgebnisLabel().setText("Rundenergebnis: " + zeichen + ergebnis);
        view.getPunkteLabel().setText("Punkte: " + model.getGesamtPunkte());


        if (ergebnis > 0) {
            view.getErgebnisLabel().setBackground(Color.GREEN);
        } else {
            view.getErgebnisLabel().setBackground(Color.RED);
        }


        if(model.hatGewonnen()){
            view.getPunkteLabel().setBackground(Color.GREEN);
            JOptionPane.showMessageDialog(view, "Du hast " + model.getGesamtPunkte() + " Punkte erreicht und Gewonnen!", "Gewonnen", JOptionPane.INFORMATION_MESSAGE);
            view.getSpielerZahlField().setEnabled(false);
            view.getResetBtn().setEnabled(false);
        }else if(model.hatVerloren()){
            view.getPunkteLabel().setBackground(Color.RED);
            JOptionPane.showMessageDialog(view, "Deine Punkte sind auf " + model.getGesamtPunkte() + ". Verloren!", "Verloren", JOptionPane.INFORMATION_MESSAGE);
            view.getSpielerZahlField().setEnabled(false);
            view.getResetBtn().setEnabled(false);
        }else{
            view.getPunkteLabel().setBackground(Color.WHITE);
            view.getSpielerZahlField().setEnabled(false);
            view.getResetBtn().setEnabled(true);
        }
    }

    /**
     * Bereitet die GUI auf die nächste Spielrunde vor:
     * Löscht Textfelder, setzt Label-Farben auf Weiß zurück und aktiviert das Eingabefeld wieder.
     */
    private void resetRunde() {
        view.getSpielerZahlField().setText("");
        view.getComputerZahlField().setText("");
        view.getErgebnisLabel().setText("Rundenergebnis: -");
        view.getErgebnisLabel().setBackground(Color.WHITE);
        view.getPunkteLabel().setBackground(Color.WHITE);
        view.getSpielerZahlField().setEnabled(true);
        view.getResetBtn().setEnabled(false);
    }
}

package ehajredini.controller;


import ehajredini.model.GewinnModel;
import ehajredini.view.GewinnView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view){
        this.model = model;
        this.view = view;
        addListeners();

    }

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

    private void spielzugAusfuehren(){
        String eingabe = view.getSpielerZahlField().getText().trim();
        int zahl;
        try{
            zahl = Integer.parseInt(eingabe);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Bitte eine Zahl von 1 bis 9 eingaben!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(zahl < 1 || zahl > 9){
            JOptionPane.showMessageDialog(null, "Die Zahl zwischen 1 und 9 liegen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        model.berechneRunde(zahl);

        view.getComputerZahlField().setText(String.valueOf(model.getComputerZahl()));
        int ergebnis = model.getRundenErgebnis();
        String zeichen = (ergebnis > 0) ? "+" : "";
        view.getErgebnisLabel().setText("Rundenergebnis: " + zeichen + ergebnis);
        view.getPunkteLabel().setText("Punkte: " + model.getGesamtPunkte());

        if(model.hatGewonnen()){
            JOptionPane.showMessageDialog(view, "Du hast 100 Punkte erreicht und Gewonnen!", "Gewonnen", JOptionPane.INFORMATION_MESSAGE);
        }else if(model.hatVerloren()){
            JOptionPane.showMessageDialog(view, "Deine Punkte sind auf 0. Verloren!", "Verloren", JOptionPane.INFORMATION_MESSAGE);

        }
        view.getSpielerZahlField().setEnabled(false);
        view.getResetBtn().setEnabled(true);

    }
    private void resetRunde() {
        view.getSpielerZahlField().setText("");
        view.getComputerZahlField().setText("");
        view.getErgebnisLabel().setText("Rundenergebnis: -");
        view.getSpielerZahlField().setEnabled(true);
        view.getResetBtn().setEnabled(false);

    }

}

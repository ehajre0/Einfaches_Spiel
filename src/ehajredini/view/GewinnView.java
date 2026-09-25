package ehajredini.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Die View des Zahlen-Gewinnspiels
 * Stellt die Benutzeroberfläche bereit
 *
 * @author Erdi Hajredini
 * @version 09/26/2026
 */
public class GewinnView extends JFrame {
    private JLabel rundenErgebnisLabel;
    private JLabel punkteLabel;
    private JTextField spielerZahlField;
    private JTextField computerZahlField;
    private JButton resetBtn;

    /**
     * Erstellt das GUI-Fenster und initialisiert alle Komponenten und Panels.
     */
    public GewinnView(){

        setTitle("Zahlen Gewinnspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));


        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10,20,5,10));

        rundenErgebnisLabel = new JLabel("Rundenergebnis: -", SwingConstants.CENTER);
        rundenErgebnisLabel.setOpaque(true);
        rundenErgebnisLabel.setBackground(Color.WHITE);
        rundenErgebnisLabel.setBorder(new LineBorder(Color.BLACK));
        rundenErgebnisLabel.setPreferredSize(new Dimension(0, 35));

        punkteLabel = new JLabel("Punkte: 30", SwingConstants.CENTER);
        punkteLabel.setOpaque(true);
        punkteLabel.setBackground(Color.WHITE);
        punkteLabel.setBorder(new LineBorder(Color.BLACK));
        punkteLabel.setPreferredSize(new Dimension(0, 35));

        topPanel.add(rundenErgebnisLabel);
        topPanel.add(punkteLabel);
        add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JLabel spielerPromptLabel = new JLabel("Tippe eine Zahl von 1 bis 9:", SwingConstants.CENTER);
        JLabel computerPromptLabel = new JLabel("Computer-Zahl:", SwingConstants.CENTER);

        spielerZahlField = new JTextField();
        spielerZahlField.setHorizontalAlignment(JTextField.CENTER);

        computerZahlField = new JTextField();
        computerZahlField.setHorizontalAlignment(JTextField.CENTER);
        computerZahlField.setEditable(false);

        centerPanel.add(spielerPromptLabel);
        centerPanel.add(computerPromptLabel);
        centerPanel.add(spielerZahlField);
        centerPanel.add(computerZahlField);

        add(centerPanel, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        resetBtn = new JButton("Noch einmal!");
        bottomPanel.add(resetBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public JLabel getErgebnisLabel() {
        return rundenErgebnisLabel;
    }

    public JLabel getPunkteLabel() {
        return punkteLabel;
    }

    public JTextField getSpielerZahlField() {
        return spielerZahlField;
    }

    public JTextField getComputerZahlField() {
        return computerZahlField;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }




}

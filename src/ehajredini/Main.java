package ehajredini;

import ehajredini.controller.GewinnController;
import ehajredini.model.GewinnModel;
import ehajredini.view.GewinnView;
/**
 * Startklasse für das Zahlen-Gewinnspiel.
 * Initialisiert Model, View und Controller nach dem MVC-Entwurfsmuster.
 *
 * @author Erdi Hajredini
 * @version 09/26/2026
 */
public class Main {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}
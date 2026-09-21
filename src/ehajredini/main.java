package ehajredini;

import ehajredini.controller.GewinnController;
import ehajredini.model.GewinnModel;
import ehajredini.view.GewinnView;

public class Main {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}
package ehajredini;

import ehajredini.controller.GewinnController;
import ehajredini.model.GewinnModel;
import ehajredini.view.GewinnView;

public class main {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}
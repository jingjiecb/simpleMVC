package Controller;

import Model.ModelInterface;
import View.View;

public class Controller implements ControllerInterface {
    ModelInterface model;
    View view;

    public Controller(ModelInterface model) {
        this.model = model;
        view = new View(this, model);
        model.initialize();
        view.init();
    }

    @Override
    public void input(String string) {
        switch (string) {
            case "exit":
                view.exit();
                break;
            case "save":
                model.save();
                view.getInput();
                break;
            case "\\n":
                model.addContent("\n");
                view.getInput();
                break;
            default:
                model.addContent(string);
                view.getInput();
                break;
        }
    }

}

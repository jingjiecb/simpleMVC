import Controller.Controller;
import Controller.ControllerInterface;
import Model.Model;
import Model.ModelInterface;

public class Application {
    public static void main(String[] args) {
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);
    }
}

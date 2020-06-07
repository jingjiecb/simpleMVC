package View;

import Controller.ControllerInterface;
import Model.ModelInterface;

import java.util.Scanner;

public class View implements Observer {
    ControllerInterface controller;
    ModelInterface model;
    Scanner scanner;

    public View(ControllerInterface controller, ModelInterface model) {
        this.controller = controller;
        this.model = model;
    }

    public void init() {
        model.registerObserver(this);
        System.out.println("Note Book Ready!");
        printNotebook();
        scanner = new Scanner(System.in);
        getInput();
    }

    public void getInput() {
        System.out.print("> ");
        String note = scanner.nextLine();
        controller.input(note);
    }

    public void exit() {
        System.out.println("Have a nice day!");
        System.exit(0);
    }

    @Override
    public void update() {
        System.out.println("You input more just now. Notebook update :");
        printNotebook();
    }

    private void printNotebook() {
        System.out.println("***** YOUR NOTEBOOK *****");
        System.out.println(model.getContent());
        System.out.println("*************************");
    }

}

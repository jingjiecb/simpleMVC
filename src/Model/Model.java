package Model;

import View.Observer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Model implements ModelInterface {
    StringBuffer buffer;
    ArrayList<Observer> observers;

    @Override
    public void initialize() {
        buffer = new StringBuffer();
        observers = new ArrayList<>();
        load();
    }

    @Override
    public void addContent(String string) {
        buffer.append(string);
        notifyObservers();
    }

    @Override
    public String getContent() {
        return buffer.toString();
    }

    @Override
    public void save() {
        try {
            File file = new File("data.nb");
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream writer = new PrintStream(fos);
            writer.print(buffer.toString());
            writer.flush();
            writer.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            File file = new File("data.nb");
            if (file.exists()) {
                FileInputStream fip = new FileInputStream(file);
                InputStreamReader reader = new InputStreamReader(fip, StandardCharsets.UTF_8);
                while (reader.ready()) {
                    buffer.append((char) reader.read());
                }
                reader.close();
                fip.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

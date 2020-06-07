package Model;

import View.Observer;

public interface ModelInterface {
    void initialize();

    void addContent(String string);

    String getContent();

    void save();

    void load();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

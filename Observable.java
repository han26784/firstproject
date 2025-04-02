import java.util.ArrayList;
import java.util.List;

public interface Observable {


    // add the observer to the subject
    void addObserver(Observer observer);


    // remove the observer
    void removeObserver(Observer observer);

    // noti all observers subject changed 

    void notifyObserver();

    
}

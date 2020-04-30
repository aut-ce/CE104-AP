package test;

import java.util.Observable;

public class DollarPriceObservable extends Observable {

    public void updateInfo() {

        // Calculate new price ...;
        Integer dollarPrice = 5_987;

        // Notify interested observers
        notifyObservers(dollarPrice);
    }

}

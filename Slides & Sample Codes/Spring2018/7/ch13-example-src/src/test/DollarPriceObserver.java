package test;

import java.util.Observable;
import java.util.Observer;

public class DollarPriceObserver implements Observer {

    @Override
    public void update(Observable sender, Object data) {
        Integer newPrice = (Integer) data;

        // do something about the new price ...;
    }
}

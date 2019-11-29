/*** In The Name of Allah ***/
package test;

import java.util.List;

/**
 * Example source codes about the 4 design patterns 
 * introduced in chapter-13 of BlueJ book.
 */
public class Main {

    public static void main(String[] args) {
        // Singleton pattern example
        Runtime runtime = Runtime.getRuntime();

        // Decorator pattern example
        Reader simpleReader = new SimpleReader();
        Reader decoratedReader = new BufferedReader(new CachedReader(simpleReader));
        decoratedReader.read();

        // Observer pattern example
        DollarPriceObservable dollarObservable = new DollarPriceObservable();
        dollarObservable.addObserver(new DollarPriceObserver());
        dollarObservable.addObserver(new DollarPriceObserver());
        dollarObservable.addObserver(new DollarPriceObserver());
        dollarObservable.updateInfo();

        // FactoryMethod pattern example
        List list = new java.util.ArrayList();
        list.iterator();
    }

}

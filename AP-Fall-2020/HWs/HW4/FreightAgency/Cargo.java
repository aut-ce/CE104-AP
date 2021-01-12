/**
 * Acts on each Cargo
 *
 * @author Narges Salehi & Mohammadreza Ghaderi
 * @version 1.1
 * @since October 2020
 */

public class Cargo {

    //Total cost of each cargo transportation
    public int price;
    //Distance of origin and destination of cargo transportation
    public int distance;
    //check cargo insurance
    public boolean insurance;
    //keeps destination of cargo as a code
    public int destination;
    //keeps origin of cargo as a code
    public int origin;
    //keeps overload value
    public int overload;
    //keeps weight of cargo
    public int weight;


    /**
     * Create a new Cargo
     */
    public Cargo() {
        //Default value of insurance is false - should be checked
        insurance = false;
    }

    /**
     * Set Price  of cargo
     */
    public void setPrice() {

    }

    /**
     * Get price of Cargo
     *
     * @return Price of cargo
     */
    public int getPrice() {
        return price;
    }

    /**
     * Calculate the Total cost of each cargo
     */
    public void calculatePrice() {

    }

    /**
     * Calculate the distance of origin and destination
     */
    public void calculateDistance() {

    }

    /**
     * Calculate cost of cargo weight
     */
    public void calculateWeightPrice() {

    }

    /**
     * Check if the cargo insured or not
     *
     * @return true or false
     */
    public boolean hasInsurance() {
        return insurance;
    }


    /**
     * Calculate overload of each Cargo
     */
    public void calculateOverload() {

    }

}


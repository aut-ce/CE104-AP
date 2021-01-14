/**
 * Acts on Air Cargoes
 *
 * @author Narges Salehi & Mohammadreza Ghaderi
 * @version 1.1
 * @since October 2020
 */
public class AirCargo extends Cargo {

    /**
     * Create a new AirCargo
     */
    public AirCargo() {
        super();
    }

    /**
     * Set the price of each AirCargo
     */
    @Override
    public void setPrice() {
        super.setPrice();

    }

    /**
     * the total price of AirCargo
     *
     * @return price
     */
    @Override
    public int getPrice() {
        return super.getPrice();
    }

    /**
     * Calculate total price of AirCargo
     */
    @Override
    public void calculatePrice() {
        super.calculatePrice();
    }

    /**
     * Calculate distance of origin and destination
     */
    @Override
    public void calculateDistance() {
        super.calculateDistance();
    }

    @Override
    public void calculateWeightPrice() {
        super.calculateWeightPrice();
    }

    /**
     * Check if the cargo is insured or not
     *
     * @return true or false
     */
    @Override
    public boolean hasInsurance() {
        return super.hasInsurance();
    }

    /**
     * Calculate overload
     */
    @Override
    public void calculateOverload() {
        super.calculateOverload();
    }
}

import java.util.ArrayList;

/**
 * Keeps Cargoes data
 *
 * @author Narges Salehi & Mohammadreza Ghaderi
 * @version 1.1
 * @since October 2020
 */
public class FreightAgency {
    //keeps cargoes
    ArrayList<Cargo> cargoes;
    //keeps Clients
    ArrayList<Client> clients;

    /**
     * Create a new FreightAgency
     */
    public FreightAgency() {
        cargoes = new ArrayList<>();
        clients=new ArrayList<>();
    }

    /**
     * Add Cargo to CargoList
     *
     * @param cargo we want to add
     */
    public void addCargo(Cargo cargo) {
        cargoes.add(cargo);
    }

    /**
     * Remove a cargo from CargoList
     *
     * @param cargo we want to add
     */
    public void removeCargo(Cargo cargo) {
        cargoes.remove(cargo);
    }

    /**
     * Show list of cargoes
     */
    public void showCargoList() {

    }


}

import java.util.ArrayList;

/**
 * Acts on Client information
 *  @author Narges Salehi & Mohammadreza Ghaderi
 *  @version 1.1
 *  @since October 2020
 */
public class Client {
    //first name of client
    public String FirstName;
    //last name of client
    public String LastName;
    //list of client cargoes
    public ArrayList<Cargo> cargoes;

    public Client(){
        cargoes=new ArrayList<>();
    }

    public void addCargo(){

    }
}

package org.han.ica.oose.boterbloem.domain.domainObjects;


import java.util.ArrayList;
import java.util.List;

public class CareInstitution  {
    private List<Address> addresses =  new ArrayList<>();
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for property 'addresses'.
     *
     * @return Value for property 'addresses'.
     */

    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Setter for property 'addresses'.
     *
     * @param addresses Value to set for property 'addresses'.
     */

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */

    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */

    public void setName(String name) {
        this.name = name;
    }
}

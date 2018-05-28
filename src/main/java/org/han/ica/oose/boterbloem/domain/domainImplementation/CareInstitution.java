package org.han.ica.oose.boterbloem.domain.domainImplementation;

import org.han.ica.oose.boterbloem.domain.ICareInstitution;

import java.util.ArrayList;
import java.util.List;

public class CareInstitution implements ICareInstitution {

    private List<Address> addresses =  new ArrayList<>();
    private String name;

    /**
     * Getter for property 'addresses'.
     *
     * @return Value for property 'addresses'.
     */
    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Setter for property 'addresses'.
     *
     * @param addresses Value to set for property 'addresses'.
     */
    @Override
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
}

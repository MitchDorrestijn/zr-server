package org.han.ica.oose.boterbloem.domain;

import org.han.ica.oose.boterbloem.domain.domainImplementation.Address;

import java.util.List;

public interface ICareInstitution {

    List<Address> getAddresses();

    void setAddresses(List<Address> addresses);

    String getName();

    void setName(String name);
}

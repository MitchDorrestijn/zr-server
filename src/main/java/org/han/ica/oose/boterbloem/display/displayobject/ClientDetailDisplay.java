package org.han.ica.oose.boterbloem.display.displayobject;

import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;

import java.util.List;

public class ClientDetailDisplay {
    private ClientEntity client;
    int careId;
    private List<String> limitations;

    /**
     * Getter for property 'client'.
     *
     * @return Value for property 'client'.
     */
    public ClientEntity getClient() {
        return client;
    }

    /**
     * Setter for property 'client'.
     *
     * @param client Value to set for property 'client'.
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }

    /**
     * Getter for property 'limitations'.
     *
     * @return Value for property 'limitations'.
     */
    public List<String> getLimitations() {
        return limitations;
    }

    /**
     * Setter for property 'limitations'.
     *
     * @param limitations Value to set for property 'limitations'.
     */
    public void setLimitations(List<String> limitations) {
        this.limitations = limitations;
    }
}

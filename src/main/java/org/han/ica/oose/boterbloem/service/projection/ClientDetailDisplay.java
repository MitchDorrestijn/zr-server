package org.han.ica.oose.boterbloem.service.projection;

import org.han.ica.oose.boterbloem.entity.ClientEntity;

import java.util.ArrayList;

public class ClientDetailDisplay {
    private ClientEntity client;
    private ArrayList <String> limitations;

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
    public ArrayList <String> getLimitations() {
        return limitations;
    }

    /**
     * Setter for property 'limitations'.
     *
     * @param limitations Value to set for property 'limitations'.
     */
    public void setLimitations(ArrayList <String> limitations) {
        this.limitations = limitations;
    }
}

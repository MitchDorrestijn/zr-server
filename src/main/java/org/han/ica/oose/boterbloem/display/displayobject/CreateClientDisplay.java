package org.han.ica.oose.boterbloem.display.displayobject;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;

import java.util.List;

public class CreateClientDisplay {
    private String utility;
    private ClientEntity clientEntity;
    private boolean companionForced;
    private List<String> limitations;

    /**
     * Getter for property 'utility'.
     *
     * @return Value for property 'utility'.
     */
    public String getUtility() {
        return utility;
    }

    /**
     * Setter for property 'utility'.
     *
     * @param utility Value to set for property 'utility'.
     */
    public void setUtility(String utility) {
        this.utility = utility;
    }

    /**
     * Getter for property 'clientEntity'.
     *
     * @return Value for property 'clientEntity'.
     */
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    /**
     * Setter for property 'clientEntity'.
     *
     * @param clientEntity Value to set for property 'clientEntity'.
     */
    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    /**
     * Getter for property 'companionForced'.
     *
     * @return Value for property 'companionForced'.
     */
    public boolean isCompanionForced() {
        return companionForced;
    }

    /**
     * Setter for property 'companionForced'.
     *
     * @param companionForced Value to set for property 'companionForced'.
     */
    public void setCompanionForced(boolean companionForced) {
        this.companionForced = companionForced;
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

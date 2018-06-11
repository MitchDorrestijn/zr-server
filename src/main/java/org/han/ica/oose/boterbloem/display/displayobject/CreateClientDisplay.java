package org.han.ica.oose.boterbloem.display.displayobject;


import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;

import java.util.List;

public class CreateClientDisplay {
    private String utility;
    int careId;
    private ClientEntity client;
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

    /**
     * Getter for property 'careId'.
     *
     * @return Value for property 'careId'.
     */
    public int getCareId() {
        return careId;
    }

    /**
     * Setter for property 'careId'.
     *
     * @param careId Value to set for property 'careId'.
     */
    public void setCareId(int careId) {
        this.careId = careId;
    }
}

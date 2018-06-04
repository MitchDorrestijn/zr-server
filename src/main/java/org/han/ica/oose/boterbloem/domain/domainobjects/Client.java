package org.han.ica.oose.boterbloem.domain.domainobjects;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private int id;
    // Supervisor of the client
    private String companion;
    // Show warning
    private boolean warningPkb;
    // Personal kilometer budget
    private int pkb;
    // A superviser is required
    private byte companionRequired;
    private String image;
    // bankaccount number.
    private String bankAccount;
    private List<Limitation> limitations = new ArrayList<>();

    /**
     * Getter for property 'warningPkb'.
     *
     * @return Value for property 'warningPkb'.
     */
    public boolean getWarningPkb() {
        return warningPkb;
    }

    /**
     * Setter for property 'warningPkb'.
     *
     * @param warningPkb Value to set for property 'warningPkb'.
     */
    public void setWarningPKB(boolean warningPkb) {
        this.warningPkb = warningPkb;
    }

    /**
     * Getter for property 'pkb'.
     *
     * @return Value for property 'pkb'.
     */
    public int getpkb() {
        return pkb;
    }

    /**
     * Setter for property 'pkb'.
     *
     * @param pkb Value to set for property 'pkb'.
     */
    public void setpkb(int pkb) {
        this.pkb = pkb;
    }

    /**
     * Getter for property 'companionRequired'.
     *
     * @return Value for property 'companionRequired'.
     */
    public byte getCompanionRequired() {
        return companionRequired;
    }

    /**
     * Setter for property 'companionRequired'.
     *
     * @param companionRequired Value to set for property 'companionRequired'.
     */
    public void setCompanionRequired(byte companionRequired) {
        this.companionRequired = companionRequired;
    }

    /**
     * Getter for property 'image'.
     *
     * @return Value for property 'image'.
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter for property 'image'.
     *
     * @param image Value to set for property 'image'.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter for property 'bankAccount'.
     *
     * @return Value for property 'bankAccount'.
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * Setter for property 'bankAccount'.
     *
     * @param bankAccount Value to set for property 'bankAccount'.
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Getter for property 'limitations'.
     *
     * @return Value for property 'limitations'.
     */
    public List<Limitation> getLimitations() {
        return limitations;
    }

    /**
     * Setter for property 'limitations'.
     *
     * @param limitations Value to set for property 'limitations'.
     */
    public void setLimitations(List<Limitation> limitations) {
        this.limitations = limitations;
    }

    public void addLimitation(Limitation limitation) {
        this.limitations.add(limitation);
    }

    /**
     * Getter for property 'companion'.
     *
     * @return Value for property 'companion'.
     */
    public String getCompanion() {
        return companion;
    }

    /**
     * Setter for property 'companion'.
     *
     * @param companion Value to set for property 'companion'.
     */
    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

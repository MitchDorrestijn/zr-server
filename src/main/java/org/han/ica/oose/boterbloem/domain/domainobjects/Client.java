package org.han.ica.oose.boterbloem.domain.domainobjects;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    // Supervisor of the client
    private String companion;
    // Show warning
    private byte warningpkb;
    // Personal kilometer budget
    private int pkb;
    // A superviser is required
    private byte companionRequired;
    private String image;
    // bankaccount number.
    private String bankAccount;
    private List<Limitation> limitations = new ArrayList<>();

    /**
     * Getter for property 'warningpkb'.
     *
     * @return Value for property 'warningpkb'.
     */
    public byte getWarningpkb() {
        return warningpkb;
    }

    /**
     * Setter for property 'warningpkb'.
     *
     * @param warningpkb Value to set for property 'warningpkb'.
     */
    public void setWarningpkb(byte warningpkb) {
        this.warningpkb = warningpkb;
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
}

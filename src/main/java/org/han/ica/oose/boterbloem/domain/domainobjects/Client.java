package org.han.ica.oose.boterbloem.domain.domainobjects;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private String companion; // Supervisor of the client
    private byte warningPKB; // Show warning
    private int PKB; // Personal kilometer budget
    private byte companionRequired; // A superviser is required
    private String image;
    private String bankAccount; // bankaccount number.
    private List<Limitation> limitations = new ArrayList<>();

    /**
     * Getter for property 'warningPKB'.
     *
     * @return Value for property 'warningPKB'.
     */
    public byte getWarningPKB() {
        return warningPKB;
    }

    /**
     * Setter for property 'warningPKB'.
     *
     * @param warningPKB Value to set for property 'warningPKB'.
     */
    public void setWarningPKB(byte warningPKB) {
        this.warningPKB = warningPKB;
    }

    /**
     * Getter for property 'PKB'.
     *
     * @return Value for property 'PKB'.
     */
    public int getPKB() {
        return PKB;
    }

    /**
     * Setter for property 'PKB'.
     *
     * @param PKB Value to set for property 'PKB'.
     */
    public void setPKB(int PKB) {
        this.PKB = PKB;
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

package org.han.ica.oose.boterbloem.service.projection;

public class ClientDisplay {
    private int clientId;
    private String companion;
    private String utility;
    private boolean driverPreferenceForced;
    private int PKB;
    private int totalMeters;
    private String name;
    private boolean warningPKB;
    private double priceToPay;


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public boolean isDriverPreferenceForced() {
        return driverPreferenceForced;
    }

    public void setDriverPreferenceForced(boolean driverPreferenceForced) {
        this.driverPreferenceForced = driverPreferenceForced;
    }

    public int getPKB() {
        return PKB;
    }

    public void setPKB(int PKB) {
        this.PKB = PKB;
    }

    public int getTotalMeters() {
        return totalMeters;
    }

    public void setTotalMeters(int totalMeters) {
        this.totalMeters = totalMeters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWarningPKB() {
        return warningPKB;
    }

    public void setWarningPKB(boolean warningPKB) {
        this.warningPKB = warningPKB;
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }
}

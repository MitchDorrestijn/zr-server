package org.han.ica.oose.boterbloem.display.displayobject;

import java.sql.Timestamp;

public class RidesByCareinstitutionDisplay {

    private byte excepted;
    private String pickUpLocation;
    private String dropOfLocation;
    private Timestamp pickUpDateTime;
    private boolean driverAssigned = false;
    private String driverName = "";
    private String clientName = "";


    /**
     * Checks if driver is assigned and sets it to true
     */
    public void checkIfDriverAssigned() {
        if (!this.driverName.equals("")) {
            this.driverAssigned = true;
        }
    }

    /**
     * Getter for property 'excepted'.
     *
     * @return Value for property 'excepted'.
     */
    public byte getExcepted() {
        return excepted;
    }

    /**
     * Setter for property 'excepted'.
     *
     * @param excepted Value to set for property 'excepted'.
     */
    public void setExcepted(byte excepted) {
        this.excepted = excepted;
    }

    /**
     * Getter for property 'pickUpLocation'.
     *
     * @return Value for property 'pickUpLocation'.
     */
    public String getPickUpLocation() {
        return pickUpLocation;
    }

    /**
     * Setter for property 'pickUpLocation'.
     *
     * @param pickUpLocation Value to set for property 'pickUpLocation'.
     */
    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    /**
     * Getter for property 'dropOfLocation'.
     *
     * @return Value for property 'dropOfLocation'.
     */
    public String getDropOfLocation() {
        return dropOfLocation;
    }

    /**
     * Setter for property 'dropOfLocation'.
     *
     * @param dropOfLocation Value to set for property 'dropOfLocation'.
     */
    public void setDropOfLocation(String dropOfLocation) {
        this.dropOfLocation = dropOfLocation;
    }

    /**
     * Getter for property 'pickUpDateTime'.
     *
     * @return Value for property 'pickUpDateTime'.
     */
    public Timestamp getPickUpDateTime() {
        return pickUpDateTime;
    }

    /**
     * Setter for property 'pickUpDateTime'.
     *
     * @param pickUpDateTime Value to set for property 'pickUpDateTime'.
     */
    public void setPickUpDateTime(Timestamp pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    /**
     * Getter for property 'driverAssigned'.
     *
     * @return Value for property 'driverAssigned'.
     */
    public boolean isDriverAssigned() {
        return driverAssigned;
    }

    /**
     * Setter for property 'driverAssigned'.
     *
     * @param driverAssigned Value to set for property 'driverAssigned'.
     */
    public void setDriverAssigned(boolean driverAssigned) {
        this.driverAssigned = driverAssigned;
    }

    /**
     * Getter for property 'driverName'.
     *
     * @return Value for property 'driverName'.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Setter for property 'driverName'.
     *
     * @param driverName Value to set for property 'driverName'.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Getter for property 'clientName'.
     *
     * @return Value for property 'clientName'.
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Setter for property 'clientName'.
     *
     * @param clientName Value to set for property 'clientName'.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
